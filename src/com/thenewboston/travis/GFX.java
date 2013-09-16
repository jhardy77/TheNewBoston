package com.thenewboston.travis;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public class GFX extends Activity {

	MyBringBack ourView;
	WakeLock wl;
	PowerManager pm;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		//Wait Clock, Video 78
		pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
		wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "whatever");
		
		super.onCreate(savedInstanceState);

		ourView = new MyBringBack(this);
		setContentView(ourView);		
		
	}


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		wl.release();
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		wl.acquire();
	}
	
	
	

}
