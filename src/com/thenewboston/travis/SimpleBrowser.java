package com.thenewboston.travis;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class SimpleBrowser extends Activity implements OnClickListener {

	WebView ourBrowser;
	Button go, back, forward, refresh, clear;
	EditText webAddress;
	

//////////////////////////////////////////////////////////////////////////////////////


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simplebrowser);
		initialiseVars();

		//Initialize the OnClick Events
		go.setOnClickListener(this);
		back.setOnClickListener(this);
		forward.setOnClickListener(this);
		refresh.setOnClickListener(this);
		clear.setOnClickListener(this);
		
		ourBrowser.getSettings().setJavaScriptEnabled(true);
		
		//This is used to decide if we want it completely 
		//zoomed out or not ie true/false
		ourBrowser.getSettings().setLoadWithOverviewMode(true);
		
		//Sets a new wide view port or a normal desktop view
		ourBrowser.getSettings().setUseWideViewPort(true);
		
		//Create the new WebViewClient
		ourBrowser.setWebViewClient(new ourViewClient());
		
		//ourBrowser.loadUrl("http://www.mybringback.com");

	}


//////////////////////////////////////////////////////////////////////////////////////


	private void initialiseVars() {
		// TODO Auto-generated method stub
		go = (Button) findViewById(R.id.b_GO);
		back = (Button) findViewById(R.id.b_Back);
		forward = (Button) findViewById(R.id.b_Forward);
		refresh = (Button) findViewById(R.id.b_Refresh);
		clear = (Button) findViewById(R.id.b_ClearHistory);
		ourBrowser = (WebView) findViewById(R.id.wvBrowser);
		webAddress = (EditText) findViewById(R.id.et_WebAddress);
	}


//////////////////////////////////////////////////////////////////////////////////////


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.b_GO:
			
			if (webAddress != null){
				String inputAddy = webAddress.getText().toString();
				ourBrowser.loadUrl(inputAddy);
				InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromInputMethod(webAddress.getWindowToken(), 0);
			}
			
			break;
			
		case R.id.b_Back:
			if (ourBrowser.canGoBack()){
				ourBrowser.goBack();
			}
			break;
			
		case R.id.b_Forward:
			if (ourBrowser.canGoForward()){
				ourBrowser.goForward();
			}
			break;
			
		case R.id.b_Refresh:
			ourBrowser.reload();
			break;
			
		case R.id.b_ClearHistory:
			ourBrowser.clearHistory();
			break;
					
		}

	}
	

//////////////////////////////////////////////////////////////////////////////////////



}
