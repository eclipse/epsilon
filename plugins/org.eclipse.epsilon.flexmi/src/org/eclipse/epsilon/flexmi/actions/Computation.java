package org.eclipse.epsilon.flexmi.actions;

import org.eclipse.epsilon.flexmi.FlexmiResource;

public abstract class Computation extends Action {
	protected String expression;
	
	public String getExpression() {
		return expression;
	}
	
	@Override
	public void perform(FlexmiResource resource) throws Exception {
		compute(resource);
	}
	
	public abstract void compute(FlexmiResource resource) throws Exception;
}
