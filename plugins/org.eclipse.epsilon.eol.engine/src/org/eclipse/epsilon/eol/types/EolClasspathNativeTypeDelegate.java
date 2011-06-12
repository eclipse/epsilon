/*******************************************************************************
 * Copyright (c) 2008-2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
			Class c = fClassLoader.loadClass(clazz);
			if (parameters.size() > 0) {
				Constructor con = c.getConstructor(getTypes(parameters));
				return con.newInstance(parameters.toArray());
			}
			else {
				return c.newInstance();
			}
		} 
		catch (NoSuchMethodException mex) {
			throw new EolRuntimeException("Native type " + clazz + " does not define a suitable constructor for arguments " + parameters);
		}
		catch (Exception e) {
			throw new EolInternalException(e);
		}
	}

	public Class[] getTypes(Collection objects) {
		Class[] types = new Class[objects.size()];
		int i = 0;
		for (Object o : objects) {
			types[i] = o.getClass();
			i++;
		}
		return types;
	}
	
}
