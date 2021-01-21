/*********************************************************************
* Copyright (c) 2020 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.picto.transformers;

import java.io.StringReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.eclipse.epsilon.picto.PictoView;
import org.eclipse.epsilon.picto.ViewContent;

public class CsvContentTransformer implements ViewContentTransformer {
	
	@Override
	public boolean canTransform(ViewContent content) {
		return "csv".equalsIgnoreCase(content.getFormat());
	}

	@Override
	public ViewContent transform(ViewContent content, PictoView pictoView) throws Exception {

		CSVFormat format = CSVFormat.RFC4180.withFirstRecordAsHeader();
		CSVParser records = format.parse(new StringReader(content.getText()));

		StringBuilder result = new StringBuilder();
		result.append(
				"<table class=\"table striped table-border row-hover\" data-horizontal-scroll=\"true\" data-role=\"table\" data-pagination=\"true\">")
				.append("<thead>");
		for (String column : records.getHeaderNames()) {
			result.append("<th class=\"sortable-column sort-asc\">")
					.append(column)
					.append("</th>");
		}
		result.append("</thead>")
				.append("<tbody>");
		for (CSVRecord record : records) {
			result.append("<tr>");
			for (String cell : record) {
				result.append("<td>").append(cell).append("</td>");
			}
			result.append("</tr>");
		}
		result.append("</tbody>")
				.append("</table>");
		
		return new ViewContent("html", pictoView.getViewRenderer().getHtml(result.toString()), content);
	}
	
	@Override
	public String getLabel(ViewContent content) {
		return "CSV";
	}
}
