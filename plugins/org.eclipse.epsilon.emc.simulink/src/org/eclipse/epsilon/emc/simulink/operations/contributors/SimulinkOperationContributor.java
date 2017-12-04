package org.eclipse.epsilon.emc.simulink.operations.contributors;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.introspection.java.SimulinkObjectMethod;
import org.eclipse.epsilon.emc.simulink.introspection.java.StateflowObjectMethod;
import org.eclipse.epsilon.emc.simulink.models.SimulinkModelElement;
import org.eclipse.epsilon.emc.simulink.models.StateflowBlock;
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
		return target instanceof SimulinkModelElement;
	}
	
	@Override
	public ObjectMethod findContributedMethodForEvaluatedParameters(Object target, String name, Object[] parameters,
			IEolContext context, boolean overrideContextOperationContributorRegistry) {
		if (overrideContextOperationContributorRegistry == false) {
			if (target instanceof StateflowBlock) {
				return new StateflowObjectMethod(engine, target, name);
			} else {
				return new SimulinkObjectMethod(engine, target, name);
			}		
		} else {
			return null;
		}
	}
	
}