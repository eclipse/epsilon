package org.eclipse.epsilon.flexmi;

import java.util.ArrayList;

import org.eclipse.epsilon.flexmi.xml.Xml;
import org.w3c.dom.Element;

public class Template {
	
	protected String name;
	protected ArrayList<String> parameters = new ArrayList<String>();
	protected Element content;
	
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
}
