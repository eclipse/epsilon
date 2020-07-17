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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.picto.PictoView;
import org.eclipse.epsilon.picto.ViewContent;
import org.eclipse.epsilon.picto.XmlHelper;
import org.eclipse.epsilon.picto.transformers.elements.AbsolutePathElementTransformer;
import org.eclipse.epsilon.picto.transformers.elements.HtmlElementTransformer;
import org.eclipse.epsilon.picto.transformers.elements.HtmlElementTransformerExtensionPointManager;
import org.eclipse.epsilon.picto.transformers.elements.PictoViewElementTransformer;
import org.eclipse.epsilon.picto.transformers.elements.RenderCodeElementTransformer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class HtmlContentTransformer implements ViewContentTransformer {
	
	protected List<HtmlElementTransformer> htmlElementTransformers;
	
	public HtmlContentTransformer() {
		htmlElementTransformers = new ArrayList<HtmlElementTransformer>();
		htmlElementTransformers.addAll(Arrays.asList(
			new AbsolutePathElementTransformer("img",  "src"),
			new AbsolutePathElementTransformer("link",  "href"),
			new AbsolutePathElementTransformer("script",  "src"),
			new AbsolutePathElementTransformer("a",  "href"),
			new PictoViewElementTransformer(), 
			new RenderCodeElementTransformer()
		));
		htmlElementTransformers.addAll(new HtmlElementTransformerExtensionPointManager().getExtensions());
	}
	
	protected XmlHelper xmlHelper = new XmlHelper();
	
	@Override
	public boolean canTransform(ViewContent content) {
		return StringUtil.isOneOf(content.getFormat().toLowerCase(), "html", "htm");
	}

	@Override
	public String getLabel(ViewContent content) {
		return "HTML";
	}

	@Override
	public ViewContent transform(ViewContent content, PictoView pictoView) throws Exception {
		
		if (content instanceof FinalViewContent) return null;
		
		String text = content.getText();
		
		try {
			Document document = xmlHelper.parse(text);
			addZoom(document);
			
			for (HtmlElementTransformer htmlElementTransformer : htmlElementTransformers) {
				
				htmlElementTransformer.setPictoView(pictoView);
				htmlElementTransformer.setViewContent(content);
				
				NodeList nodeList = getElements(document, htmlElementTransformer.getXPath()); 			
				for (int i = 0; i<nodeList.getLength(); i++) {
					htmlElementTransformer.transform((Element) nodeList.item(i));
				}
			}
			
			return new FinalViewContent("html", xmlHelper.getXml(document), content);
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	protected void addZoom(Document document) {
		Element html, body;
		Element root = document.getDocumentElement();
		
		// Create/get the html element
		if (root.getNodeName().equalsIgnoreCase("html")) html = root;
		else {
			html = document.createElement("html");
		}
		
		// Create/get the body element
		body = getElementByName(html, "body");
		if (body == null) {
			body = document.createElement("body");
			html.appendChild(body);
		}
		
		body.setAttribute("style", "zoom:${picto-zoom};" + body.getAttribute("style"));
	}
	
	protected Element getElementByName(Element parent, String name) {
		NodeList nodeList = parent.getChildNodes();
		for (int i=0;i<nodeList.getLength();i++) {
			Node node = nodeList.item(i);
			if (node.getNodeName().equalsIgnoreCase(name)) return (Element) node;
		}
		return null;
	}
	
	protected NodeList getElements(Document document, String xpath) throws Exception {
		XPath xPath = XPathFactory.newInstance().newXPath();
		return (NodeList) xPath.compile(xpath).evaluate(document, XPathConstants.NODESET);

	}
	
	static final class FinalViewContent extends ViewContent {
		public FinalViewContent(String format, String text, ViewContent content) {
			super(format, text, content);
		}
	}
	
}
