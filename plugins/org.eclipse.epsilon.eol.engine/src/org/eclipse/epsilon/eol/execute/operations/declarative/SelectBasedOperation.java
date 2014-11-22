package org.eclipse.epsilon.eol.execute.operations.declarative;

public abstract class SelectBasedOperation extends FirstOrderOperation {
	
	protected SelectOperation selectOperation = new SelectOperation();
	
	public SelectOperation getSelectOperation() {
		return selectOperation;
	}
	
	public void setSelectOperation(SelectOperation selectOperation) {
		this.selectOperation = selectOperation;
	}
	
}
