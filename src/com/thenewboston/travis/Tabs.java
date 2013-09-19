package com.thenewboston.travis;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Tabs extends Activity implements OnClickListener {

	TabHost th;
	Button newTab, bStart, bStop;
	TextView showResults;
	long start, stop;


//////////////////////////////////////////////////////////////////////////////////////


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs);
		initialiseVars();
		setupTabs();
		newTab.setOnClickListener(this);
		bStart.setOnClickListener(this);
		bStop.setOnClickListener(this);
		
	}


//////////////////////////////////////////////////////////////////////////////////////


	private void setupTabs() {
		//This readies the system to setup tabs
		th.setup();
		
		//This sets up Tab1 in the tabs.xml layout
		TabSpec specs = th.newTabSpec("tag1");
		specs.setContent(R.id.tab1);
		specs.setIndicator("StopWatch");
		th.addTab(specs);
		
		//This sets up Tab2 in the tabs.xml layout
		specs = th.newTabSpec("tag2");
		specs.setContent(R.id.tab2);
		specs.setIndicator("Tab 2");
		th.addTab(specs);
		
		//This sets up Tab3 in the tabs.xml layout
		specs = th.newTabSpec("tag3");
		specs.setContent(R.id.tab3);
		specs.setIndicator("Add a Tab");
		th.addTab(specs);
		
	}


//////////////////////////////////////////////////////////////////////////////////////


	private void initialiseVars() {
		// TODO Auto-generated method stub
		th = (TabHost) findViewById(R.id.tabhost);
		newTab = (Button) findViewById(R.id.b_addTab);
		bStart = (Button) findViewById(R.id.b_startWatch);
		bStop = (Button) findViewById(R.id.b_stopWatch);
		showResults = (TextView) findViewById(R.id.tv_showResults);
		
	}


//////////////////////////////////////////////////////////////////////////////////////


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.b_addTab:
			TabSpec ourSpec = th.newTabSpec("tag1");
			ourSpec.setContent(new TabHost.TabContentFactory() {
				
				@Override
				public View createTabContent(String tag) {
					// TODO Auto-generated method stub
					TextView text = new TextView(Tabs.this);
					text.setText("You've created a new tab!");
					return (text);
				}
			});
			ourSpec.setIndicator("New");
			th.addTab(ourSpec);
			break;
			
		case R.id.b_startWatch:
			start = 0;
			start = System.currentTimeMillis();
			break;
			
		case R.id.b_stopWatch:
			stop = System.currentTimeMillis();
			
			if (start != 0) {
				long result = stop - start;
				int milli = (int) result;
				int seconds = (int) result / 1000;
				int minutes = seconds / 60;
				
				milli = milli % 100;
				seconds = seconds % 60;
				
				showResults.setText(String.format("%d:%02d:%03d", minutes, seconds, milli));
			}
			break;
		}
		
	}
	
	
	

}
