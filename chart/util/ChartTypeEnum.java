package com.foton.m2m.chart.util;

public enum ChartTypeEnum {
	MSColumn3D("MSColumn3D"), MSLine("MSLine"), Doughnut3D("Doughnut3D");
	private String value;

	public String getValue() {
		return value;
	}

	private ChartTypeEnum(String value) {
		this.value = value;
	}
}
