package org.eclipse.epsilon.emc.filesystem;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;

import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertyGetter;

public class FilesystemModelPropertyGetter extends JavaPropertyGetter {
	
	@Override
	public Object invoke(Object object, String property)
			throws EolRuntimeException {
		
		try {
			if ("contents".equals(property)) {
				return new Scanner((File) object).useDelimiter("\\Z").next();
			}
			else if (property.startsWith("p_")) {
				Properties p = new Properties();
				p.load(new FileInputStream(((File) object)));
				return p.get(property.substring(2));
			}
			else return super.invoke(object, property);
		}
		catch (Exception e) {
			throw new EolInternalException(e);
		}
		
	}
	
}
