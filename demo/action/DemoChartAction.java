package com.foton.m2m.demo.action;

import java.util.ArrayList;
import java.util.List;

import com.foton.m2m.chart.util.ChartTypeEnum;
import com.foton.m2m.chart.util.fusion.build.FusionBuilder;
import com.foton.m2m.chart.util.fusion.model.FunsionItem;
import com.foton.m2m.chart.util.fusion.model.FusionCharts;
import com.foton.m2m.chart.util.fusion.model.FusionElements;
import com.foton.m2m.framework.core.web.action.BaseAction;

public class DemoChartAction extends BaseAction {

	private static FusionCharts charts = new FusionCharts();
	static {
		FunsionItem funsionItem = null;
		List<String> xaxisValues = new ArrayList<String>();
		
		List<FunsionItem> item1 = new ArrayList<FunsionItem>();
		
		for(int i = 0 ; i < 12 ; i++){
			funsionItem = new FunsionItem((i+1)+"", Math.random()*100+"", "Right");
			item1.add(funsionItem);
			xaxisValues.add((i+1)+"月");
		}
		FusionElements element1 = new FusionElements();
		element1.setText("测试1");
//		element1.setType(type);
//		element1.setStyle(style);
		element1.setValues(item1);
		
		List<FunsionItem> item2 = new ArrayList<FunsionItem>();
		for(int i = 0 ; i < 12 ; i++){
			funsionItem = new FunsionItem((i+1)+"", Math.random()*100+"", "Right");
			item2.add(funsionItem);
		}
		FusionElements element2 = new FusionElements();
		element2.setText("测试2");
//		element2.setType(type);
//		element2.setStyle(style);
		element2.setValues(item2);
		
		List<FunsionItem> item3 = new ArrayList<FunsionItem>();
		for(int i = 0 ; i < 12 ; i++){
			funsionItem = new FunsionItem((i+1)+"", ((int)(Math.random()*100))+"", "Right");
			item3.add(funsionItem);
		}
		FusionElements element3 = new FusionElements();
		element3.setText("测试3");
//		element3.setType(type);
//		element3.setStyle(style);
		element3.setValues(item3);
		
		List<FusionElements> fusionElements = new ArrayList<FusionElements>();
		fusionElements.add(element1);
		fusionElements.add(element2);
		fusionElements.add(element3);
		
		charts.setCaption("测试图表");
		
		charts.setxAxisName("时间");
		charts.setyAxisName("数值");
		
		charts.setXaxisValues(xaxisValues);
		charts.setElements(fusionElements);
//		charts.setyAxisMaxValue(yAxisMaxValue);
//		charts.setyAxisMinValue(yAxisMinValue);
	}

	public String bar() {
		charts.setSubCaption("柱状图");
		setJsonString("{success:true,chart:'"+FusionBuilder.getXmlData(charts, ChartTypeEnum.MSColumn3D)+"'}");
		return "success";
	}

	public String line() {
		charts.setSubCaption("曲线图");
		setJsonString("{success:true,chart:'"+FusionBuilder.getXmlData(charts, ChartTypeEnum.MSLine)+"'}");
		return "success";
	}

	public String pie() {
		charts.setSubCaption("饼状图");
		setJsonString("{success:true,chart:'"+FusionBuilder.getXmlData(charts, ChartTypeEnum.Doughnut3D)+"'}");
		return "success";
	}
}
