package com.autohome.autohomeclient;

/**
 * Created by benscholer on 4/10/15.
 */
public class Outlet {
	OutletSerial serial;

	public Outlet() {
		serial = new OutletSerial();
	}

	public Outlet(int unitSerial, int outletIndex) {
		OutletSerial ser = new OutletSerial(unitSerial, outletIndex);
		this.serial = ser;
	}
}
