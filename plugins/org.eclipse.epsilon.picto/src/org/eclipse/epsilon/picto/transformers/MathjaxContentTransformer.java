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
public class MathjaxContentTransformer implements ViewContentTransformer {

	@Override
	public boolean canTransform(ViewContent content) {
		return "mathjax".equalsIgnoreCase(content.getFormat());
	}

	@Override
	public String getLabel(ViewContent content) {
		return "MathJax";
	}

	@Override
	public ViewContent transform(ViewContent content, PictoView pictoView) throws Exception {
		String html = "<div>" +
			"<script src=\"https://polyfill.io/v3/polyfill.min.js?features=es6\"></script>\n" +
			"<script>\n" + 
			"MathJax = {\n" + 
			"  tex: {\n" + 
			"    inlineMath: [['$', '$'], ['\\\\(', '\\\\)']]\n" + 
			"  },\n" + 
			"  svg: {\n" + 
			"    fontCache: 'global'\n" + 
			"  }\n" + 
			"};\n" + 
			"</script>\n"+
			"<script id=\"MathJax-script\" async src=\"https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-mml-chtml.js\"></script>\n" +
			"<p>"+content.getText()+"</p></div>";
		
		return new ViewContent("html", html, content);
	}
}
