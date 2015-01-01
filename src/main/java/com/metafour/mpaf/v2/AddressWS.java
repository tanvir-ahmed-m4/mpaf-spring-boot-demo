package com.metafour.mpaf.v2;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.beans.factory.annotation.Autowired;

import com.metafour.mpaf.v2.model.Address;
import com.metafour.mpaf.v2.model.Addresses;
import com.metafour.mpaf.v2.service.AddressService;

@WebService
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT, use=SOAPBinding.Use.LITERAL)
public class AddressWS {

	@Autowired
	AddressService addressService;
	
	@WebMethod
	public Addresses fullPAF(@WebParam(name="country") String country, @WebParam(name="postcode") String postcode) {
		return addressService.fullPAF(country, postcode);
	}
	
	@WebMethod
	public Address partPAF(@WebParam(name="country") String country, @WebParam(name="postcode") String postcode) {
		return addressService.partPAF(country, postcode);
	}
	
}
