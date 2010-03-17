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
			
			if ("text".equals(property)) {
				return e.getTextContent();
			}
			
			if ("children".equals(property)) {
				return DomUtil.getChildren(e);
			}
			
			if (e.hasAttribute(property)) {
				return e.getAttribute(property);
			}
			else {
				List<Element> children = DomUtil.getChildren(e);
				List<Element> result = new ArrayList<Element>();
				
				// Look for elements with this specific tag name
				for (Element child : children) {
					if (child.getTagName().equals(property)) {
						result.add(child);
					}
				}
				
				if (result.size() == 1) {
					return result.get(0);
				}
				else if (result.size() > 1) {
					return result;
				}
				
				//Nothing found so far.
				
				//If the property ends with an s
				//look for elements with a tagname = property - s
				
				if (property.endsWith("s")) {
					
					String singular = property.substring(0, property.length() - 1);
					
					for (Element child : children) {
						if (child.getTagName().equals(singular)) {
							result.add(child);
						}
					}
					
				}
				
				if (result.size() > 0) {
					return result;
				}
				
			}
			
		}
		
		return super.invoke(object, property);
		
		
	}

}
