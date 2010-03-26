package org.eclipse.epsilon.emc.plainxml;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertyGetter;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PlainXmlPropertyGetter extends JavaPropertyGetter {

	@Override
	public Object invoke(Object object, String property)
			throws EolRuntimeException {

		if(object instanceof Element) {
			
			Element e = (Element) object;
			
			if ("children".equals(property)) {
				return DomUtil.getChildren(e);
			}
			
			if ("text".equals(property)) {
				return e.getTextContent();
			}
			
			PlainXmlProperty p = PlainXmlProperty.parse(property);
			
			if (p != null) {
			
				if (p.isAttribute()) {
					return p.cast(e.getAttribute(p.getProperty()));
				}
				else if (p.isText()) {
					return p.cast(e.getTextContent());
				}
				else {
					List<Element> children = DomUtil.getChildren(e);
					List<Element> result = new ArrayList<Element>();
					
					// Look for elements with this specific tag name
					for (Element child : children) {
						if (child.getTagName().equals(p.getProperty())) {
							result.add(child);
						}
					}
					
					if (p.isMany()) {
						return result;
					}
					else if (result.size() > 0) {
						return result.get(0);
					}
					else {
						return null;
					}
					
				}	
			}
		}
		
		return super.invoke(object, property);
		
	}

}
