package org.eclipse.epsilon.eol.execute;

public class Return {
	
	protected Object value;
	
	public Return(Object value) {
		this.value = value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
	
	public Object getValue() {
		return value;
	}
	
	public static Object getValue(Object result) {
		if (result instanceof Return) {
			return ((Return) result).getValue();
		}
		else {
			return result;
		}
	}
	
}
