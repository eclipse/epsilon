package org.eclipse.epsilon.epl;

import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertySetter;

public class PatternMatchPropertySetter extends AbstractPropertySetter {

	@Override
	public void invoke(Object value) throws EolRuntimeException {
		//PatternMatch match = (PatternMatch) object;
		//Variable component = match.getComponent(property);
		//if (component != null) {
		//	component.setValueBruteForce(value);
		//}
		//else 
		throw new EolIllegalPropertyException(object, property, ast, context);
	}

}
