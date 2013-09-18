package com.thenewboston.travis;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

public class Slider extends Activity implements OnClickListener, OnCheckedChangeListener, OnDrawerOpenListener {

	Button handle1, handle2, handle3, handle4;
	CheckBox checkbox;
	SlidingDrawer sd;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sliding);
		initialiseVars();
		checkbox.setOnCheckedChangeListener(this);
		handle1.setOnClickListener(this);
		handle2.setOnClickListener(this);
		handle3.setOnClickListener(this);
		handle4.setOnClickListener(this);
		sd.setOnDrawerOpenListener(this);
		
		
	}

	private void initialiseVars() {
		// TODO Auto-generated method stub
		handle1 = (Button) findViewById(R.id.button1);
		handle2 = (Button) findViewById(R.id.button2);
		handle3 = (Button) findViewById(R.id.button3);
		handle4 = (Button) findViewById(R.id.button4);
		checkbox = (CheckBox) findViewById(R.id.cb_slide);
		sd = (SlidingDrawer) findViewById(R.id.slidingD);
	}

	
	
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		
		case R.id.button1:
			sd.open();
			break;
			
		case R.id.button2:
			
			break;
			
		case R.id.button3:
			sd.toggle();
			break;
			
		case R.id.button4:
			sd.close();
			break;
		
		}
		
	}



	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		// TODO Auto-generated method stub
		if (arg0.isChecked()) {
			sd.lock();
		} else {
			sd.unlock();
		}	
	}

	
	
	@Override
	public void onDrawerOpened() {
		// TODO Auto-generated method stub
		MediaPlayer mp = MediaPlayer.create(this, R.raw.explosion);
		mp.start();
	}

	
	
	
}
