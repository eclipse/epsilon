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

import org.eclipse.epsilon.flexmi.xml.Xml;
import org.w3c.dom.Element;

public class TemplateFactory {
	
	protected static TemplateFactory instance;
	
	public static TemplateFactory getInstance() {
		if (instance == null) {
			instance = new TemplateFactory();
		}
		return instance;
	}

	public TemplateFactory() {
		
	}
	
	public Template createTemplate(Element element, URI uri) {
		if ("EGL".contentEquals(Xml.getChild(element, "content").getAttribute("language"))) {
			return new EglTemplate(element, uri);
		}
		else if ("EOL".contentEquals(Xml.getChild(element, "content").getAttribute("language"))) {
			return new EolTemplate(element, uri);
		}
		return new XmlTemplate(element, uri);
	}
	
	
}
