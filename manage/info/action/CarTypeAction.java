package com.foton.m2m.manage.info.action;

import java.util.List;

import javax.annotation.Resource;

import com.foton.m2m.framework.core.service.GenericService;
import com.foton.m2m.framework.core.web.action.CRUDAction;
import com.foton.m2m.manage.info.model.CarType;
import com.foton.m2m.manage.info.service.CarTypeService;

public class CarTypeAction extends CRUDAction<CarType, Long> {

	private static final long serialVersionUID = 1L;

	@Resource(name = "carTypeService")
	@Override
	public void setService(GenericService<CarType, Long> service) {
		// TODO Auto-generated method stub
		this.service = service;
	}

	public String combo() {
		String id = this.getRequest().getParameter("carBrandId");
		List<CarType> list = ((CarTypeService)service).findByCarBrand(Long.parseLong(id));
		StringBuffer buff = new StringBuffer("{success:true,");
		buff.append("result:");
		buff.append(jacksonUtil.toJson(list));
		buff.append("}");
		setJsonString(buff.toString());
		return SUCCESS;
	}

}
