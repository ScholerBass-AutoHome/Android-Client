package com.autohome.autohomeclient;

/**
 * Created by benscholer on 4/10/15.
 */
public class OutletSerial {
	public int unitSerial;
	public int outletIndex;

	public OutletSerial() {
		this.unitSerial = 0;
		this.outletIndex = 0;
	}

	public OutletSerial(int unitSerial, int outletIndex) {
		this.unitSerial = unitSerial;
		this. outletIndex = outletIndex;
	}
}
