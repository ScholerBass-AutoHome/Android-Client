package com.autohome.autohomeclient;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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

		View V = inflater.inflate(R.layout.fragment_appliance_listing, container, false);

		for (int i = 0; i < 3; i++) {
			Appliance appliance = new Appliance("Light", 0, 1, false, new Outlet(0, i));
			SingleApplianceCard card = new SingleApplianceCard(super.getActivity(), appliance);
			cards.add(card);
		}

		CardGridArrayAdapter cardArrayAdapter = new CardGridArrayAdapter(super.getActivity(), cards);
		cardGridView = (CardGridView) V.findViewById(R.id.appliance_grid_view);

		if (cardGridView != null) {
			cardGridView.setAdapter(cardArrayAdapter);
		}
		// Inflate the layout for this fragment
		return V;
	}


}
