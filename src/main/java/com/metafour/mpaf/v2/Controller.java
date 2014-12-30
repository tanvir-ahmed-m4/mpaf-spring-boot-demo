package com.metafour.mpaf.v2;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metafour.mpaf.v2.model.Address;
import com.metafour.mpaf.v2.model.Addresses;

@RestController
public class Controller {

	@RequestMapping({"/address/{country}/{postcode}", "/address/{country}/{postcode}/full"})
	public Addresses fullPAF(@PathVariable String country, @PathVariable String postcode) {
		Addresses addressList = new Addresses();
		
		Address addr1 = new Address();
		addr1.setCountry(country);
		addr1.setPostcode(postcode);
		addr1.setRoad("Flourmill Lane");
		addr1.setTown("ABERDEEN");
		addressList.getAddress().add(addr1);
		
		Address addr2 = new Address();
		addr2.setCountry(country);
		addr2.setPostcode(postcode);
		addr2.setBuilding("26");
		addr2.setRoad("Netherkirkgate");
		addr2.setTown("ABERDEEN");
		addressList.getAddress().add(addr2);
		
		return addressList;
	}
	
	@RequestMapping("/address/{country}/{postcode}/part")
	public Address partPAF(@PathVariable String country, @PathVariable String postcode) {
		Address addr1 = new Address();
		addr1.setCountry(country);
		addr1.setPostcode(postcode);
		addr1.setRoad("Flourmill Lane");
		addr1.setTown("ABERDEEN");
		
		return addr1;
	}
}
