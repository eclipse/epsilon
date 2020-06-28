/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.picto.transformers;

import java.io.StringWriter;

import org.eclipse.epsilon.picto.PictoView;
import org.eclipse.epsilon.picto.ViewContent;
import org.eclipse.mylyn.wikitext.markdown.MarkdownLanguage;
import org.eclipse.mylyn.wikitext.parser.MarkupParser;
import org.eclipse.mylyn.wikitext.parser.builder.HtmlDocumentBuilder;

public class MarkdownContentTransformer implements ViewContentTransformer {
	
	@Override
	public boolean canTransform(ViewContent content) {
		return "markdown".equals(content.getFormat());
	}

	@Override
	public ViewContent transform(ViewContent content, PictoView pictoView) throws Exception {
		
		MarkupParser markupParser = new MarkupParser();
		markupParser.setMarkupLanguage(new MarkdownLanguage());
		StringWriter writer = new StringWriter();
		HtmlDocumentBuilder builder = new HtmlDocumentBuilder(writer, true);
		builder.setEmitAsDocument(false);
		markupParser.setBuilder(builder);
		markupParser.parse(content.getText());
		
		return new ViewContent(
			"html", pictoView.getViewRenderer().getHtml(writer.toString()),
			content.getFile(), content.getLayers(), content.getPatches(), content.getBaseUris()
		);
	}
	
	@Override
	public String getLabel(ViewContent content) {
		return "Markdown";
	}
	
}
