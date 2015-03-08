package com.autohome.autohomeclient;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardGridArrayAdapter;
import it.gmariotti.cardslib.library.view.CardGridView;


public class RoomActivity extends ActionBarActivity {

	private ArrayList<Card> cards = new ArrayList<>();
	String roomName;
	Toolbar toolbar;
	CardGridView cardGridView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_room);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			roomName = extras.getString(Shared.ROOM_NAME_INTENT_EXTRA_NAME);
		}
		for (int i = 0; i < 5; i++) {
			Appliance appliance = new Appliance("Light", R.drawable.light_on, R.drawable.light_off, 2, 0, false);
			SingleApplianceCard card = new SingleApplianceCard(this, appliance);
			cards.add(card);
		}
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		CardGridArrayAdapter cardArrayAdapter = new CardGridArrayAdapter(this, cards);
		cardGridView = (CardGridView) findViewById(R.id.appliance_grid_view);

		if (cardGridView != null) {
			cardGridView.setAdapter(cardArrayAdapter);
		}


		toolbar.setTitle(roomName);
	}
}
