package org.eclipse.epsilon.eol.execute.operations.declarative;

import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;

public abstract class SelectBasedOperation extends IteratorOperation {
	
	protected SelectOperation selectOperation = new SelectOperation();
	
	public SelectOperation getSelectOperation() {
		return selectOperation;
	}
	
	public void setSelectOperation(SelectOperation selectOperation) {
		this.selectOperation = selectOperation;
	}
	
}
