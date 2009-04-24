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


class StringToFloatCoercionStrategy extends AbstractCoercionStrategy<String> {

	
	public StringToFloatCoercionStrategy(ValueCoercer coercer) {
		super(coercer, String.class);
	}

	protected boolean isApplicable() {
		return valueIsFloat();
	}
	
	protected Object doCoerce() {
		return Float.parseFloat(value);
	}
	
	
	private boolean valueIsFloat() {
		//                    -? \d* (. \d*)?
		return value.matches("-?\\d*\\.\\d*");
	}
}
