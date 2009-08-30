package org.eclipse.epsilon.egl.execute;

import org.eclipse.epsilon.egl.execute.operations.IncludeOperation;
import org.eclipse.epsilon.eol.execute.operations.OperationFactory;

public class EglOperationFactory extends OperationFactory {
	
	@Override
	protected void createCache() {
		super.createCache();
		operationCache.put("include", new IncludeOperation());
	}
	
}
