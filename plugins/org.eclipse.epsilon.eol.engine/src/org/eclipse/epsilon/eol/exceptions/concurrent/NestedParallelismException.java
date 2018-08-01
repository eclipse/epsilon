package org.eclipse.epsilon.eol.exceptions.concurrent;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class NestedParallelismException extends EolRuntimeException {

	public NestedParallelismException() {
		this(null);
	}

	public NestedParallelismException(ModuleElement ast) {
		this.ast = ast;
		this.reason = "Illegal nesting of parallel operations!";
	}
}
