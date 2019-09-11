package com.foton.m2m.manage.car.service.imp;

import org.springframework.stereotype.Service;

import com.foton.m2m.framework.core.service.impl.GenericServiceImpl;
import com.foton.m2m.manage.car.model.CarExpand;
import com.foton.m2m.manage.car.service.CarExpandService;

@Service(value="carExpandService")
public class CarExpandServiceImp extends GenericServiceImpl<CarExpand, Long>
		implements CarExpandService {


}
