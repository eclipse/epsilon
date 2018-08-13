package org.eclipse.epsilon.eol.execute.operations.declarative.concurrent;

import org.eclipse.epsilon.eol.execute.operations.declarative.SelectOneOperation;

public class ParallelSelectOneOperation extends SelectOneOperation {
	
	public ParallelSelectOneOperation() {
		setSelectOperation(new ParallelSelectOperation());
	}
	
}
