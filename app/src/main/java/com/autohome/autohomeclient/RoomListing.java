package com.autohome.autohomeclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;


public class RoomListing extends ActionBarActivity {

	ListView listView;
	Toolbar toolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_room_listing);

        ImageView icon = new ImageView(this);
        icon.setImageResource(R.drawable.ic_action_new);
        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(icon)
                .build();

		listView = (ListView) findViewById(R.id.list);
		toolbar = (Toolbar) findViewById(R.id.toolbar);

		toolbar.setTitle("Rooms");

		String[] rooms = new String[]{"Living Room", "Kitchen"};

		//Defining new Adapter
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.room_listing_list_item, android.R.id.text1, rooms);

		//Assign adapter to listView
		listView.setAdapter(adapter);

		//listView onClickListener
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				int itemPosition = position;

				String roomName = (String) listView.getItemAtPosition(position);

				Intent intent = new Intent(getBaseContext(), RoomActivity.class);
				intent.putExtra(Shared.ROOM_NAME_INTENT_EXTRA_NAME, roomName);
				startActivity(intent);
			}
		});


	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_rooms, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
