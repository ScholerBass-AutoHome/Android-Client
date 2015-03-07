package com.autohome.autohomeclient;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardListView;


public class Rooms extends ActionBarActivity {

	ArrayList<Card> cards = new ArrayList<>();
	ArrayList<Room> rooms = new ArrayList<>();
	CardListView cardView;
	Room livingRoom = new Room("Living Room");
	Room kitchen = new Room("Kitchen");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rooms);

		rooms.add(livingRoom);
		rooms.add(kitchen);
		populate();

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setTitle("Rooms");

		cardView = (CardListView) findViewById(R.id.card_list);

		CardArrayAdapter cardArrayAdapter = new CardArrayAdapter(this, cards);
		if (cardView != null) {
			cardView.setAdapter(cardArrayAdapter);
		}
	}

	public void populate() {
		for (Room room : rooms) {
			Card card = new Card(this);
			card.setShadow(true);

			CardHeader cardHeader = new CardHeader(this);
			cardHeader.setTitle(room.getName());

			card.addCardHeader(cardHeader);
			cards.add(card);
		}
	}
}









