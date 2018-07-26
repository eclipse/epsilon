package org.eclipse.epsilon.eol.execute.operations.declarative.concurrent;

import org.eclipse.epsilon.eol.execute.operations.declarative.RejectOperation;

public class ParallelRejectOperation extends RejectOperation {

	public ParallelRejectOperation() {
		setSelectOperation(new ParallelSelectOperation());
	}

}
