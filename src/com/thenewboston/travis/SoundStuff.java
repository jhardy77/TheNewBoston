package com.thenewboston.travis;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class SoundStuff extends Activity implements OnClickListener {

	SoundPool sp;
	int explosion;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		View v = new View(this);
		v.setOnClickListener(this);
		setContentView(v);
		sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		explosion = sp.load(this, R.raw.explosion, 1);
		
	}

	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
