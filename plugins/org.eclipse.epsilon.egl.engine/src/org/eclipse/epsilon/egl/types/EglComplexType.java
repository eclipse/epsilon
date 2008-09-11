/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.types;

import org.eclipse.epsilon.eol.types.EolType;

public class EglComplexType extends EolType{

	private Class<?> clazz;
	private String name;
	
	public static EglComplexType Template = new EglComplexType(EglFileGeneratingTemplate.class, "Template");
	
	private EglComplexType(Class<?> clazz, String name){
		this.clazz = clazz;
		this.name = name;
	}
	
	@Override
	public boolean isType(Object o) {
		if (o == null) return true;
		return o.getClass() == clazz;
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
