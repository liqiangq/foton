package com.foton.m2m.manage.info.action;

import java.util.List;

import javax.annotation.Resource;

import com.foton.m2m.framework.core.service.GenericService;
import com.foton.m2m.framework.core.web.action.CRUDAction;
import com.foton.m2m.manage.info.model.CarBrand;

public class CarBrandAction extends CRUDAction<CarBrand, Long> {

	private static final long serialVersionUID = 1L;

	@Resource(name = "carBrandService")
	@Override
	public void setService(GenericService<CarBrand, Long> service) {
		// TODO Auto-generated method stub
		this.service = service;
	}

	public String combo(){
		List<CarBrand> list = service.getAll();
		StringBuffer buff = new StringBuffer("{success:true,");
		buff.append("result:");
		buff.append(jacksonUtil.toJson(list));
		buff.append("}");
		setJsonString(buff.toString());
		return SUCCESS;
	}
}
