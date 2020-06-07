package org.eclipse.epsilon.emc.emf.ext;

import org.eclipse.epsilon.emc.emf.EmfPropertyGetter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class EmfExtPropertyGetter extends EmfPropertyGetter {
	
	@Override
	public boolean hasProperty(Object object, String property, IEolContext context) {
		return property.endsWith("_") || super.hasProperty(object, property, context);
	}
	
	@Override
	public Object invoke(Object object, String property, IEolContext context) throws EolRuntimeException {
		if (property.endsWith("_")) {
			return "hello world";
		}
		else {
			return super.invoke(object, property, context);
		}
	}
	
}
