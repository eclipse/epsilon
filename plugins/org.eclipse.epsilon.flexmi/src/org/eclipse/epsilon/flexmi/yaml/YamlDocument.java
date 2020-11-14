/*********************************************************************
 * Copyright (c) 2020 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.flexmi.yaml;

import java.util.stream.Collectors;

import org.eclipse.epsilon.flexmi.yaml.base.BaseDocument;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;

public class YamlDocument extends BaseDocument {
	
	protected YamlElement documentElement;
	protected YamlNodeList children;
	
	@SuppressWarnings("unchecked")
	public YamlDocument(org.yaml.snakeyaml.nodes.Node node) {
		children = new YamlElement(null, node).getChildren();
	}
	
	@Override
	public String getNodeName() {
		return "document";
	}

	@Override
	public NodeList getChildNodes() {
		return children;
	}
	
	@Override
	public Element getDocumentElement() {
		return (Element) children.stream().filter(c -> c.getClass() == YamlElement.class).findAny().orElse(null);
	}
	
	public String toXml() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<?xml version=\"1.0\"?>");
		buffer.append(System.lineSeparator());
		children.stream().filter(c -> c instanceof ProcessingInstruction).forEach(c -> {
			toXml(c, buffer, 0);
		});
		buffer.append("<_>");
		buffer.append(System.lineSeparator());
		children.stream().filter(c -> c instanceof Element).forEach(c -> {
			toXml(c, buffer, 1);
		});
		buffer.append("</_>");
		return buffer.toString();
	}
	
	protected void toXml(YamlNode node, StringBuffer buffer, int indentation) {
		for (int i=0;i<indentation;i++) buffer.append("  ");
		if (node instanceof YamlProcessingInstruction) {
			YamlProcessingInstruction pi = (YamlProcessingInstruction) node;
			buffer.append("<?" + pi.getTarget() + " " + pi.getData() + "?>");
			buffer.append(System.lineSeparator());
		}
		else {
			YamlElement el = (YamlElement) node;
			YamlAttributes attributes = (YamlAttributes) el.getAttributes();
			String attributesString = attributes.keySet().stream().map(key -> key + "=\"" + attributes.get(key) + "\"").collect(Collectors.joining(" "));
			if (el.getChildren().isEmpty()) {
				buffer.append("<" + el.getNodeName() + " " + attributesString + "/>");
				buffer.append(System.lineSeparator());
			}
			else {
				buffer.append("<" + el.getNodeName() + " " + attributesString + ">");
				buffer.append(System.lineSeparator());
				el.getChildren().forEach(c -> toXml(c, buffer, indentation+1));
				for (int i=0;i<indentation;i++) buffer.append("  ");
				buffer.append("</" + el.getNodeName() + ">");
				buffer.append(System.lineSeparator());
			}
		}
		
	}
	
}
