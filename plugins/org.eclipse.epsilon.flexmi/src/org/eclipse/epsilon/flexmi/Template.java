package org.eclipse.epsilon.flexmi;

import java.util.ArrayList;
import java.util.List;

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
		
		List<String> parameters = new ArrayList<String>();
		for (String attributeName : Xml.getAttributeNames(call)) {
			if (attributeName.startsWith(Template.PREFIX)) parameters.add(attributeName);
		}
		
		for (String attributeName : Xml.getAttributeNames(element)) {
			String value = element.getAttribute(attributeName);
			for (String parameter : parameters) {
				value = value.replace("${" + parameter.substring(Template.PREFIX.length()) + "}", call.getAttribute(parameter));
			}
			element.setAttribute(attributeName, value);
		}
		
		for (Element child : Xml.getChildren(element)) {
			replaceParameters(child, call);
		}
		
	}
	
}
