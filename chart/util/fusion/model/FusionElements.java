package com.foton.m2m.chart.util.fusion.model;

import java.util.List;

/**
 * 每个图例
 * @author sung
 *
 */
public class FusionElements {
	private String type;
	private List<FunsionItem> values;
	private String text;
	private String style;

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<FunsionItem> getValues() {
		return values;
	}

	public void setValues(List<FunsionItem> values) {
		this.values = values;
	}

}
