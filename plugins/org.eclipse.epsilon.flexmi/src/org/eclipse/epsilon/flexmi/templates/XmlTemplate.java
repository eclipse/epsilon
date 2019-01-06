package org.eclipse.epsilon.flexmi.templates;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.text.StrLookup;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.eclipse.epsilon.flexmi.xml.Xml;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XmlTemplate extends Template {

	public XmlTemplate(Element element, URI uri) {
		super(element, uri);
	}

	public List<Element> apply(Element call) {
		
		List<Element> application = getApplication(call);
		
		for (Element applicationElement : application) {
			for (String attributeName : Xml.getAttributeNames(call)) {
				if (!getParameters().contains(attributeName)) {
					applicationElement.setAttribute(attributeName, call.getAttribute(attributeName));
				}
			}
			replaceParameters(applicationElement, call);
		}
		
		return application;
	}
	
	public List<Element> getApplication(Element call) {
		List<Element> application = new ArrayList<Element>();
		for (Element contentChild : Xml.getChildren(content)) {
			application.add((Element) contentChild.cloneNode(true));
		}
		return application;
	}
	
	protected void replaceParameters(Element element, Element call) {
		
		StrSubstitutor substitutor = new StrSubstitutor(new StrLookup<String>() {
			@Override
			public String lookup(String name) {
				if (call.hasAttribute(Template.PREFIX + name)) {
					return call.getAttribute(Template.PREFIX + name);
				}
				return call.getAttribute(name);
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
