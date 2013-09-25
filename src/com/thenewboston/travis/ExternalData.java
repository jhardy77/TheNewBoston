package com.thenewboston.travis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ExternalData extends Activity implements OnItemSelectedListener, OnClickListener {

	TextView canWrite, canRead;
	String state;
	boolean canW, canR;
	Spinner spinner;
	String[] paths = {"Music", "Picture", "Downloads"};
	File path = null;
	File file = null;
	EditText saveAs;
	Button confirmSaveAs, saveFile;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.externaldata);
		initiVars();
		onClicks();
		checkStorage();
		populateSpinner();

	}

	
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.b_ConfirmSaveAs:
			saveFile.setVisibility(View.VISIBLE);
			break;
			
		case R.id.b_SaveFile:
			String saveName = saveAs.getText().toString();
			file = new File(path, saveName + ".png");
			
			checkStorage();
			
			if (canW == canR == true) {
				
				path.mkdirs();
				
				try {
					InputStream is = getResources().openRawResource(R.drawable.greenball);
					OutputStream os = new FileOutputStream(file);
					byte[] data = new byte[is.available()];
					is.read(data);
					os.write(data);
					is.close();
					os.close();
					
					Toast t = Toast.makeText(ExternalData.this, "File has been saved", Toast.LENGTH_LONG);
					t.show();
					
					//This updates the media so that it appears straight away after it writes the file.
					MediaScannerConnection.scanFile(
							ExternalData.this, 
							new String[] {file.toString()}, 
							null, 
							new MediaScannerConnection.OnScanCompletedListener() {
								
								@Override
								public void onScanCompleted(String path, Uri uri) {
									// TODO Auto-generated method stub
									Toast t = Toast.makeText(ExternalData.this, "Scan Complete", Toast.LENGTH_SHORT);
									t.show();
								}
							});
					
					
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
		}
		
	}
	

	
	
	private void onClicks() {
		// TODO Auto-generated method stub
		confirmSaveAs.setOnClickListener(this);
		saveFile.setOnClickListener(this);
	}




	private void initiVars() {
		// TODO Auto-generated method stub
		canWrite = (TextView) findViewById(R.id.tv_canWrite);
		canRead = (TextView) findViewById(R.id.tv_canRead);
		spinner = (Spinner) findViewById(R.id.spinner1);
		saveAs = (EditText) findViewById(R.id.et_SaveAs);
		confirmSaveAs = (Button) findViewById(R.id.b_ConfirmSaveAs);
		saveFile = (Button) findViewById(R.id.b_SaveFile);
		
	}
	
	
	
	
	
	private void populateSpinner() {
		// TODO Auto-generated method stub
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(ExternalData.this, android.R.layout.simple_spinner_item, paths);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
	}
	
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		int position = spinner.getSelectedItemPosition();
		switch (position) {
		case 0:
			path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
			break;
			
		case 1:
			path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
			break;
			
		case 2:
			path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
			break;
		
		}
		
	}




	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}




	private void checkStorage() {
		// TODO Auto-generated method stub
		state = Environment.getExternalStorageState();
		if (state.equals(Environment.MEDIA_MOUNTED)) {
			//Read and Write
			canWrite.setText("true");
			canRead.setText("true");
			canW = canR = true;
			
		} else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
			//Read but can't write
			canWrite.setText("false");
			canRead.setText("true");
			canW = false;
			canR = true;
			
			
		} else {
			canWrite.setText("false");
			canRead.setText("false");
			canW = canR = false;
			
		}
	}




	




	




	

	
	
	
	
}
