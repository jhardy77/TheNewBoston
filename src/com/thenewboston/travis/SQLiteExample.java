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

		// Sets the content view
		setContentView(R.layout.sqlliteexample);

		// Initializes the variables passed in
		initializeVars();

		// Sets the OnClick Events
		SetsOnClickEvents();
	}

	private void initializeVars() {
		// TODO Auto-generated method stub
		name = (EditText) findViewById(R.id.et_sqlName);
		hotness = (EditText) findViewById(R.id.et_sqlHotness);
		update = (Button) findViewById(R.id.b_sqlUpdateData);
		view = (Button) findViewById(R.id.b_sqlView);
	}

	private void SetsOnClickEvents() {
		// TODO Auto-generated method stub
		update.setOnClickListener(this);
		view.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {

		case R.id.b_sqlUpdateData:

			boolean didItWork = true;
			
			try {
				// Gets any data from the et_sqlName
				String getName = name.getText().toString();

				// Gets any data from the et_sqlHotness
				String getHotness = hotness.getText().toString();

				HotOrNot entry = new HotOrNot(SQLiteExample.this);
				entry.open();
				entry.createEntry(getName, getHotness);
				entry.close();
			} catch (Exception e) {
				didItWork = false;
				String error = e.toString();
				Dialog d = new Dialog(SQLiteExample.this);
				d.setTitle("Dang it");
				TextView tv = new TextView(SQLiteExample.this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
				
				
			} finally {
				if (didItWork) {
					Dialog d = new Dialog(SQLiteExample.this);
					d.setTitle("Heck Yea!");
					TextView tv = new TextView(SQLiteExample.this);
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
