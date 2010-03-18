package org.eclipse.epsilon.emc.plainxml;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertySetter;
import org.w3c.dom.Element;

public class PlainXmlPropertySetter extends JavaPropertySetter {
	
	@Override
	public void invoke(Object value) throws EolRuntimeException {
		
		if (object instanceof Element) {
			Element e = (Element) object;
			if ("text".equals(property)) {
				e.setTextContent(String.valueOf(value));
				return;
			}
		}
		
		super.invoke(value);
	}
	
}
