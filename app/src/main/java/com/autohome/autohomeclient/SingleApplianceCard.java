package com.autohome.autohomeclient;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by benscholer on 3/7/15.
 */
public class SingleApplianceCard extends Card {

	private TextView applianceName;
	private ImageButton overflowButton;
	private ImageButton applianceButton;
	private String name;
	private int applianceImageResourceOn;
	private int applianceImageResourceOff;
	private Appliance appliance;
	private Context context;

	public SingleApplianceCard(Context context, String name, int applianceImageOn, int applianceImageOff) {
		super(context, R.layout.single_appliance_card);
		init(name, applianceImageOn, applianceImageOff);
		this.context = context;
	}

	public SingleApplianceCard(Context context, Appliance appliance) {
		super(context, R.layout.single_appliance_card);
		this.appliance = appliance;
		init(this.appliance.getName(), this.appliance.getImageResourceOn(), this.appliance.getImageResourceOff());
		this.context = context;
	}

	private void init(String name, int applianceImageOn, int applianceImageOff) {
		this.setShadow(true);
		this.name = name;
		this.applianceImageResourceOn = applianceImageOn;
		this.applianceImageResourceOff = applianceImageOff;
	}

	@Override
	public void setupInnerViewElements(ViewGroup parent, View view) {
		applianceName = (TextView) view.findViewById(R.id.appliance_name);
		overflowButton = (ImageButton) view.findViewById(R.id.single_appliance_card_overflow);

		applianceButton = (ImageButton) view.findViewById(R.id.appliance_image);

		applianceName.setText(name);
		applianceButton.setImageResource(applianceImageResourceOff);
		applianceButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(context, "Clicked!!", Toast.LENGTH_SHORT).show();
				applianceButton = (ImageButton) v;
 				if (appliance.isStatus() == false) applianceButton.setImageResource(applianceImageResourceOn);
				if (appliance.isStatus() == true) applianceButton.setImageResource(applianceImageResourceOff);

				appliance.setStatus(!appliance.isStatus());
			}
		});
	}
}
