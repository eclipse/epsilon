package org.eclipse.epsilon.eol.execute.operations.declarative.concurrent;

import org.eclipse.epsilon.eol.execute.operations.declarative.SortByOperation;

public class ParallelSortByOperation extends SortByOperation {
	
	public ParallelSortByOperation() {
		setCollectOperation(new ParallelCollectOperation());
	}
}
