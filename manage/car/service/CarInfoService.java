package com.foton.m2m.manage.car.service;

import java.util.List;

import com.foton.m2m.framework.core.command.QueryFilter;
import com.foton.m2m.framework.core.service.GenericService;
import com.foton.m2m.framework.security.model.Position;
import com.foton.m2m.manage.car.model.CarInfo;

public interface CarInfoService extends GenericService<CarInfo, Long> {

	List<CarInfo> findAllByCompany(QueryFilter filter);
	List<CarInfo> findAllNotInCompany(QueryFilter filter);
	
	List<CarInfo> findAllByPosition(QueryFilter filter);
	String getPositionsTreeByCar(Long carId);
	
	List<Position> getPositionsByIds(List<Long> posIds);
}
