package com.autohome.autohomeclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;

public class RoomListing extends ActionBarActivity {

	ListView listView;
	Toolbar toolbar;
	ArrayList<String> rooms = new ArrayList<>();
	String newRoomName;

	//TODO fix this
	ArrayAdapter<String> adapter;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_room_listing);

		rooms.add("Living Room");

		adapter = new ArrayAdapter<String>(this, R.layout.room_listing_list_item, android.R.id.text1, rooms);

		ImageView icon = new ImageView(this);
		icon.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_new));
		FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
				.setContentView(icon)
				.setBackgroundDrawable(R.drawable.button_action_pink_selector)
				.build();

		actionButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				boolean wrapInScrollView = true;
				MaterialDialog dialog = new MaterialDialog.Builder(RoomListing.this)
						.title(R.string.create_new_room_dialog_title)
						.customView(R.layout.custom_view_addroom_edittext, wrapInScrollView)
						.positiveText(R.string.create_new_room_dialog_positive)
						.negativeText(R.string.negative)
						.callback(new MaterialDialog.ButtonCallback() {
							@Override
							public void onPositive(MaterialDialog dialog) {

								MaterialEditText text = (MaterialEditText) dialog.getCustomView();

								while (true) {
									if (text.getText().toString() != null) {
										newRoomName = text.getText().toString();
										adapter.add(newRoomName);
										super.onPositive(dialog);
									} else {
										Toast.makeText(RoomListing.this, "No Room Name", Toast.LENGTH_SHORT).show();
										text.setPrimaryColor(getResources().getColor(R.color.error));
									}
								}


							}
						})
						.build();

				dialog.show();
			}
		});

		listView = (ListView) findViewById(R.id.list);
		toolbar = (Toolbar) findViewById(R.id.toolbar);

		toolbar.setTitle("Rooms");

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
}