package com.autohome.autohomeclient;

import java.util.ArrayList;

/**
 * Created by benscholer on 4/8/15.
 */
public class ScheduleInstance {

	private Date start;
	private Date end;
	private boolean[] days;
	//[true, false, false, true, true, true...]
	private boolean repeat;
	private boolean status;

	private ArrayList<Integer> pins = new ArrayList<Integer>(); //TODO figure out what data type this should be
}
