package com.foton.m2m.manage.car.model;

import java.util.Set;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonProperty;

import com.foton.m2m.framework.core.model.BaseModel;
import com.foton.m2m.framework.security.model.Company;
import com.foton.m2m.framework.security.model.Position;
import com.foton.m2m.manage.info.model.CarType;

@JsonAutoDetect(JsonMethod.NONE)
public class CarInfo extends BaseModel {

	private static final long serialVersionUID = 1L;

	@JsonProperty
	private Long id;

	@JsonProperty
	private String name;

	@JsonProperty
	private String lpn;

	@JsonProperty
	private CarExpand carExpand;

	@JsonProperty
	private CarType carType;

	private Set<Company> companys = null;

	private Set<Position> positions = null;

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLpn() {
		return lpn;
	}

	public void setLpn(String lpn) {
		this.lpn = lpn;
	}

	public Set<Company> getCompanys() {
		return companys;
	}

	public void setCompanys(Set<Company> companys) {
		this.companys = companys;
	}

	public Set<Position> getPositions() {
		return positions;
	}

	public void setPositions(Set<Position> positions) {
		this.positions = positions;
	}

	public CarExpand getCarExpand() {
		return carExpand;
	}

	public void setCarExpand(CarExpand carExpand) {
		this.carExpand = carExpand;
	}

}
