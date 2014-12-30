package com.metafour.mpaf.v2.model;

import java.util.ArrayList;
import java.util.List;

public class Addresses {

	private List<Address> addresses;

	public Addresses() {
		super();
		addresses = new ArrayList<Address>();
	}

	public List<Address> getAddress() {
		return addresses;
	}

	public void setAddress(List<Address> addresses) {
		this.addresses = addresses;
	}
}
