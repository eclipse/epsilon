/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.flexmi.templates;

import java.net.URI;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.emc.plainxml.StringInputStream;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.flexmi.FlexmiResource;
import org.eclipse.epsilon.flexmi.xml.Xml;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class EglTemplate extends DynamicTemplate {

	public EglTemplate(Element element, FlexmiResource resource, URI uri) {
		super(element, resource, uri);
	}

	@Override
	public List<Element> getApplication(Element call) {
		try {
			EglTemplateFactoryModuleAdapter module = new EglTemplateFactoryModuleAdapter(new EglTemplateFactory());
			module.parse(content.getTextContent().trim(), uri);
			if (!module.getParseProblems().isEmpty()) throw new RuntimeException(module.getParseProblems().get(0).toString());
			
			prepareModule(module, call);
			
			String xml = "<?xml version=\"1.0\"?><root>" + (module.execute() + "").trim() + "</root>";
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(new StringInputStream(xml));
			return Xml.getChildren(document.getDocumentElement());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
