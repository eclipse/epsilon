/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.flexmi;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.text.StrLookup;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.eclipse.epsilon.flexmi.xml.Xml;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Template {
	
	protected String name;
	protected ArrayList<String> parameters = new ArrayList<String>();
	protected Element content;
	
	public static final String NODE_NAME = "_template";
	public static final String PREFIX = "_";
	
	public Template(Element element) {
		this.name = element.getAttribute("name");
		for (Element parameterElement : Xml.getChildren(element, "parameter")) {
			parameters.add(parameterElement.getAttribute("name"));
		}
		content = Xml.getChild(element, "content");
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<String> getParameters() {
		return parameters;
	}
	
	public Element getContent() {
		return content;
	}
	
	public List<Element> apply(Node node) {
		
		Element call = (Element) node;
		List<Element> application = new ArrayList<Element>();
		for (Element contentChild : Xml.getChildren(content)) {
			application.add((Element) contentChild.cloneNode(true));
		}
		
		for (Element applicationElement : application) {
			for (String attributeName : Xml.getAttributeNames(call)) {
				if (!attributeName.startsWith(Template.PREFIX)) {
					applicationElement.setAttribute(attributeName, call.getAttribute(attributeName));
				}
			}
			replaceParameters(applicationElement, call);
		}
		
		return application;
	}
	
	protected void replaceParameters(Element element, Element call) {
		
		StrSubstitutor substitutor = new StrSubstitutor(new StrLookup<String>() {
			@Override
			public String lookup(String name) {
				return call.getAttribute("_" + name);
			}
		});
		
		for (Node attribute : Xml.getAttributes(element)) {
			if (attribute.getNodeValue().indexOf("$") > -1) {
				attribute.setNodeValue(substitutor.replace(attribute.getNodeValue()));
			}
		}
		
		for (Element child : Xml.getChildren(element)) {
			replaceParameters(child, call);
		}
		
	}
	
}
