package org.eclipse.epsilon.eol.execute.operations.declarative;

import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;

public interface IAbstractOperationContributor {
	
	public AbstractOperation getAbstractOperation(String name);
	
}
