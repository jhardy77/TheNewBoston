package com.thenewboston.travis;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartingPoint extends Activity {

	int counter;
	Button add, sub;
	TextView display;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_starting_point);

		counter = 0;
		initialise();

		add.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				counter++;
				display.setText("Your total is " + counter);

			}
		});

		sub.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				counter--;
				display.setText("Your total is " + counter);

			}
		});
	}

	private void initialise() {
		add = (Button) findViewById(R.id.b_add_one);
		sub = (Button) findViewById(R.id.b_subtract_one);
		display = (TextView) findViewById(R.id.tv_add_sub_display);
	}

}
