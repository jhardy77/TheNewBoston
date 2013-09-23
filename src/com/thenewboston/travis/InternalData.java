package com.thenewboston.travis;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InternalData extends Activity implements OnClickListener {

	EditText data;
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
		data = (EditText) findViewById(R.id.et_SharedPrefs);
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
			
			break;
			
		case R.id.b_Load:
			
			
			break;
			
		}
		
	}

}
