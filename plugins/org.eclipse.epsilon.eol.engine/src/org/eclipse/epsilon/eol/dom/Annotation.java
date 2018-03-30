package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public abstract class Annotation extends AbstractModuleElement implements ICompilableModuleElement {
	
	protected String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name != null ? name : super.toString();
	}

	public abstract boolean hasValue();
	
	public abstract Object getValue(IEolContext context) throws EolRuntimeException;
	
}
