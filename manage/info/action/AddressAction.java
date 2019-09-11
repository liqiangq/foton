package com.foton.m2m.manage.info.action;

import javax.annotation.Resource;

import com.foton.m2m.framework.core.web.action.BaseAction;
import com.foton.m2m.manage.info.model.Address;
import com.foton.m2m.manage.info.service.AddressService;

public class AddressAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	@Resource
	private AddressService addressService;

	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
