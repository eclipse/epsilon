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

import org.eclipse.epsilon.common.util.StringUtil;
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
		ViewContent imageContent = null, lastContent = null;
		
		// TODO: Why specifically search for SVG and if not found, render in an iframe?
		// Whatever the reason, it seems non-generic. I've changed to support other images too,
		// since I don't see why SVGs are treated differently
		for (ViewContent viewContent = new ViewContent(format, text); viewContent != null; ) {
			if (StringUtil.isOneOf(viewContent.getFormat().toLowerCase(), "svg", "png", "jpg")) {
				imageContent = viewContent;
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
		
		if (imageContent != null) {
			replace(element, imageContent);
		}
		else {
			replace(element, lastContent);
			//replace(element, lastContent, true);
		}
	}
}