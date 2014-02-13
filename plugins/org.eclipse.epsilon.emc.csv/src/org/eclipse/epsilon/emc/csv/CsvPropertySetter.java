package org.eclipse.epsilon.emc.csv;

import java.util.Map;

import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertySetter;
import org.eclipse.epsilon.eol.execute.introspection.IReflectivePropertySetter;

public class CsvPropertySetter extends AbstractPropertySetter implements
		IReflectivePropertySetter {

	@Override
	public void invoke(Object value) throws EolRuntimeException {
		
		String key = getKey();
		((Map<String, String>) object).put(key, (String) value);
	}

	@Override
	public boolean conforms(Object value) throws EolIllegalPropertyException {
		// In theory all objects that can be serialised to strings can be
		// stored. This may cause issues is the string contains CSV
		// delimiters or in the other hand it may be desired.
		return true;
	}

	@Override
	public Object coerce(Object value) throws EolIllegalPropertyException {
		// TODO Auto-generated method stub
		return value;
	}
	
	private String getKey() throws EolIllegalPropertyException {
		Map<String, String> row = (Map<String, String>) object;
		if (!row.keySet().contains(property)) {
			throw new EolIllegalPropertyException(object, property, ast, context);
		} else {
			return property;
		}
	}
	
	protected Map<String, String> getMap() throws EolIllegalPropertyException {
		if (object instanceof Map<?, ?>)
			return (Map<String, String>) object;
		else
			throw new EolIllegalPropertyException(object, property, ast, context);
	}
	

}
