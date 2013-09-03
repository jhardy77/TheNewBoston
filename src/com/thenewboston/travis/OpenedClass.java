package com.thenewboston.travis;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener, OnCheckedChangeListener {

	TextView question, text;
	Button returnData;
	RadioGroup selectionList;
	String gotBread;
	

//////////////////////////////////////////////////////////////////////////////////////

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		InitialiseVars();
		
		//Gets the data from Data.java Tutorial 48
		Bundle gotBasket = getIntent().getExtras();
		gotBread = gotBasket.getString("key");
		question.setText(gotBread);
		
		
	}


//////////////////////////////////////////////////////////////////////////////////////

	
	private void InitialiseVars() {
		// TODO Auto-generated method stub
		question = (TextView) findViewById(R.id.tv_Question);
		text = (TextView) findViewById(R.id.tv_Text);
		returnData = (Button) findViewById(R.id.b_Return);
		returnData.setOnClickListener(this);
		selectionList = (RadioGroup) findViewById(R.id.rg_Answers);
		selectionList.setOnCheckedChangeListener(this);
	}

	
//////////////////////////////////////////////////////////////////////////////////////


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}


//////////////////////////////////////////////////////////////////////////////////////


	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		switch(arg1) {
		case R.id.r_Crazy:
			
			break;
			
		case R.id.r_Sexy:
			
			break;
			
		case R.id.r_Both:
			
			break;
		}
	}

	
//////////////////////////////////////////////////////////////////////////////////////


}