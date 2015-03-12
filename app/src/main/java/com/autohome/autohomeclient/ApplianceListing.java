package com.autohome.autohomeclient;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardGridArrayAdapter;
import it.gmariotti.cardslib.library.view.CardGridView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ApplianceListing extends Fragment {

	private ArrayList<Card> cards = new ArrayList<>();
	CardGridView cardGridView;


	public ApplianceListing() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		for (int i = 0; i < 5; i++) {
			Appliance appliance = new Appliance("Light", R.drawable.light_on, R.drawable.light_off, 2, 0, false);
			SingleApplianceCard card = new SingleApplianceCard(super.getActivity(), appliance);
			cards.add(card);
		}

		CardGridArrayAdapter cardArrayAdapter = new CardGridArrayAdapter(super.getActivity(), cards);
		cardGridView = (CardGridView) super.getActivity().findViewById(R.id.appliance_grid_view);

		if (cardGridView != null) {
			cardGridView.setAdapter(cardArrayAdapter);
		}
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_appliance_listing, container, false);
	}


}
