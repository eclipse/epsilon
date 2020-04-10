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

import java.io.File;
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

import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.picto.Layer;
import org.eclipse.epsilon.picto.PictoView;
import org.eclipse.epsilon.picto.ViewContent;
import org.eclipse.epsilon.picto.dom.Patch;
import org.eclipse.epsilon.picto.transformers.elements.HtmlElementTransformer;
import org.eclipse.epsilon.picto.transformers.elements.PictoViewElementTransformer;
import org.eclipse.epsilon.picto.transformers.elements.RenderCodeElementTransformer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class HtmlContentTransformer implements ViewContentTransformer {
	
	protected List<HtmlElementTransformer> htmlElementTransformers = Arrays.asList(new PictoViewElementTransformer(), new RenderCodeElementTransformer());
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
		//transformer.setOutputProperty(OutputKeys.INDENT, "yes");
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
		
		if (content instanceof FinalViewContent) return null;
		
		String text = content.getText();
		
		try {
			Document document = parse(text);
			
			boolean transformToFinalViewContent = addBaseElement(document, content.getFile());
			
			for (HtmlElementTransformer htmlElementTransformer : htmlElementTransformers) {
				if (getElements(document, htmlElementTransformer.getXPath()).getLength() > 0) {
					transformToFinalViewContent = true;
					break;
				}
			}
			
			if (transformToFinalViewContent) {
				return new FinalViewContent("html", transformElements(document, pictoView), content.getFile(), content.getLayers(), content.getPatches());
			}
			else {
				return null;
			}
			
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	protected boolean addBaseElement(Document document, File file) {
		
		if (file == null) return false;
		
		try {
			EolModule module = new EolModule();
			module.getContext().getModelRepository().addModel(new InMemoryPlainXmlModel(document));
			// If the HTML document has no html/body, this will fail and return false
			module.parse("var html = t_html.all.first(); if (html.isUndefined()) return false;" +
					 	 "var head = t_head.all.first();" +
					 	 "var base = t_base.all.first();" +
					     "if (html.isUndefined()) return false;" +
						 "if (head.isUndefined()) { head = new t_head; if (html.children.notEmpty()) html.insertBefore(head, html.children.first()); else html.appendChild(head); }" +
						 "if (base.isUndefined()) { base = new t_base; if (head.children.notEmpty()) head.insertBefore(base, head.children.first()); else head.appendChild(base); }" +
						 "base.a_href = baseUri;" + 
						 "var body = t_body.all.first(); if (body.isUndefined()) return false;" +
						 "body.a_style = 'zoom:${picto-zoom};' + body.a_style;" +
						 "return true;");
			module.getContext().getFrameStack().put(Variable.createReadOnlyVariable("baseUri", file.getParentFile().toURI().toString()));
			
			return (Boolean) module.execute();
		} catch (Exception e) {
			LogUtil.log(e);
			return false;
		}
	}
	
	protected NodeList getElements(Document document, String xpath) throws Exception {
		XPath xPath = XPathFactory.newInstance().newXPath();
		return (NodeList) xPath.compile(xpath).evaluate(document, XPathConstants.NODESET);

	}
	
	class FinalViewContent extends ViewContent {

		public FinalViewContent(String format, String text, File file, List<Layer> layers, List<Patch> patches) {
			super(format, text, file, layers, patches);
		}
		
	}
	
	class InMemoryPlainXmlModel extends PlainXmlModel {
		public InMemoryPlainXmlModel(Document document) {
			this.document = document;
		}
	}
	
}
