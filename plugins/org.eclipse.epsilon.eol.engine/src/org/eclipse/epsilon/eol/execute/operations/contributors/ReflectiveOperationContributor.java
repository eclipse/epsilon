package org.eclipse.epsilon.eol.execute.operations.contributors;


public class ReflectiveOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target != null;
	}
	
	@Override
	protected Object getReflectionTarget(Object target) {
		return target;
	}
	
	@Override
	protected boolean includeInheritedMethods() {
		return true;
	}
}
