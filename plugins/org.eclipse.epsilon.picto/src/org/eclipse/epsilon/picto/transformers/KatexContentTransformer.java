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

import java.io.IOException;
import java.nio.file.Path;
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
	
	
	/**
	 * Converts KaTeX notation to HTML.
	 * 
	 * @param katex The KaTeX as string.
	 * @return The generated HTML file.
	 * @throws IOException If invoking KaTeX CLI is unsuccessful.
	 */
	public static Path katexToHtml(String katex) throws IOException {
		Path input = ExternalContentTransformation.createTempFile("tex", katex.trim().getBytes());
		return katexToHtml(input);
	}
	
	/**
	 * Converts KaTeX notation in the given file to HTML.
	 * 
	 * @param katex The file containing KaTeX.
	 * @return The generated HTML file.
	 * @throws IOException If invoking KaTeX CLI is unsuccessful.
	 */
	public static Path katexToHtml(Path katex) throws IOException {
		ExternalContentTransformation ect = katex(katex);
		ect.call();
		return ect.getOutputFile();
	}
	
	protected static ExternalContentTransformation katex(Path katex) {
		Path imgTmp = katex.getParent().resolve(katex.getFileName()+".html");
		String program = ExternalContentTransformation.resolveNodeProgram("katex");
		return new ExternalContentTransformation(
			imgTmp, program, "-i", katex, "-o", imgTmp
		);
	}
}
