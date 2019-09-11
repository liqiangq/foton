package com.foton.m2m.manage.car.service.imp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.foton.m2m.framework.core.command.QueryFilter;
import com.foton.m2m.framework.core.service.impl.GenericServiceImpl;
import com.foton.m2m.framework.security.model.Position;
import com.foton.m2m.framework.security.service.PositionService;
import com.foton.m2m.manage.car.dao.CarInfoDao;
import com.foton.m2m.manage.car.model.CarInfo;
import com.foton.m2m.manage.car.service.CarInfoService;

@Service(value = "carInfoService")
public class CarInfoServiceImp extends GenericServiceImpl<CarInfo, Long>
		implements CarInfoService {

	@Resource
	private CarInfoDao carInfoDao;

	@Resource
	private PositionService positionService;

	@Override
	public List<CarInfo> findAllByCompany(QueryFilter filter) {
		// TODO Auto-generated method stub
		filter.setFilterName("ListCarInfoByCompany");
		return carInfoDao.getAll(CarInfo.class, filter);
	}
	
	@Override
	public List<CarInfo> findAllNotInCompany(QueryFilter filter) {
		// TODO Auto-generated method stub
		filter.setFilterName("ListCarInfoNotInCompany");
		return carInfoDao.getAll(CarInfo.class, filter);
	}

	@Override
	public List<CarInfo> findAllByPosition(QueryFilter filter) {
		// TODO Auto-generated method stub
		filter.setFilterName("ListCarInfoByPosition");
		filter.setFilterByNamedParam(true);
		List<Long> list = new ArrayList<Long>();
		filter.addFilter("Q_posIds_IN", list);
		return carInfoDao.getAll(CarInfo.class, filter);
	}

	@Override
	public String getPositionsTreeByCar(Long carId) {
		CarInfo carInfo = this.get(carId);
		Set<Position> positions = carInfo.getPositions();
		StringBuffer sb = new StringBuffer("");
		for (Iterator<Position> it = positions.iterator(); it.hasNext();) {
			sb.append(it.next().getPosId());
			sb.append(",");
		}
		StringBuffer buff = new StringBuffer("[");
		List<Position> posList = this.positionService.getByParent(new Long(0L));
		for (Position pos : posList) {
			buff.append("{id:'" + pos.getPosId());
			buff.append("',checked:");
			if (sb.toString().indexOf((pos.getPosId() + ",")) > -1) {
				buff.append(true);
			} else {
				buff.append(false);
			}
			buff.append(",text:'" + pos.getPosName()).append("',");
			buff.append(getPositionChildren(pos.getPosId(), sb.toString()));
		}
		if (!posList.isEmpty()) {
			buff.deleteCharAt(buff.length() - 1);
		}
		buff.append("]");
		return buff.toString().toString();
	}

	private String getPositionChildren(Long parentId, String ids) {
		StringBuffer buff = new StringBuffer();
		List<Position> posList = this.positionService.getByParent(parentId);
		if (posList.size() == 0) {
			buff.append("leaf:true,iconCls:'tree-position'},");
			return buff.toString();
		}
		buff.append("children:[");
		for (Position pos : posList) {
			buff.append("{id:'" + pos.getPosId());
			buff.append("',checked:");
			if (ids.indexOf((pos.getPosId() + ",")) > -1) {
				buff.append(true);
			} else {
				buff.append(false);
			}
			buff.append(",text:'" + pos.getPosName()).append("',");
			buff.append(getPositionChildren(pos.getPosId(), ids));
		}
		buff.deleteCharAt(buff.length() - 1);
		buff.append("]},");
		return buff.toString();
	}

	@Override
	public List<Position> getPositionsByIds(List<Long> posIds) {
		// TODO Auto-generated method stub
		String hql = "from Position t where t.posId in (:posIds)";
		return positionService.findByNamedParam(hql, "posIds", posIds);
	}
}
