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

/**
 * 
 * @author Sina Madani
 * @since 2.2
 */
public class KatexContentTransformer implements ViewContentTransformer {

	@Override
	public boolean canTransform(ViewContent content) {
		return "katex".equalsIgnoreCase(content.getFormat());
	}

	@Override
	public String getLabel(ViewContent content) {
		return "KaTeX";
	}

	@Override
	public ViewContent transform(ViewContent content, PictoView pictoView) throws Exception {
		String id = "katex-"+System.currentTimeMillis();
		String html = "<div>" +
			"<script defer src=\"https://cdn.jsdelivr.net/npm/katex@0.12.0/dist/katex.min.js\"></script>\n" + 
			"<script defer src=\"https://cdn.jsdelivr.net/npm/katex@0.12.0/dist/contrib/auto-render.min.js\"" + 
			"onload=\"renderMathInElement(document.body);\"></script>\n" +
			"<div id=\""+id+"\"></div>\n" +
			"<script>katex.render(\""+content.getText()+"\", document.getElementById(\""+id+"\"), {throwOnError: false});</script></div>";
		
		return new ViewContent("html", html, content);
	}
}
