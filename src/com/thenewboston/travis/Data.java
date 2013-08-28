package com.thenewboston.travis;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Data extends Activity implements OnClickListener {

	EditText sentET;
	Button start, startFor;
	TextView gotAnswer;
	
	


//////////////////////////////////////////////////////////////////////////////////////

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.get);
		initialiseVars();
	}

	
//////////////////////////////////////////////////////////////////////////////////////


	private void initialiseVars() {
		// TODO Auto-generated method stub
		sentET = (EditText) findViewById(R.id.et_Send);
		start = (Button) findViewById(R.id.b_StartActivity);
		startFor = (Button) findViewById(R.id.b_StartActivityForResult);
		gotAnswer = (TextView) findViewById(R.id.tv_Got);
		start.setOnClickListener(this);
		startFor.setOnClickListener(this);
		
	}

	
//////////////////////////////////////////////////////////////////////////////////////


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}

	
//////////////////////////////////////////////////////////////////////////////////////


}
