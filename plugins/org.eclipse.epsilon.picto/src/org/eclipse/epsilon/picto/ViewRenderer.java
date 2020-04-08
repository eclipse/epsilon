/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.picto;

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

import org.eclipse.epsilon.picto.transformers.elements.HtmlElementTransformer;
import org.eclipse.epsilon.picto.transformers.elements.PictoViewElementTransformer;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.graphics.Point;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;

public class ViewRenderer {
	
	protected Browser browser;
	protected double zoom = 1.0;
	protected List<HtmlElementTransformer> htmlElementTransformers = Arrays.asList(new PictoViewElementTransformer());
	protected DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	protected TransformerFactory transformerFactory = TransformerFactory.newInstance();
	protected Transformer transformer;
	protected DocumentBuilder documentBuilder;
	protected PictoView picto;
	
	protected String transformElements(String content) throws Exception {
		
		Document document = null;
		
		document = parse(content);
		
		for (HtmlElementTransformer htmlElementTransformer : htmlElementTransformers) {
			
			htmlElementTransformer.setPictoView(picto);
			XPath xPath = XPathFactory.newInstance().newXPath();
			String expression = "//*[local-name() = '" + htmlElementTransformer.getElementName() + "']";
			
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
			
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
	
	public ViewRenderer(PictoView picto, Browser browser) {
		this.picto = picto;
		this.browser = browser;
		try {
			transformer = transformerFactory.newTransformer();
			documentBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
		}
		catch (Exception ex) {}
	}
	
	public Browser getBrowser() {
		return browser;
	}
	
	public Document parse(String xml) throws Exception {
		return documentBuilder.parse(new InputSource(new StringReader(xml)));
	}
	
	public Point getScrollPosition() {
		Double scrollX = (Double) browser.evaluate("return window.pageXOffset;");
		Double scrollY = (Double) browser.evaluate("return window.pageYOffset;");
		return new Point(scrollX.intValue(), scrollY.intValue());
	}
	
	public Point getPrintableArea() {
		return new Point(
				((Double) browser.evaluate("return document.body.scrollWidth")).intValue(),
				((Double) browser.evaluate("return document.body.scrollHeight")).intValue());
	}
	
	public void setScrollPosition(Point point) {
		browser.evaluate("window.scroll(" + point.x + ", " + point.y + ");");
	}
	
	public void zoom(ZoomType type) {
		if (type == ZoomType.IN) zoom = Math.min(zoom + 0.1, 3.0);
		else if (type == ZoomType.OUT) zoom = Math.max(0.1, zoom - 0.1);
		else zoom = 1.0;
		
		browser.execute("javascript:document.body.style.zoom=" + zoom + ";");
	}
	
	public double getZoom() {
		return zoom;
	}
	
	public void display(Exception ex) {
		display(getZoomableVerbatim(ex.getMessage()));
	}
	
	public void display(String text) {
		browser.setText(text.replace("${picto-zoom}", zoom + ""));
	}
	
	public void nothingToRender() {
		display(getZoomableHtml(""));
	}
	
	public String getZoomableHtml(String content) {
		
		try { content = transformElements(content); }
		catch (Exception ex) {}
		
		return "<html><body style=\"zoom:${picto-zoom}\">\n" + content + "\n</body></html>";
	}
	
	public String getZoomableVerbatim(String content) {
		return getZoomableHtml("<pre>\n" + escapeHtml(content) + "</pre>");
	}
	
	private String escapeHtml(String html) {
		try {
			Document document = documentBuilder.newDocument();
			Text text = document.createTextNode(html);
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			DOMSource source = new DOMSource(text);
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.transform(source, result);
			return writer.toString();
		}
		catch (Exception ex) {
			return html;
		}
	}
	
	public enum ZoomType {
		IN,
		OUT,
		ACTUAL
	}
	
	
	
	
	
}
