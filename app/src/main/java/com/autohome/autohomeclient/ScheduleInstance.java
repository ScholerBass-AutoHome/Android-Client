package com.autohome.autohomeclient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by benscholer on 4/8/15.
 */
public class ScheduleInstance implements Serializable {

	private int hour;
	private int min;
	private boolean[] days;
	private boolean repeat;
	private ArrayList<Appliance> appliances = new ArrayList<Appliance>();
}
