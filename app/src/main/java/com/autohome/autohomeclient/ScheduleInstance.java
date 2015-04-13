package com.autohome.autohomeclient;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by benscholer on 4/8/15.
 */
public class ScheduleInstance {

	public Date start;
	public Date end;
	public boolean[] days;
	//[true, false, false, true, true, true...]
	public boolean repeat;
	public boolean status;

	public HashMap<OutletSerial, Boolean> pins = new HashMap<>();
}
