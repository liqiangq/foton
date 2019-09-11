package com.foton.m2m.manage.car.dao.imp;

import org.springframework.stereotype.Repository;

import com.foton.m2m.framework.core.dao.impl.GenericDaoImpl;
import com.foton.m2m.manage.car.dao.CarInfoDao;
import com.foton.m2m.manage.car.model.CarInfo;

@Repository(value = "carInfoDao")
public class CarInfoDaoImp extends GenericDaoImpl<CarInfo, Long> implements
		CarInfoDao {
	
	public CarInfoDaoImp() {
		this.querys.put("ListCarInfoByCompany", "select vo from CarInfo vo , In(vo.companys) t2 where t2.companyId = ?");
		this.querys.put("ListCarInfoNotInCompany", "select vo from CarInfo vo left join vo.companys t2 where (t2.companyId is null or t2.companyId != ? )");
		this.querys.put("ListCarInfoByPosition", "select t1 from CarInfo t1 , In(t1.positions) t2 where t2.posId in (:posIds)");
	}
}
