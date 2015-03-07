package com.autohome.autohomeclient;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Created by benscholer on 3/6/15.
 */
public class Room implements Serializable {
	private final String roomName;

	public Room(String roomName) {
		this.roomName = roomName;
	}

	@Override
	public String toString() {
		return roomName;
	}
}
