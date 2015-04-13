package com.autohome.autohomeclient;

import java.text.SimpleDateFormat;

/**
 * Created by benscholer on 4/11/15.
 */
public class Date {

	public int year;    // e.g. 1998, 2016
	public int month;    // 1 = January, 12 = December
	public int day;        // 1 - 30
	public int hour;    // 1 - 24
	public int min;        // 0 - 24

	public Date(int year, int month, int day, int hour, int min) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.min = min;
	}

	@Override
	public String toString() {
		return year + " " + month + " " + day + " " + hour + " " + min;
	}

	public String[] toPrettyString() {
		String[] time = new String[2];
		String twentyfour = hour + ":" + min;
		String minute;

		String suffix = " AM";
		int adjustedHour = 0;

		if (this.hour >= 12) {
			suffix = " PM";

			if (this.hour == 12) {
				adjustedHour = 12;
			} else {
				adjustedHour = (this.hour - 12);
			}
		}

		if (min > 9) {
			minute = min + "";
		} else {
			minute = "0" + min;
		}

		time[0] = adjustedHour + ":" + minute;
		time[1] = suffix;

		return time;
	}
}
