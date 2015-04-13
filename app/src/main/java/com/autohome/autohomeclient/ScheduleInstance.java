package com.autohome.autohomeclient;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by benscholer on 4/8/15.
 */
public class ScheduleInstance {

	public String name;
	public Date start;
	public Date end;
	public boolean[] days;
	//[true, false, false, true, true, true...]
	public boolean repeat;
	public boolean status;

	public HashMap<OutletSerial, Boolean> pins = new HashMap<>();

	public ScheduleInstance(String name, Date start, Date end, boolean[] days, boolean repeat, boolean status, HashMap<OutletSerial, Boolean> pins) {
		this.name = name;
		this.start = start;
		this.end = end;
		this.days = days;
		this.repeat = repeat;
		this.status = status;
		this.pins = pins;
	}
}
