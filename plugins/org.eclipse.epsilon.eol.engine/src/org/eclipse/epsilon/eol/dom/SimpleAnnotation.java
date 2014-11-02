package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class SimpleAnnotation extends Annotation {
	
	protected String value;
	
	@Override
	public void build() {
		super.build();
		String text = getText().substring(1).trim();
		if (text.indexOf(" ") > -1) {
			String[] parts = text.split(" ");
			name = parts[0];
			value = parts[1];
		}
		else {
			name = text;
		}
	}
	
	@Override
	public boolean hasValue() {
		return value != null;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public Object getValue(IEolContext context) throws EolRuntimeException {
		return getValue();
	}
	
}
