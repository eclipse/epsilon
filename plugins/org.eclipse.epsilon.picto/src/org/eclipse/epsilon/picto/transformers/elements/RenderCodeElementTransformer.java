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

import java.util.Collections;

import org.eclipse.epsilon.picto.ViewContent;
import org.w3c.dom.Element;

public class RenderCodeElementTransformer extends ReplacingElementTransformer {
	
	@Override
	public String getXPath() {
		return "//code[starts-with(@class,'language-render')]";
	}
	
	@Override
	public void transform(Element element) {
		
		String text = element.getChildNodes().item(0).getTextContent();
		String format = element.getAttribute("class").substring("language-render-".length());
		ViewContent viewContent = new ViewContent(format, text, null, Collections.emptyList(), Collections.emptyList(), Collections.emptySet());
		ViewContent svgContent = null;
		ViewContent lastContent = null;
		
		while (viewContent != null) {
			if ("svg".equals(viewContent.getFormat())) {
				svgContent = viewContent;
				break;
			}
			else {
				lastContent = viewContent;
				viewContent = viewContent.getNext(picto);
			}
		}
		
		if (element.getParentNode() != null && element.getParentNode().getNodeName().equalsIgnoreCase("pre")) {
			element = (Element) element.getParentNode();
		}
		
		if (svgContent != null) {
			replace(element, svgContent, true);
		}
		else {
			replace(element, lastContent, false);
		}
	}
}