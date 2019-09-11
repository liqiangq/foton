package com.foton.m2m.manage.info.service.imp;

import org.springframework.stereotype.Service;

import com.foton.m2m.framework.core.service.impl.GenericServiceImpl;
import com.foton.m2m.manage.info.model.Address;
import com.foton.m2m.manage.info.service.AddressService;

@Service(value="addressService")
public class AddressServiceImp extends GenericServiceImpl<Address, Long> implements
		AddressService {


}
