package com.thenewboston.travis;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
			
			boolean didItWork = true;
			try {
				String getName = name.getText().toString();
				String getHotness = hotness.getText().toString();
				
				HotOrNot entry = new HotOrNot(SQLiteExample.this);
				entry.open();
				entry.createEntry(getName, getHotness);
				
				entry.close();
				
			} catch (Exception e) {
				didItWork = false;
			} finally {
				if (didItWork) {
					Dialog d = new Dialog(this);
					d.setTitle("Heck Yea!");
					TextView  tv = new TextView(this);
					tv.setText("Success");
					d.setContentView(tv);
					d.show();
				}
			}
			
			break;
			
		case R.id.b_sqlView:
			Intent i = new Intent("com.thenewboston.travis.SQLVIEW");
			startActivity(i);
			break;
			
		}
		
	}

}
