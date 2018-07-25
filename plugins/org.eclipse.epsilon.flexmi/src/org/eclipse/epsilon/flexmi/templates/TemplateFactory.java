package org.eclipse.epsilon.flexmi.templates;

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
	
	public Template createTemplate(Element element) {
		if ("EGL".contentEquals(Xml.getChild(element, "content").getAttribute("language"))) {
			return new EglTemplate(element);
		}
		return new XmlTemplate(element);
	}
	
	
}
