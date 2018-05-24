package org.eclipse.epsilon.emc.simulink.operations.contributors;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.introspection.java.SimulinkObjectMethod;
import org.eclipse.epsilon.emc.simulink.introspection.java.StateflowObjectMethod;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkBlock;
import org.eclipse.epsilon.emc.simulink.model.element.StateflowBlock;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.java.ObjectMethod;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;

public class ModelOperationContributor extends OperationContributor {

	protected MatlabEngine engine = null;

	public ModelOperationContributor(MatlabEngine engine) {
		this.engine = engine;
	}

	@Override
	public boolean contributesTo(Object target) {
		return (target instanceof SimulinkBlock) 
				|| (target instanceof StateflowBlock)
				|| (target instanceof SimulinkModel);
	}

	@Override
	public ObjectMethod findContributedMethodForEvaluatedParameters(Object target, String name, Object[] parameters,
			IEolContext context, boolean overrideContextOperationContributorRegistry) {
		ObjectMethod objectMethod = null;
		if (overrideContextOperationContributorRegistry == false 
				&& context.getOperationFactory().getOperationFor(name) == null) {
			if (target instanceof StateflowBlock) {
				objectMethod = (ObjectMethod) new StateflowObjectMethod(engine, target, name);
			} else if (target instanceof SimulinkBlock || target instanceof SimulinkModel) {
				objectMethod = (ObjectMethod) new SimulinkObjectMethod(engine, target, name);
			}
		}
		if (objectMethod == null) { 
			objectMethod = super.findContributedMethodForEvaluatedParameters(target, name, parameters, context, overrideContextOperationContributorRegistry);
		}
		return objectMethod;
	}
	
	

}