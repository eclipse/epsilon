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

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.eclipse.epsilon.picto.PictoView;
import org.eclipse.epsilon.picto.ViewContent;
import org.eclipse.epsilon.picto.transformers.elements.HtmlElementTransformer;
import org.eclipse.epsilon.picto.transformers.elements.PictoViewElementTransformer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class HtmlContentTransformer implements ViewContentTransformer {
	
	protected List<HtmlElementTransformer> htmlElementTransformers = Arrays.asList(new PictoViewElementTransformer());
	protected DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	protected TransformerFactory transformerFactory = TransformerFactory.newInstance();
	protected Transformer transformer;
	protected DocumentBuilder documentBuilder;
	
	public HtmlContentTransformer() {
		try {
			transformer = transformerFactory.newTransformer();
			documentBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
		}
		catch (Exception ex) {}
	}
	
	protected String transformElements(Document document, PictoView picto) throws Exception {
		
		for (HtmlElementTransformer htmlElementTransformer : htmlElementTransformers) {
			
			htmlElementTransformer.setPictoView(picto);
			
			NodeList nodeList = getElements(document, htmlElementTransformer.getXPath()); 			
			for (int i = 0; i<nodeList.getLength(); i++) {
				htmlElementTransformer.transform((Element) nodeList.item(i));
			}
		}
		
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		transformer.setOutputProperty(OutputKeys.METHOD, "html");
		transformer.transform(new DOMSource(document.getDocumentElement()), result);
		
		return writer.toString();
	}
	
	public Document parse(String xml) throws Exception {
		return documentBuilder.parse(new InputSource(new StringReader(xml)));
	}
	
	@Override
	public boolean canTransform(ViewContent content) {
		return content.getFormat().equals("html");
	}

	@Override
	public String getLabel(ViewContent content) {
		return "HTML";
	}

	@Override
	public ViewContent transform(ViewContent content, PictoView pictoView) throws Exception {
		String text = content.getText();
		
		try {
			Document document = parse(text);
			for (HtmlElementTransformer htmlElementTransformer : htmlElementTransformers) {
				if (getElements(document, htmlElementTransformer.getXPath()).getLength() > 0) {
					return new ViewContent("html", transformElements(document, pictoView), content.getLayers(), content.getPatches());
				}
			}
			return null;
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	protected NodeList getElements(Document document, String xpath) throws Exception {
		XPath xPath = XPathFactory.newInstance().newXPath();
		return (NodeList) xPath.compile(xpath).evaluate(document, XPathConstants.NODESET);

	}
	
}
