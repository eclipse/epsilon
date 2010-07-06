package org.eclipse.epsilon.eol.execute.operations.contributors;


public class BooleanOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target instanceof Boolean;
	}
	
	public boolean or(boolean operand){
		boolean value = (Boolean) target;
		return value || operand;
	}
	
	public boolean and(boolean operand){
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
}
