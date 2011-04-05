package org.eclipse.epsilon.eol.dt.debug;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

public class EolVariable extends EolDebugElement implements IVariable {

	protected String name;
	protected IValue value;

	public EolVariable(IDebugTarget target, String name, Object value) {
		super(target);
		this.name = name;
		this.value = new EolVariableValue(target, value);
	}

	public void setValue(String expression) throws DebugException {

	}

	public void setValue(IValue value) throws DebugException {

	}

	public boolean supportsValueModification() {
		return false;
	}

	public boolean verifyValue(String expression) throws DebugException {
		return false;
	}

	public boolean verifyValue(IValue value) throws DebugException {
		return false;
	}

	public IValue getValue() throws DebugException {
		return value;
	}

	public String getName() throws DebugException {
		return name;
	}

	public String getReferenceTypeName() throws DebugException {
		return getValue().getReferenceTypeName();
	}

	public boolean hasValueChanged() throws DebugException {
		return false;
	}

}
