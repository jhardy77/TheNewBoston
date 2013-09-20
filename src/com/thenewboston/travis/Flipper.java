package com.thenewboston.travis;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class Flipper extends Activity implements OnClickListener {

	ViewFlipper flippy;
	Button vfButton;
	TextView tv2, tv3, tv4;


//////////////////////////////////////////////////////////////////////////////////////


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.flipper);
		initialiseVars();
		flippy.setOnClickListener(this);
		flippy.setFlipInterval(1000);
		flippy.startFlipping();
		
		
	}


//////////////////////////////////////////////////////////////////////////////////////


	private void initialiseVars() {
		// TODO Auto-generated method stub
		flippy = (ViewFlipper) findViewById(R.id.viewFlipper1);
		
		
	}


//////////////////////////////////////////////////////////////////////////////////////


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		flippy.showNext();
		
	}
	
	

}
