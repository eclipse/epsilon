package org.eclipse.epsilon.eol.execute.operations.contributors;


public class WrapperOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target instanceof IWrapper;
	}
	
	@Override
	public Object getReflectionTarget(Object target) {
		return ((IWrapper) target).getWrapped();
	}
	
	@Override
	protected boolean includeInheritedMethods() {
		return true;
	}
	
}