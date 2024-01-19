package org.eclipse.epsilon.eol.staticanalyser;

import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.types.EolType;

public class EolPseudotype extends EolType {
	
	@Override
	public String getName() {
		return getClass().getSimpleName();
	}

	@Override
	public boolean isType(Object o) {
		return false;
	}

	@Override
	public boolean isKind(Object o) {
		return false;
	}

	@Override
	public EolType getParentType() {
		return null;
	}

	@Override
	public Object createInstance() throws EolRuntimeException {
		return null;
	}

	@Override
	public Object createInstance(List<Object> parameters) throws EolRuntimeException {
		return null;
	}
}
