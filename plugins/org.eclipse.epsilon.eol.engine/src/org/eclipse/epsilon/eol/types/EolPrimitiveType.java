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

public class EolPrimitiveType extends EolType{

	private Class clazz;
	private String name;
	
	public static EolPrimitiveType Integer = new EolPrimitiveType(EolInteger.class,"Integer");
	public static EolPrimitiveType String = new EolPrimitiveType(EolString.class,"String");
	public static EolPrimitiveType Boolean = new EolPrimitiveType(EolBoolean.class,"Boolean");
	public static EolPrimitiveType Real = new EolPrimitiveType(EolReal.class,"Real");
	public static EolPrimitiveType Map = new EolPrimitiveType(EolMap.class,"Map");
	
	private EolPrimitiveType(Class clazz, String name){
		this.clazz = clazz;
		this.name = name;
	}

	@Override
	public boolean isType(Object o) {
		if (o == null) return true;
		return EolTypeWrapper.getInstance().wrap(o).getClass() == clazz;
		//return o.getClass() == clazz;
	}

	public Class getClazz() {
		return clazz;
	}

	@Override
	public boolean isKind(Object o) {
		return clazz.isInstance(EolTypeWrapper.getInstance().wrap(o));
//		return clazz.isInstance(o);
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
