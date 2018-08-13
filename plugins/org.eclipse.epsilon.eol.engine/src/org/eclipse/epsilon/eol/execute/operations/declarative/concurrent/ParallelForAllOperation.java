package org.eclipse.epsilon.eol.execute.operations.declarative.concurrent;

import org.eclipse.epsilon.eol.execute.operations.declarative.ForAllOperation;

public class ParallelForAllOperation extends ForAllOperation {
	
	public ParallelForAllOperation() {
		delegateConstructor = ParallelNMatchOperation::new;
	}

}
