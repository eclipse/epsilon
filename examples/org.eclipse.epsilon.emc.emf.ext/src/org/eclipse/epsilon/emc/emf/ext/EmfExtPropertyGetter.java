package org.eclipse.epsilon.emc.emf.ext;

import org.eclipse.epsilon.emc.emf.EmfPropertyGetter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class EmfExtPropertyGetter extends EmfPropertyGetter {
	
	@Override
	public boolean hasProperty(Object object, String property) {
		return super.hasProperty(object, property) || property.endsWith("_");
	}
	
	@Override
	public Object invoke(Object object, String property) throws EolRuntimeException {
		if (property.endsWith("_")) {
			return "hello world";
		}
		else {
			return super.invoke(object, property);
		}
	}
	
}
