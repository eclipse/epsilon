package org.eclipse.epsilon.emc.csv;

import java.util.Map;

import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;

public class CsvPropertyGetter extends AbstractPropertyGetter implements
		IPropertyGetter {

	@Override
	public Object invoke(Object object, String property)
			throws EolRuntimeException {

		Map<String, String> row = (Map<String, String>) object;
		if (!row.keySet().contains(property)) {
			throw new EolIllegalPropertyException(object, property, ast, context);
		} else {
			return row.get(property);
		}
	}

}
