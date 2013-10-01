package com.thenewboston.travis;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;

public class SQLView extends Activity {

	TextView tv;
	TableLayout tl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlview);
		initializeVars();
		HotOrNot info = new HotOrNot(SQLView.this);
		info.open();
		String data = info.getData();
		info.close();
		tv.setText(data);
	}

	private void initializeVars() {
		// TODO Auto-generated method stub
		tv = (TextView) findViewById(R.id.tv_SQLinfo);
		tl = (TableLayout) findViewById(R.id.tl_tableLayout1);
	}

}
