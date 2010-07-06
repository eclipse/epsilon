/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.types;

import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationParametersException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class EolPrimitiveType extends EolType{

	private Class clazz;
	private String name;
	
	public static EolPrimitiveType Integer = new EolPrimitiveType(Integer.class,"Integer");
	public static EolPrimitiveType Long = new EolPrimitiveType(Long.class,"Long");
	public static EolPrimitiveType String = new EolPrimitiveType(String.class,"String");
	public static EolPrimitiveType Boolean = new EolPrimitiveType(Boolean.class,"Boolean");
	public static EolPrimitiveType Real = new EolPrimitiveType(Float.class,"Real");
	public static EolPrimitiveType Double = new EolPrimitiveType(Double.class,"Double");
	public static EolPrimitiveType Map = new EolPrimitiveType(EolMap.class,"Map");
	
	private EolPrimitiveType(Class clazz, String name){
		this.clazz = clazz;
		this.name = name;
	}

	@Override
	public Object createInstance(List<Object> parameters)
			throws EolRuntimeException {
		throw new EolIllegalOperationParametersException("createInstance");
	}
	
	@Override
	public boolean isType(Object o) {
		if (o == null) return true;
		return o.getClass() == clazz;
	}

	public Class getClazz() {
		return clazz;
	}

	@Override
	public boolean isKind(Object o) {
		return clazz.isInstance(o);
	}

	@Override
	public Object createInstance() {
		try {
			return clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getName() {
		return name;
	}
	
}
