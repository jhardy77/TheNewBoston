package com.thenewboston.travis;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPrefs extends Activity implements OnClickListener {

	
	EditText data;
	Button save, load;
	TextView dataResults;
	public static String filename = "MySharedString";
	SharedPreferences someData;
	


//////////////////////////////////////////////////////////////////////////////////////


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.sharedprefs);
		initiliseVars();
		save.setOnClickListener(this);
		load.setOnClickListener(this);
		someData = getSharedPreferences(filename, 0);
		
		
	}


//////////////////////////////////////////////////////////////////////////////////////


private void initiliseVars() {
	// TODO Auto-generated method stub
	data = (EditText) findViewById(R.id.et_SharedPrefs);
	save = (Button) findViewById(R.id.b_Save);
	load = (Button) findViewById(R.id.b_Load);
	dataResults = (TextView) findViewById(R.id.tv_LoadSharedPrefs);
	
}


//////////////////////////////////////////////////////////////////////////////////////


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.b_Save:
			//Gets the text from the EditText field and convert it to a string
			String stringData = data.getText().toString();
			SharedPreferences.Editor editor = someData.edit();
			editor.putString("sharedString", stringData);
			editor.commit();
			break;
			
		case R.id.b_Load:
			someData = getSharedPreferences(filename, 0);
			String dataReturned = someData.getString("sharedString", "Couldn't Load Data");
			dataResults.setText(dataReturned);
			
			break;
			
		}
		
	}

}
