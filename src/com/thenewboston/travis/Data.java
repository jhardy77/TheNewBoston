package com.thenewboston.travis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Data extends Activity implements OnClickListener {

	EditText sendET;
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
		sendET = (EditText) findViewById(R.id.et_Send);
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
		switch (arg0.getId()) {
		case R.id.b_StartActivity:
			
			//Passing data out Tutorial 47
			String bread = sendET.getText().toString();
			Bundle basket = new Bundle();
			basket.putString("key", bread);
			Intent a = new Intent(Data.this, OpenedClass.class);
			a.putExtras(basket);
			startActivity(a);
			break;
			
		case R.id.b_StartActivityForResult:
			Intent i = new Intent(Data.this, OpenedClass.class);
			startActivityForResult(i, 0);
			break;
		}
		
	}

	
//////////////////////////////////////////////////////////////////////////////////////


}
