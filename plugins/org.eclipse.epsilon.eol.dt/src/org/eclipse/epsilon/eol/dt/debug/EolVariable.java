/*******************************************************************************
 * Copyright (c) 2012 The University of York, Antonio García-Domínguez.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - added isLoop
 ******************************************************************************/
package org.eclipse.epsilon.eol.dt.debug;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

public class EolVariable extends EolDebugElement implements IVariable {

	protected String name;
	protected IValue value;
	private boolean isLoop = false;

	public EolVariable(IDebugTarget target, String name, Object value) {
		super(target);
		this.name = name;
		this.value = new EolVariableValue(target, this, value);
	}

	public void setValue(String expression) throws DebugException {
		// do nothing
	}

	public void setValue(IValue value) throws DebugException {
		// do nothing
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

	public boolean isLoop() {
		return isLoop;
	}

	public void setLoop(boolean isLoop) {
		this.isLoop = isLoop;
	}

	@Override
	public String toString() {
		return "EolVariable [name=" + name + ", value=" + value + ", isLoop=" + isLoop + "]";
	}
}
