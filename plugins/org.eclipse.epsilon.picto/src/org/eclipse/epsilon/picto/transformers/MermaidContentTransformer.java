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

import org.eclipse.epsilon.picto.PictoView;
import org.eclipse.epsilon.picto.ViewContent;

public class MermaidContentTransformer implements ViewContentTransformer {

	@Override
	public boolean canTransform(ViewContent content) {
		return "mermaid".equals(content.getFormat());
	}

	@Override
	public String getLabel(ViewContent content) {
		return "Mermaid";
	}

	@Override
	public ViewContent transform(ViewContent content, PictoView pictoView) throws Exception {
		
		String html = "<div>" +
			"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/mermaid/7.1.2/mermaid.min.js\"></script>\n" + 
			"<script>\n" + "mermaid.initialize({startOnLoad:true});\n" + "</script>\n"+
			"<div class=\"mermaid\">\n" + content.getText() + "</div></div>";
		
		return new ViewContent("svg", html, content.getFile(), content.getLayers(), content.getPatches());
	}

}
