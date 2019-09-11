package com.foton.m2m.manage.info.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.foton.m2m.framework.core.service.impl.GenericServiceImpl;
import com.foton.m2m.manage.info.model.CarType;
import com.foton.m2m.manage.info.service.CarTypeService;

@Service(value="carTypeService")
public class CarTypeServiceImp extends GenericServiceImpl<CarType, Long> implements
		CarTypeService {

	@Override
	public List<CarType> findByCarBrand(Long id) {
		// TODO Auto-generated method stub
		String hql = "from CarType t where t.carBrand.id=?";
		return this.findByHql(hql, new Long[]{id});
	}

}
