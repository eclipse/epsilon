package org.eclipse.epsilon.eol.execute.operations.declarative;

public abstract class SelectBasedOperation extends FirstOrderOperation {

	private SelectOperation delegate = new SelectOperation();
	
	public void setSelectOperation(SelectOperation delegateOp) {
		this.delegate = delegateOp;
	}

	public SelectOperation getSelectOperation() {
		return delegate;
	}
	
}
