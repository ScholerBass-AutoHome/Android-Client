package com.autohome.autohomeclient;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by benscholer on 3/7/15.
 */
public class SingleApplianceCard extends Card {

	private TextView applianceName;
	private ImageButton overflowButton;
	private ImageButton applianceButton;
	private String name;
	private int applianceImageResource;

	public SingleApplianceCard(Context context, String name, int applianceImage) {
		super(context, R.layout.single_appliance_card);
		init(name, applianceImage);
	}

	private void init(String name, int applianceImage) {
		this.setShadow(true);
		this.name = name;
		this.applianceImageResource = applianceImage;
	}

	@Override
	public void setupInnerViewElements(ViewGroup parent, View view) {
		applianceName = (TextView) view.findViewById(R.id.appliance_name);
		overflowButton = (ImageButton) view.findViewById(R.id.single_appliance_card_overflow);
		applianceButton = (ImageButton) view.findViewById(R.id.appliance_image);

		applianceName.setText(name);
		applianceButton.setImageResource(applianceImageResource);
	}
}
