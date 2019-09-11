package com.foton.m2m.chart.util.fusion.model;

import java.util.List;

/**
 * FusionChart主类
 * 
 * @author sung
 * 
 */
public class FusionCharts {
	private String caption; // 标题
	private String subCaption;// 副标题
	private String yAxisName;// y轴名称
	private String xAxisName;// x轴名称

	private String yAxisMaxValue; // y轴最大值
	private String yAxisMinValue; // y轴最小值

	private List<String> xaxisValues;// x轴
	private List<FusionElements> elements;//

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getSubCaption() {
		return subCaption;
	}

	public void setSubCaption(String subCaption) {
		this.subCaption = subCaption;
	}

	public String getyAxisName() {
		return yAxisName;
	}

	public void setyAxisName(String yAxisName) {
		this.yAxisName = yAxisName;
	}

	public String getxAxisName() {
		return xAxisName;
	}

	public void setxAxisName(String xAxisName) {
		this.xAxisName = xAxisName;
	}

	public String getyAxisMaxValue() {
		return yAxisMaxValue;
	}

	public void setyAxisMaxValue(String yAxisMaxValue) {
		this.yAxisMaxValue = yAxisMaxValue;
	}

	public String getyAxisMinValue() {
		return yAxisMinValue;
	}

	public void setyAxisMinValue(String yAxisMinValue) {
		this.yAxisMinValue = yAxisMinValue;
	}

	public List<String> getXaxisValues() {
		return xaxisValues;
	}

	public void setXaxisValues(List<String> xaxisValues) {
		this.xaxisValues = xaxisValues;
	}

	public List<FusionElements> getElements() {
		return elements;
	}

	public void setElements(List<FusionElements> elements) {
		this.elements = elements;
	}

}
