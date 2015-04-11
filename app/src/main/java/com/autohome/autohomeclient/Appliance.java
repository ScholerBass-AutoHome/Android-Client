package com.autohome.autohomeclient;

/**
 * Created by benscholer on 3/8/15.
 */
public class Appliance {

	String name;
	int imageIndexOn;
	int imageIndexOff;
	boolean status;
	Outlet outlet;

	public Appliance() {
		this.name = "";
		this.imageIndexOn = 0;
		this.imageIndexOff = 1;
		this.status = false;
		outlet = new Outlet();
	}

	public Appliance(String name, int imageIndexOn, int imageIndexOff, boolean status,
					 Outlet outlet) {
		this.name = name;
		this.imageIndexOn = imageIndexOn;
		this.imageIndexOff = imageIndexOn + 1;
		this.status = status;
		this.outlet = outlet;
	}
}
