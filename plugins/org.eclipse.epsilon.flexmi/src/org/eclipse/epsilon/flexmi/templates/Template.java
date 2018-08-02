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
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.text.StrLookup;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.eclipse.epsilon.flexmi.xml.Xml;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public abstract class Template {
	
	protected String name;
	protected ArrayList<String> parameters = new ArrayList<String>();
	protected Element content;
	protected URI uri;
	
	public static final String NODE_NAME = "_template";
	public static final String PREFIX = "_";
	
	public Template(Element element, URI uri) {
		this.uri = uri;
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
	
	public abstract List<Element> apply(Element call);
	
}
