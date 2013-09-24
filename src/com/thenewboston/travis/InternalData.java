package com.thenewboston.travis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InternalData extends Activity implements OnClickListener {

	EditText sharedData;
	Button save, load;
	TextView dataResults;
	FileOutputStream fos;
	String FILENAME = "InternalString";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.sharedprefs);
		initiliseVars();
		save.setOnClickListener(this);
		load.setOnClickListener(this);

	}

	private void initiliseVars() {
		// TODO Auto-generated method stub
		sharedData = (EditText) findViewById(R.id.et_SharedPrefs);
		save = (Button) findViewById(R.id.b_Save);
		load = (Button) findViewById(R.id.b_Load);

		dataResults = (TextView) findViewById(R.id.tv_LoadSharedPrefs);
		try {
			fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.b_Save:
			String data = sharedData.getText().toString();

			// Saving data via file
			/*
			 * File f = new File(FILENAME); try { fos = new FileOutputStream(f);
			 * 
			 * //write some data here
			 * 
			 * 
			 * fos.close();
			 * 
			 * } catch (FileNotFoundException e) { // TODO Auto-generated catch
			 * block e.printStackTrace(); } catch (IOException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */

			try {
				fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
				fos.write(data.getBytes());
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case R.id.b_Load:
			new LoadSumeStuff().execute(FILENAME);
			break;

		}

	}

	public class LoadSumeStuff extends AsyncTask<String, Integer, String> {

		protected void onPreExecute(String f) {
			// example of setting up something
			f = "whatever";
		}

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub

			String collected = null;
			FileInputStream fis = null;

			try {
				fis = openFileInput(FILENAME);
				byte[] dataArray = new byte[fis.available()];
				while (fis.read(dataArray) != -1) {
					collected = new String(dataArray);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fis.close();
					return collected;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return null;
		}

		protected void onProgressUpdated(Integer... progress) {

		}

		protected void onPostExecute(String result) {
			dataResults.setText(result);
		}

	}

}
