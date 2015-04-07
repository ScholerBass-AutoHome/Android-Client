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
}
