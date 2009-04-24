/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.hutn.xmi.coerce;

abstract class AbstractCoercionStrategy<T> {

	protected final ValueCoercer coercer;
	private final Class<T> clazz;
	
	protected T value;
	
	public AbstractCoercionStrategy(ValueCoercer coercer, Class<T> clazz) {
		this.coercer = coercer;
		this.clazz   = clazz;
	}
	
	public boolean applicable(Object value) {
		if (!clazz.isInstance(value))
			return false;
		
		setValue(value);
		return isApplicable();
	}
	
	public Object coerce(Object value) {
		setValue(value);
		return doCoerce();
	}
	
	private void setValue(Object value) {
		this.value = clazz.cast(value);
	}

	protected abstract boolean isApplicable();
	protected abstract Object doCoerce();
}
