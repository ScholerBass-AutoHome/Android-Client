package com.autohome.autohomeclient;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Rooms extends ActionBarActivity {

	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rooms);

		listView = (ListView) findViewById(R.id.room_list);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(getApplicationContext(), "Clicked ListItem Number " + position, Toast.LENGTH_SHORT).show();
			}
		});

		ArrayList<String> rooms = new ArrayList<>();
		rooms.add("Living Room");
		rooms.add("Kitchen");
		rooms.add("Bedroom");

		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.room_list_item, rooms);
	}
}
