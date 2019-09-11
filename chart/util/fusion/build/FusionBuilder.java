package com.foton.m2m.chart.util.fusion.build;

import java.util.List;

import com.foton.m2m.chart.util.ChartTypeEnum;
import com.foton.m2m.chart.util.fusion.model.FusionCharts;
import com.foton.m2m.chart.util.fusion.model.FusionElements;
import com.foton.m2m.chart.util.fusion.model.FunsionItem;

public class FusionBuilder {

	public synchronized static String getXmlData(FusionCharts c,
			ChartTypeEnum chartTypeEnum) {
		StringBuffer data = new StringBuffer();
		if (ChartTypeEnum.Doughnut3D.equals(chartTypeEnum)) {
			List<FusionElements> elements = c.getElements();
			data.append("<chart caption=\"");
			data.append(c.getCaption());
			data.append("\" subCaption=\"");
			data.append(c.getSubCaption());
			data.append("\" imageSave=\"1\" imageSaveURL=\"/chart/FCExporter\" bgColor=\"FFFFFF\" showBorder=\"0\" pieYScale=\"30\" plotFillAlpha=\"80\" pieInnerfaceAlpha=\"60\" slicingDistance=\"35\" startingAngle=\"190\" enableSmartLabels=\"0\" showBorder=\"1\" showValues=\"0\" showLabels=\"0\" showLegend=\"1\">");
			if (elements != null) {
				for (FusionElements el : elements) {
					data.append("<set label=\"");
					data.append(el.getText());
					data.append("\" value=\"");
					List<FunsionItem> items = el.getValues();
					if (items != null)
						data.append(items.get(0).getValue());
					data.append("\"/>");
				}
			}
		} else {
			data.append("<chart caption=\"");
			data.append(c.getCaption());
			data.append("\" subCaption=\"");
			data.append(c.getSubCaption());
			data.append("\" yAxisName=\"");
			data.append(c.getyAxisName());
			data.append("\" imageSave=\"1\" imageSaveURL=\"/chart/FCExporter\" bgColor=\"FFFFFF\" showBorder=\"0\" palette=\"2\" animation=\"1\" formatNumberScale=\"0\" showValues=\"0\" numDivLines=\"4\" legendPosition=\"BOTTOM\">");

			data.append("<categories>");
			List<String> list = c.getXaxisValues();
			if (list != null)
				for (String val : list) {
					data.append("<category label=\"");
					data.append(val);
					data.append("\" />");
				}
			data.append("</categories>");
			List<FusionElements> elements = c.getElements();
			if (elements != null)
				for (FusionElements el : elements) {
					data.append("<dataset seriesName=\"");
					data.append(el.getText());
					data.append("\">");
					List<FunsionItem> items = el.getValues();
					if (items != null)
						for (FunsionItem io : items) {
							data.append("<set value=\"");
							data.append(io.getValue());
							data.append("\"/>");
						}
					data.append("</dataset>");
				}
		}
		data.append("</chart>");
		return data.toString();
	}
}
