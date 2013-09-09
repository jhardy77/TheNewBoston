package com.thenewboston.travis;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity {
	
	MediaPlayer ourSong;

	@Override
	protected void onCreate(Bundle TravisLovesBacon) {
		super.onCreate(TravisLovesBacon);
		setContentView(R.layout.splash);
		
		ourSong = MediaPlayer.create(Splash.this, R.raw.splash_sound);
		
		//video 57
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean checkMusic = getPrefs.getBoolean("checkbox", true);
		if (checkMusic == true) {
			ourSong.start();
		}

		
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent openStartingPoint = new Intent("com.thenewboston.travis.MENU");
					startActivity(openStartingPoint);
				}	
			}
		};
		timer.start();
		
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}
	
	
}
