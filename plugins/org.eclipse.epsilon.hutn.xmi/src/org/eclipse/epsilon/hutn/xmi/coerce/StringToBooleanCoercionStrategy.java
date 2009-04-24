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


class StringToBooleanCoercionStrategy extends AbstractCoercionStrategy<String> {

	
	public StringToBooleanCoercionStrategy(ValueCoercer coercer) {
		super(coercer, String.class);
	}

	protected boolean isApplicable() {
		return valueIsBoolean();
	}
	
	protected Object doCoerce() {
		return Boolean.parseBoolean(value);
	}
	

	private boolean valueIsBoolean() {
		return value.matches("true|false");
	}
}
