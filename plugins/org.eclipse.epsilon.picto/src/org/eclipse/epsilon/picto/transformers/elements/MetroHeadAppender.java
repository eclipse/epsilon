/*********************************************************************
* Copyright (c) 2020 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.picto.transformers.elements;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class MetroHeadAppender extends AppendingElementTransformer {

	@Override
	public String getXPath() {
		return "//head[1]";
	}
	
	@Override
	protected void append(Element root, Document document) throws DOMException {
		
		// Only applicable for CSV views
		if (viewContent.getAllPrevious().stream().
			noneMatch(vc -> "csv".equals(vc.getFormat()))) return;
		
		String cdn = "https://cdn.metroui.org.ua/v4/";

		Element css = document.createElement("link");
		css.setAttribute("rel", "stylesheet");
		css.setAttribute("href", cdn + "css/metro-all.min.css");
		root.appendChild(css);
		
		Element js = document.createElement("script");
		js.setAttribute("defer", "defer");
		js.setAttribute("src", cdn + "js/metro.min.js");
		root.appendChild(js);
	}

}
