package com.thenewboston.travis;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {
	
	
	//VIDEO 20
	String classes[] = {"StartingPoint", "TextPlay", "Email", "Camera", "Data", "example5", "example6"};
	
	
//////////////////////////////////////////////////////////////////////////////////////

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
		
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////


	//Video 21
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		String cheese = classes[position];
		
		try {
		Class ourClass = Class.forName("com.thenewboston.travis." + cheese);
		Intent ourIntent = new Intent(Menu.this, ourClass);
		startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			
		}
	}


	
	
//////////////////////////////////////////////////////////////////////////////////////
	
	//video 51
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;
		
	}


	

	
//////////////////////////////////////////////////////////////////////////////////////
	
	//Video 52
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		
		case R.id.aboutus:
			Intent i = new Intent("com.thenewboston.travis.ABOUT");
			startActivity(i);
			
			break;
			
		case R.id.preferences:
			Intent p = new Intent("com.thenewboston.travis.PREFERENCES");
			startActivity(p);
			
			break;
		}
		//Linked to the boolean of this method, needs to return false if aboutus or preferences aren't selected.
		return false;

	}

}
