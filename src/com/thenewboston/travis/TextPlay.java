package com.thenewboston.travis;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		
		Button chkCmd = (Button) findViewById(R.id.b_Results);
		final ToggleButton passTog = (ToggleButton) findViewById(R.id.tb_password);
		final EditText input = (EditText) findViewById(R.id.et_Commands);
		TextView display = (TextView) findViewById(R.id.tv_Results);
		
		passTog.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (passTog.isChecked()) {
					input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				} else {
					input.setInputType(InputType.TYPE_CLASS_TEXT);
				}
				
			}
		});

	}

}