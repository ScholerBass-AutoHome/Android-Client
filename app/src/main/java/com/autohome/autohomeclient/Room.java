package com.autohome.autohomeclient;

import java.io.Serializable;

/**
 * Created by benscholer on 3/6/15.
 */
public class Room implements Serializable {
	private String name;

	public Room(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
