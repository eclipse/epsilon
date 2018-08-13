package org.eclipse.epsilon.eol.execute.operations.declarative.concurrent;

import org.eclipse.epsilon.eol.execute.operations.declarative.ExistsOperation;

public class ParallelExistsOperation extends ExistsOperation {

	public ParallelExistsOperation() {
		setSelectOperation(new ParallelSelectOperation());
	}

}
