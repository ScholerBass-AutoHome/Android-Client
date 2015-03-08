package com.autohome.autohomeclient;

import java.io.Serializable;

/**
 * Created by benscholer on 3/8/15.
 */
public class Appliance implements Serializable {

	private String name;
	private int imageResourceOn;
	private int imageResourceOff;
	private int GPIOPin;
	private int outletIndex;
	private boolean status = false;

	public Appliance(String name, int imageResourceOn, int imageResourceOff, int GPIOPin, int outletIndex, boolean status) {
		this.name = name;
		this.imageResourceOn = imageResourceOn;
		this.imageResourceOff = imageResourceOff;
		this.GPIOPin = GPIOPin;
		this.outletIndex = outletIndex;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getImageResourceOn() {
		return imageResourceOn;
	}

	public void setImageResourceOn(int imageResourceOn) {
		this.imageResourceOn = imageResourceOn;
	}

	public int getImageResourceOff() {
		return imageResourceOff;
	}

	public void setImageResourceOff(int imageResourceOff) {
		this.imageResourceOff = imageResourceOff;
	}

	public int getGPIOPin() {
		return GPIOPin;
	}

	public void setGPIOPin(int GPIOPin) {
		this.GPIOPin = GPIOPin;
	}

	public int getOutletIndex() {
		return outletIndex;
	}

	public void setOutletIndex(int outletIndex) {
		this.outletIndex = outletIndex;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
