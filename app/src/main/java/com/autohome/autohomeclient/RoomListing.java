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

import com.afollestad.materialdialogs.MaterialDialog;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;

import java.util.ArrayList;

public class RoomListing extends ActionBarActivity {

	ListView listView;
	Toolbar toolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_room_listing);

		ImageView icon = new ImageView(this);
		icon.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_new));
		FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
				.setContentView(icon)
				.setBackgroundDrawable(R.drawable.button_action_pink_selector)
				.build();

		actionButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				MaterialDialog mMaterialDialog = new MaterialDialog()
						.setTitle("MaterialDialog")
						.setMessage("Hello world!")
						.setPositiveButton("OK", new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								mMaterialDialog.dismiss();
								...
							}
						})
						.setNegativeButton("CANCEL", new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								mMaterialDialog.dismiss();
								...
							}
						});

				mMaterialDialog.show();

// You can change the message anytime. before show
				mMaterialDialog.setTitle("提示");
				mMaterialDialog.show();
// You can change the message anytime. after show
				mMaterialDialog.setMessage("你好，世界~");
			}
		});

		listView = (ListView) findViewById(R.id.list);
		toolbar = (Toolbar) findViewById(R.id.toolbar);

		toolbar.setTitle("Rooms");

		ArrayList<String> rooms = new ArrayList<>();

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
}