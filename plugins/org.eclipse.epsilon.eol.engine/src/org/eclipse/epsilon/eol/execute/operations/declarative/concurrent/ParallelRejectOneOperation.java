package org.eclipse.epsilon.eol.execute.operations.declarative.concurrent;

import org.eclipse.epsilon.eol.execute.operations.declarative.RejectOneOperation;

public class ParallelRejectOneOperation extends RejectOneOperation {

	public ParallelRejectOneOperation() {
		setSelectOperation(new ParallelSelectOperation());
	}

}
