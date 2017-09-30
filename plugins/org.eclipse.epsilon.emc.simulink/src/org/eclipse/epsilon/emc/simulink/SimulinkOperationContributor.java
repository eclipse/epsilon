package org.eclipse.epsilon.emc.simulink;

import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.java.ObjectMethod;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;

public class SimulinkOperationContributor extends OperationContributor {

	protected MatlabEngine engine = null;
	
	public SimulinkOperationContributor(MatlabEngine engine) {
		this.engine = engine;
	}
	
	@Override
	public boolean contributesTo(Object target) {
		return target instanceof SimulinkElement;
	}
	
	@Override
	public ObjectMethod findContributedMethodForEvaluatedParameters(Object target, String name, Object[] parameters,
			IEolContext context, boolean overrideContextOperatorContributorRegistry) {
		
		if (overrideContextOperatorContributorRegistry == false) {
			return new SimulinkObjectMethod(engine, target, name);
		}
		else {
			return null;
		}
	}
	
}
