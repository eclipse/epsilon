/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations.contributors;

public class BooleanOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target instanceof Boolean;
	}
	
	public boolean or(boolean operand) {
		boolean value = (Boolean) target;
		return value || operand;
	}
	
	public boolean and(boolean operand) {
		boolean value = (Boolean) target;
		return value && operand;
	}
	
	public boolean not() {
		return !((Boolean) target);
	}
	
	public boolean xor(boolean operand) {
		boolean value = (Boolean) target;
		return value != operand;		
	}
	
	public String asString() {
		return target + "";
	}
	
	public Object ternary(Object rIfTrue, Object rIfFalse) {
		boolean value = (Boolean) target;
		return value ? rIfTrue : rIfFalse;
	}
}
