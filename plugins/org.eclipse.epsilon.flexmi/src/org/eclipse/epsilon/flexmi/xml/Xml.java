/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.flexmi.xml;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Xml {
	
	public static List<Node> getAttributes(Element e) {
		List<Node> attributes = new ArrayList<Node>();
		NamedNodeMap nodeMap = e.getAttributes();
		for (int i = 0; i < nodeMap.getLength(); i++) {
			attributes.add(nodeMap.item(i));
		}
		return attributes;
	}
	
	public static List<String> getAttributeNames(Element e) {
		List<String> names = new ArrayList<String>();
		NamedNodeMap attributes = e.getAttributes();
		for (int i = 0; i < attributes.getLength(); i++) {
			names.add(attributes.item(i).getNodeName());
		}
		return names;
	}
	
	public static List<Element> getDescendant(Element e, String name) {
		return toElementList(e.getElementsByTagName(name));
	}
	
	public static Element getChild(Element e, String name) {
		List<Element> children = getChildren(e, name);
		if (children.size() == 0) {
			return null;
		}
		else {
			return children.get(0);
		}
	}
	
	public static List<Element> toElementList(NodeList nodeList) {
		List<Element> node = new ArrayList<Element>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node child = nodeList.item(i);
			if (child instanceof Element) {
				Element childElement = (Element) child;
				node.add(childElement);
			}
		}
		return node;
	}
	
	public static List<Element> getChildren(Element e) {
		return toElementList(e.getChildNodes());
	}
	
	public static List<Element> getChildren(Element e, String name) {
		List<Element> children = new ArrayList<Element>();
		for (int i = 0; i < e.getChildNodes().getLength(); i++) {
			Node child = e.getChildNodes().item(i);
			if (child instanceof Element) {
				Element childElement = (Element) child;
				if (childElement.getNodeName().equals(name)) children.add(childElement);
			}
		}
		return children;
	}
	
}
