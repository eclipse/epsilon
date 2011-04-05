package org.eclipse.epsilon.eol.dt.debug;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

public class EolVariableValue extends EolDebugElement implements IValue {

	protected Object value = null;
	
	public EolVariableValue(IDebugTarget target, Object value) {
		super(target);
		this.value = value;
	}


	public String getReferenceTypeName() throws DebugException {
		return value.getClass().getCanonicalName();
	}


	public String getValueString() throws DebugException {
		return value + "";
	}


	public boolean isAllocated() throws DebugException {
		return true;
	}


	public IVariable[] getVariables() throws DebugException {
		return null;
	}


	public boolean hasVariables() throws DebugException {
		return false;
	}

}
