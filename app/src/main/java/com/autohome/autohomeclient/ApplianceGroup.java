package com.autohome.autohomeclient;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by benscholer on 3/8/15.
 */
public class ApplianceGroup implements Serializable {

	private String name;
	private ArrayList<Appliance> appliances;

	public void removeAppliance(Appliance appliance) {
		for (int i = 0; i < appliances.size(); i++) {
			if (appliance.name.equals(appliances.get(i).name)) {
				appliances.remove(i);
			}
		}
	}

	public void addAppliance(Appliance appliance) {
		appliances.add(appliance);
	}

	public ArrayList<Appliance> getAppliances() {
		return this.appliances;
	}
}
