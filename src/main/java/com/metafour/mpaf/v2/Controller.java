package com.metafour.mpaf.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metafour.mpaf.v2.model.Address;
import com.metafour.mpaf.v2.model.Addresses;
import com.metafour.mpaf.v2.service.AddressService;

@RestController
public class Controller {

	@Autowired
	AddressService addressService;
	
	@RequestMapping({"/address/{country}/{postcode}", "/address/{country}/{postcode}/full"})
	public Addresses fullPAF(@PathVariable String country, @PathVariable String postcode) {
		return addressService.fullPAF(country, postcode);
	}
	
	@RequestMapping("/address/{country}/{postcode}/part")
	public Address partPAF(@PathVariable String country, @PathVariable String postcode) {
		return addressService.partPAF(country, postcode);
	}
}
