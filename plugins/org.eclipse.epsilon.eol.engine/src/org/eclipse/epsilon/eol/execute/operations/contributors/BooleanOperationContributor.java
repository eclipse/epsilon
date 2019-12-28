/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations.contributors;

import java.util.function.Supplier;

public class BooleanOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target instanceof Boolean;
	}
	
	public boolean or(boolean operand) {
		return operand || (Boolean) getTarget();
	}
	
	public boolean and(boolean operand) {
		return operand && (Boolean) getTarget();
	}
	
	public boolean not() {
		return !((Boolean) getTarget());
	}
	
	public boolean xor(boolean operand) {
		return (Boolean) getTarget() != operand;		
	}
	
	public String asString() {
		return getTarget() + "";
	}
	
	public Object ternary(Supplier<?> sIfTrue, Supplier<?> sIfFalse) {
		boolean value = (Boolean) getTarget();
		return value ? sIfTrue.get() : sIfFalse.get();
	}
}
