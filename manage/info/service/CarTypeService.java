package com.foton.m2m.manage.info.service;

import java.util.List;

import com.foton.m2m.framework.core.service.GenericService;
import com.foton.m2m.manage.info.model.CarType;

public interface CarTypeService extends GenericService<CarType, Long> {
	List<CarType> findByCarBrand(Long id);
}
