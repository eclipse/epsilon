package org.eclipse.epsilon.eol.exceptions.concurrent;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class EolNestedParallelismException extends EolRuntimeException {

	public EolNestedParallelismException() {
		this(null);
	}

	public EolNestedParallelismException(ModuleElement ast) {
		this.ast = ast;
		this.reason = "Illegal nesting of parallel operations!";
	}
}
