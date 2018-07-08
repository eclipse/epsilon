package org.eclipse.epsilon.flexmi.xml;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

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
	
	public static Element getChild(Element e, String name) {
		List<Element> children = getChildren(e, name);
		if (children.size() == 0) {
			return null;
		}
		else {
			return children.get(0);
		}
	}
	
	public static List<Element> getChildren(Element e) {
		List<Element> children = new ArrayList<Element>();
		for (int i = 0; i < e.getChildNodes().getLength(); i++) {
			Node child = e.getChildNodes().item(i);
			if (child instanceof Element) {
				Element childElement = (Element) child;
				children.add(childElement);
			}
		}
		return children;
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
