package com.autohome.autohomeclient;

import java.util.HashMap;

/**
 * Created by benscholer on 3/7/15.
 */
public class Shared {

	public static final String ROOM_NAME_INTENT_EXTRA_NAME = "room_name";
	public static final String[] DAYS_OF_WEEK = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	//Add all appliances to this hashmap!!
	public static HashMap<OutletSerial, String> outletMap = new HashMap<>();

	public static int IMAGE_RESOLVER(int index) {
		switch (index) {
			case 0:
				return R.drawable.light_on;
			case 1:
				return R.drawable.light_off;
			default:
				return 0;
		}
	}

	public static String APPLIANCE_RESOLVER(OutletSerial serial) {
//		for (Map.Entry<OutletSerial, String> entry: outletMap) {
			//TODO figure this stuff out.
//		}
		return "  ";
	}
}
