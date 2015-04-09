package com.autohome.autohomeclient;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by benscholer on 3/8/15.
 */
public class Room implements Serializable {
	private String name;
	private ArrayList<Appliance> appliances;
	private ArrayList<ApplianceGroup> applianceGroups;
	private ArrayList<Unit> units;

	public Room(String name, ArrayList<Appliance> appliances, ArrayList<ApplianceGroup> applianceGroups, ArrayList<Unit> units) {
		this.name = name;
		this.appliances = appliances;
		this.applianceGroups = applianceGroups;
		this.units = units;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Appliance> getAppliances() {
		return appliances;
	}

	public void setAppliances(ArrayList<Appliance> appliances) {
		this.appliances = appliances;
	}

	public ArrayList<ApplianceGroup> getApplianceGroups() {
		return applianceGroups;
	}

	public void setApplianceGroups(ArrayList<ApplianceGroup> applianceGroups) {
		this.applianceGroups = applianceGroups;
	}

	public ArrayList<Unit> getUnits() {
		return units;
	}

	public void setUnits(ArrayList<Unit> units) {
		this.units = units;
	}
}