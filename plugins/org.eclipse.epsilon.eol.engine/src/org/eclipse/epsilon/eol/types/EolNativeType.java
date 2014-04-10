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

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.EolTypeNotFoundException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;


public class EolNativeType extends EolAnyType {
	
	protected IEolContext context;
	protected String clazz;
	protected IToolNativeTypeDelegate delegate;
	
	public EolNativeType(AST classAst, IEolContext context) throws EolTypeNotFoundException {
		for (IToolNativeTypeDelegate delegate : context.getNativeTypeDelegates()) {
			if (delegate.knowsAbout(classAst.getText())) {
				this.clazz = classAst.getText();
				this.delegate = delegate;
				this.context = context;
				return;
			}
		}
		throw new EolTypeNotFoundException(classAst.getText(), classAst);
	}

	@Override
	public Object createInstance() throws EolRuntimeException {
		return delegate.createInstance(clazz, Collections.emptyList(), context);
	}
	
	@Override
	public Object createInstance(List<Object> parameters)
			throws EolRuntimeException {
		return delegate.createInstance(clazz, parameters, context);
	}
	
	public Class<?> getJavaClass() {
		try {
			return ClassLoader.getSystemClassLoader().loadClass(clazz);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}
	
	@Override
	public String getName() {
		return "Native (" + clazz + ")";
	}

	@Override
	public boolean isKind(Object o) {
		if (o != null) {
			Class<?> cls = o.getClass();
			boolean found = false;
			while (cls!= null && !found) {
				if (cls.getCanonicalName().equalsIgnoreCase(clazz)){
					return true;
				}
				else {
					cls = cls.getSuperclass();
				}
			}
		}
		return false;
	}

	@Override
	public boolean isType(Object o) {
		if (o != null) {
			return o.getClass().getCanonicalName().equalsIgnoreCase(clazz);
		}
		return false;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof EolNativeType) {
			return ((EolNativeType) o).clazz.equalsIgnoreCase(this.clazz);
		}
		return false;
	}
	
}
