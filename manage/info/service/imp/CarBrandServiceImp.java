package com.foton.m2m.manage.info.service.imp;

import org.springframework.stereotype.Service;

import com.foton.m2m.framework.core.service.impl.GenericServiceImpl;
import com.foton.m2m.manage.info.model.CarBrand;
import com.foton.m2m.manage.info.service.CarBrandService;

@Service(value="carBrandService")
public class CarBrandServiceImp extends GenericServiceImpl<CarBrand, Long> implements
		CarBrandService {

}
