/*******************************************************************************
 * Copyright (c) 2008-2011 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - allow for selecting a specific class loader
 ******************************************************************************/
package org.eclipse.epsilon.eol.types;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.util.ReflectionUtil;

public class EolClasspathNativeTypeDelegate extends AbstractToolNativeTypeDelegate{

	private ClassLoader fClassLoader;

	public EolClasspathNativeTypeDelegate() {
		this(EolClasspathNativeTypeDelegate.class.getClassLoader());
	}

	public EolClasspathNativeTypeDelegate(ClassLoader classLoader) {
		fClassLoader = classLoader;
	}

	public boolean knowsAbout(String clazz) {
		try {
			fClassLoader.loadClass(clazz);
		} catch (ClassNotFoundException e) {
			return false;
		}
		return true;
	}

	public Object createInstance(String clazz, List<Object> parameters) throws EolRuntimeException {
		try {
			Class<?> c = fClassLoader.loadClass(clazz);
			if (parameters.size() > 0) {
				for (Constructor<?> con : c.getConstructors()) {
					if (con.getParameterTypes().length != parameters.size()) continue;
					boolean parameterTypesMatch = true;
					for (int i=0;i<parameters.size();i++) {
						parameterTypesMatch = parameterTypesMatch && 
							ReflectionUtil.isInstance(con.getParameterTypes()[i], parameters.get(i));
					}
					if (parameterTypesMatch) {
						return con.newInstance(parameters.toArray());
					}
				}
				//Constructor con = c.getConstructor(getTypes(parameters));
				
			}
			else {
				return c.getDeclaredConstructor().newInstance();
			}
		} 
		//catch (NoSuchMethodException mex) {
		//	throw new EolRuntimeException("Native type " + clazz + " does not define a suitable constructor for arguments " + parameters);
		//}
		catch (Exception e) {
			throw new EolInternalException(e);
		}
		
		throw new EolRuntimeException("Native type " + clazz + " does not define a suitable constructor for arguments " + parameters);
	}

	public Class<?>[] getTypes(Collection<Object> objects) {
		Class<?>[] types = new Class[objects.size()];
		int i = 0;
		for (Object o : objects) {
			types[i] = o.getClass();
			i++;
		}
		return types;
	}
}
