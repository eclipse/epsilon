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

public class BooleanOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return getTarget() instanceof Boolean;
	}
	
	public boolean or(boolean operand) {
		boolean value = (Boolean) getTarget();
		return value || operand;
	}
	
	public boolean and(boolean operand) {
		boolean value = (Boolean) getTarget();
		return value && operand;
	}
	
	public boolean not() {
		return !((Boolean) getTarget());
	}
	
	public boolean xor(boolean operand) {
		boolean value = (Boolean) getTarget();
		return value != operand;		
	}
	
	public String asString() {
		return getTarget() + "";
	}
	
	/*public Object ternary(Supplier<?> sIfTrue, Supplier<?> sIfFalse) {
		boolean value = (Boolean) getTarget();
		return value ? sIfTrue.get() : sIfFalse.get();
	}*/
}
