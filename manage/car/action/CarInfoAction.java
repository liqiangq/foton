package com.foton.m2m.manage.car.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.drools.core.util.StringUtils;

import com.foton.m2m.framework.core.command.QueryFilter;
import com.foton.m2m.framework.core.service.GenericService;
import com.foton.m2m.framework.core.util.BeanUtil;
import com.foton.m2m.framework.core.util.ContextUtil;
import com.foton.m2m.framework.core.web.action.CRUDAction;
import com.foton.m2m.framework.security.model.Company;
import com.foton.m2m.framework.security.model.Position;
import com.foton.m2m.framework.security.service.CompanyService;
import com.foton.m2m.manage.car.model.CarInfo;
import com.foton.m2m.manage.car.service.CarInfoService;

public class CarInfoAction extends CRUDAction<CarInfo, Long> {

	private static final long serialVersionUID = 1L;

	@Resource
	private CompanyService companyService;

	@Resource(name = "carInfoService")
	@Override
	public void setService(GenericService<CarInfo, Long> service) {
		// TODO Auto-generated method stub
		this.service = service;
	}

	@Override
	public String list() {
		// TODO Auto-generated method stub
		QueryFilter filter = new QueryFilter(getRequest());
		Long companyId = ContextUtil.getCompanyId();
		filter.addParamValue(companyId);
		List<CarInfo> list = ((CarInfoService) service).findAllByCompany(filter);
		StringBuffer buff = new StringBuffer("{success:true,'totalCounts':");
		buff.append(filter.getPagingBean().getTotalItems());
		buff.append(",result:");
		buff.append(jacksonUtil.toJson(list));
		buff.append("}");
		setJsonString(buff.toString());
		return SUCCESS;
	}

	public String listAll(){
		String companyId = this.getRequest().getParameter("companyId");
		if(!StringUtils.isEmpty(companyId)){
			Long l_companyId = Long.parseLong(companyId);
			QueryFilter filter = new QueryFilter(getRequest());
			filter.addParamValue(l_companyId);
			List<CarInfo> list = ((CarInfoService) service).findAllNotInCompany(filter);
			StringBuffer buff = new StringBuffer("{success:true,'totalCounts':");
			buff.append(filter.getPagingBean().getTotalItems());
			buff.append(",result:");
			buff.append(jacksonUtil.toJson(list));
			buff.append("}");
			setJsonString(buff.toString());
		}
		
		return SUCCESS;
	}
	
	@Override
	public String save() {
		// TODO Auto-generated method stub
		if (this.id != null) {
			CarInfo t = service.get(this.id);
			try {
				BeanUtil.copyNotNullProperties(t, this.data);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			service.save(t);
			this.setInfo(UPDATE_SUCCESS);
		} else {
			Set<Company> companys = new HashSet<Company>();
			Company company = companyService.get(ContextUtil.getCompanyId());
			companys.add(company);
			this.data.setCompanys(companys);
			service.save(this.data);
			this.setInfo(CREATED_SUCCESS);
		}
		setJsonString("{success:true,info:'" + this.getInfo() + "'}");
		return SUCCESS;
	}

	public String treePositions() {
		String json = ((CarInfoService) service).getPositionsTreeByCar(this.id);
		setJsonString(json);
		return SUCCESS;
	}

	public String grantPositions() {
		CarInfo t = service.get(this.id);
		String posIds = getRequest().getParameter("posIds");
		if (posIds != null) {
			String[] s_posIds = posIds.split(",");
			List<Long> l_posIds = new ArrayList<Long>();
			for (String posId : s_posIds) {
				l_posIds.add(Long.parseLong(posId));
			}
			List<Position> pos = ((CarInfoService) service)
					.getPositionsByIds(l_posIds);
			Set<Position> set = new HashSet<Position>();
			set.addAll(pos);
			t.setPositions(set);
		} else {
			t.setPositions(null);
		}
		service.save(t);
		this.setInfo(UPDATE_SUCCESS);
		return SUCCESS;
	}
	
	public String listCompany(){
		QueryFilter filter = new QueryFilter(getRequest());
		String companyId = this.getRequest().getParameter("companyId");
		List<CarInfo> list = null;
		if(!StringUtils.isEmpty(companyId)){
			filter.setFilterName("ListCarInfoByCompany");
			filter.addParamValue(Long.parseLong(companyId));
			list = ((CarInfoService) service).findAllByCompany(filter);
		}else{
			list = ((CarInfoService) service).getAll(filter);
		}
		StringBuffer buff = new StringBuffer("{success:true,'totalCounts':");
		buff.append(filter.getPagingBean().getTotalItems());
		buff.append(",result:");
		buff.append(jacksonUtil.toJson(list));
		buff.append("}");
		setJsonString(buff.toString());
		return SUCCESS;
	}

	public String removeGrantCompany(){
		String companyId = this.getRequest().getParameter("companyId");
		if(!StringUtils.isEmpty(companyId)){
			Long l_companyId = Long.parseLong(companyId);
			String ids = this.getRequest().getParameter("ids");
			if(!StringUtils.isEmpty(ids)){
				String[] s_ids = ids.split(",");
				CarInfo car = null;
				for(String id : s_ids){
					if(!StringUtils.isEmpty(id)){
						car = service.get(Long.parseLong(id));
						Set<Company> companys = car.getCompanys();
						Company company = null;
						if(companys!=null){
							for(Iterator<Company> it = companys.iterator();it.hasNext();){
								company = it.next();
								if(company.getCompanyId().longValue() == l_companyId.longValue()){
									companys.remove(company);
								}
							}
						}
						car.setCompanys(companys);
						service.save(car);
					}
				}
			}
		}
		return SUCCESS;
	}
	
	public String grantCompany(){
		String companyId = this.getRequest().getParameter("companyId");
		if(!StringUtils.isEmpty(companyId)){
			Long l_companyId = Long.parseLong(companyId);
			String ids = this.getRequest().getParameter("ids");
			if(!StringUtils.isEmpty(ids)){
				String[] s_ids = ids.split(",");
				CarInfo car = null;
				for(String id : s_ids){
					if(!StringUtils.isEmpty(id)){
						car = service.get(Long.parseLong(id));
						Set<Company> companys = car.getCompanys();
						Company company = companyService.get(l_companyId);
						companys.add(company);
						car.setCompanys(companys);
						service.save(car);
					}
				}
			}
		}
		return SUCCESS;
	}
}
