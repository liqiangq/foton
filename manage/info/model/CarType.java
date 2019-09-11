package com.foton.m2m.manage.info.model;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonProperty;

import com.foton.m2m.framework.core.model.BaseModel;

@JsonAutoDetect(JsonMethod.NONE)
public class CarType extends BaseModel {

	private static final long serialVersionUID = 1L;

	@JsonProperty
	private Long id;
	
	@JsonProperty
	private String code;
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private CarBrand carBrand;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CarBrand getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(CarBrand carBrand) {
		this.carBrand = carBrand;
	}

}
