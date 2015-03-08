package com.autohome.autohomeclient;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardGridArrayAdapter;
import it.gmariotti.cardslib.library.view.CardGridView;
import it.gmariotti.cardslib.library.view.CardListView;


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

		SingleApplianceCard card = new SingleApplianceCard(this, "Light", R.drawable.light_on);
		cards.add(card);

		toolbar = (Toolbar) findViewById(R.id.toolbar);
		CardGridArrayAdapter cardArrayAdapter = new CardGridArrayAdapter(this, cards);
		cardGridView = (CardGridView) findViewById(R.id.appliance_grid_view);

		if (cardGridView != null) {
			cardGridView.setAdapter(cardArrayAdapter);
		}


		toolbar.setTitle(roomName);
	}
}
