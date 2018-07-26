package org.eclipse.epsilon.eol.execute.operations.declarative;

public abstract class CollectBasedOperation extends FirstOrderOperation {

	private CollectOperation delegate = new CollectOperation();
	
	public void setCollectOperation(CollectOperation delegateOp) {
		this.delegate = delegateOp;
	}

	public CollectOperation getCollectOperation() {
		return delegate;
	}
	
}
