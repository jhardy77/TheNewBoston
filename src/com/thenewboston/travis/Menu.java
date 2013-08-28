package com.thenewboston.travis;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
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

}
