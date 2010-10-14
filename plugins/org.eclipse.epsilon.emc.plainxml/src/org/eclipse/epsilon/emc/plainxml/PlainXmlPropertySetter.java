package org.eclipse.epsilon.emc.plainxml;

import java.util.Collection;

import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyAssignmentException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertySetter;
import org.w3c.dom.Element;

public class PlainXmlPropertySetter extends JavaPropertySetter {
	
	protected PlainXmlModel model = null;
	
	public PlainXmlPropertySetter(PlainXmlModel model) {
		this.model = model;
	}
	
	@Override
	public void invoke(Object value) throws EolRuntimeException {
		
		if (object instanceof Element) {
			Element e = (Element) object;
			
			if ("text".equals(property)) {
				e.setTextContent(String.valueOf(value));
				return;
			}
			
			PlainXmlProperty p = PlainXmlProperty.parse(property);
			if (p!=null) {
				if (p.isAttribute()) {
					e.setAttribute(p.getProperty(), p.cast(String.valueOf(value)) + "");
					return;
				}
				else if (p.isText()) {
					e.setTextContent(p.cast(String.valueOf(value)) + "");
					return;
				}
				else if (p.isReference()) {
					for (Binding binding : BindingMatcher.getMatchingBindings(model, e, p.getProperty())) {
						if (binding.isMany()) {
							if (!(value instanceof Collection)) {
								throw new EolIllegalPropertyAssignmentException(p.getProperty(), ast);
							}
							else {
								
							}
						}
						else {
							if (!(value instanceof Element)) {
								throw new EolIllegalPropertyAssignmentException(p.getProperty(), ast);
							}
						}
					}
				}
			}
			
		}
		
		super.invoke(value);
	}
	
}
