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

/**
 * 
 * @author Sina Madani
 * @since 2.2
 */
public class KatexAutorenderHeadAppender extends AppendingElementTransformer {

	@Override
	public String getXPath() {
		return "//head[1]";
	}
	
	@Override
	protected void append(Element root, Document document) throws DOMException {
		String cdn = "https://cdn.jsdelivr.net/npm/katex@0.12.0/dist/";
		Element css = document.createElement("link");
		css.setAttribute("rel", "stylesheet");
		css.setAttribute("href", cdn+"katex.min.css");
		root.appendChild(css);
		
		Element katex = document.createElement("script");
		katex.setAttribute("defer", "defer");
		katex.setAttribute("src", cdn+"katex.min.js");
		root.appendChild(katex);
		
		Element autorender = document.createElement("script");
		autorender.setAttribute("defer", "defer");
		autorender.setAttribute("src", cdn+"contrib/auto-render.min.js");
		autorender.setAttribute("onload", "renderMathInElement(document.body);");
		root.appendChild(autorender);
	}

}
