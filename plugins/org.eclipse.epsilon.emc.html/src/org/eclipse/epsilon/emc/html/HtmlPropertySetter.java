package org.eclipse.epsilon.emc.html;

import org.eclipse.epsilon.emc.plainxml.PlainXmlProperty;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertySetter;
import org.jsoup.nodes.Element;

public class HtmlPropertySetter extends JavaPropertySetter {
	
	@Override
	public void invoke(Object target, String property, Object value, IEolContext context) throws EolRuntimeException {
		PlainXmlProperty p = PlainXmlProperty.parse(property);
		if (p != null && p.isAttribute()) {
			Element element = (Element) target;
			element.attr(p.getProperty(), String.valueOf(value));
			return;
		}
		super.invoke(target, property, value, context);
	}
	
}
