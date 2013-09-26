package com.thenewboston.travis;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SQLiteExample extends Activity implements OnClickListener {

	EditText name, hotness;
	Button update, view;
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlliteexample);
		initialiseVars();
		clicks();
	}

	
	
	private void clicks() {
		// TODO Auto-generated method stub
		update.setOnClickListener(this);
		view.setOnClickListener(this);
	}



	private void initialiseVars() {
		// TODO Auto-generated method stub
		name = (EditText) findViewById(R.id.et_sqlName);
		hotness = (EditText) findViewById(R.id.et_sqlHotness);
		update = (Button) findViewById(R.id.b_sqlUpdateData);
		view = (Button) findViewById(R.id.b_sqlView);
	}

	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()) {
		
		case R.id.b_sqlUpdateData:
			
			break;
			
		case R.id.b_sqlView:
			
			break;
			
		}
		
	}

}
