package com.foton.m2m.manage.car.action;

import javax.annotation.Resource;

import com.foton.m2m.framework.core.service.GenericService;
import com.foton.m2m.framework.core.web.action.CRUDAction;
import com.foton.m2m.manage.car.model.CarExpand;

public class CarExpandAction extends CRUDAction<CarExpand, Long> {

	private static final long serialVersionUID = 1L;

	@Resource(name = "carExpandService")
	@Override
	public void setService(GenericService<CarExpand, Long> service) {
		// TODO Auto-generated method stub
		this.service = service;
	}

}
