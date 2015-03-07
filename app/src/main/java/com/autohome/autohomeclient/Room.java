package com.autohome.autohomeclient;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class Room extends ActionBarActivity {

	String roomName;
	Toolbar toolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_room);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			roomName = extras.getString(Shared.ROOM_NAME_INTENT_EXTRA_NAME);
		}

		toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setTitle(roomName);
	}
}
