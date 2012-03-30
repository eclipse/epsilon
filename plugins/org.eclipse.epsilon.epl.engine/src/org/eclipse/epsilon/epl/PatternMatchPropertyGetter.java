package org.eclipse.epsilon.epl;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertyGetter;

public class PatternMatchPropertyGetter extends JavaPropertyGetter {
	
	@Override
	public Object invoke(Object object, String property)
			throws EolRuntimeException {
		if (object instanceof PatternMatch) {
			PatternMatch match = (PatternMatch) object;
			return match.getRoleBinding(property);
		}
		
		return super.invoke(object, property);
	}

}
