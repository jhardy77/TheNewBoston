package com.thenewboston.travis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener, OnCheckedChangeListener {

	TextView question, test;
	Button returnData;
	RadioGroup selectionList;
	String gotBread, setData;
	

//////////////////////////////////////////////////////////////////////////////////////

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		InitialiseVars();
		
		//Gets the data from Data.java Tutorial 48
		//Bundle gotBasket = getIntent().getExtras();
		//gotBread = gotBasket.getString("key");
		//question.setText(gotBread);
		
		
	}


//////////////////////////////////////////////////////////////////////////////////////

	
	private void InitialiseVars() {
		// TODO Auto-generated method stub
		question = (TextView) findViewById(R.id.tv_Question);
		test = (TextView) findViewById(R.id.tv_Text);
		returnData = (Button) findViewById(R.id.b_Return);
		returnData.setOnClickListener(this);
		selectionList = (RadioGroup) findViewById(R.id.rg_Answers);
		selectionList.setOnCheckedChangeListener(this);
	}

	
//////////////////////////////////////////////////////////////////////////////////////


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		//Video 50, parsing data back to Data.java
		Intent person = new Intent(OpenedClass.this, Data.class);
		Bundle backpack = new Bundle();
		backpack.putString("answer", setData);
		person.putExtras(backpack);
		setResult(RESULT_OK, person);
		finish();

	}


//////////////////////////////////////////////////////////////////////////////////////


	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		switch(arg1) {
		case R.id.r_Crazy:
			setData = "Probably right";
			break;
			
		case R.id.r_Sexy:
			setData = "Definately right";
			break;
			
		case R.id.r_Both:
			setData = "Spot on right";
			break;
		}
		test.setText(setData);
	}

	
//////////////////////////////////////////////////////////////////////////////////////


}
