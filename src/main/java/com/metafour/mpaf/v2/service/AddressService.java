package com.metafour.mpaf.v2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.metafour.mpaf.v2.model.Address;
import com.metafour.mpaf.v2.model.Addresses;

@Service
public class AddressService {

	private List<Address> addresses;

	public AddressService() {
		super();
		addresses = new ArrayList<Address>();
		
		Address addr1 = new Address();
		addr1.setCountry("GB");
		addr1.setPostcode("AB10 1AJ");
		addr1.setRoad("Flourmill Lane");
		addr1.setTown("ABERDEEN");
		addresses.add(addr1);
		
		Address addr2 = new Address();
		addr2.setCountry("GB");
		addr2.setPostcode("AB10 1AU");
		addr2.setBuilding("27");
		addr2.setRoad("Netherkirkgate");
		addr2.setTown("ABERDEEN");
		addresses.add(addr2);
	}

	public Addresses fullPAF(String country, String postcode) {
		Addresses addressList = new Addresses();
		
		for (Address addr : addresses) {
			addressList.getAddress().add(addr);
		}
		
		return addressList;
	}
	
	public Address partPAF(String country, String postcode) {
		return addresses.get(0);
	}

}
