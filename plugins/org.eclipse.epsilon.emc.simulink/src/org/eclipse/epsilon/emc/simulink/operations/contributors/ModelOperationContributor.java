package org.eclipse.epsilon.emc.simulink.operations.contributors;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.introspection.java.SimulinkObjectMethod;
import org.eclipse.epsilon.emc.simulink.introspection.java.StateflowObjectMethod;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkBlock;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkDualBlock;
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
				|| (target instanceof SimulinkDualBlock)
				|| (target instanceof StateflowBlock)
				|| (target instanceof SimulinkModel);
	}

	@Override
	public ObjectMethod findContributedMethodForEvaluatedParameters(Object target, String name, Object[] parameters,
			IEolContext context, boolean overrideContextOperationContributorRegistry) {
		if (!overrideContextOperationContributorRegistry) {
			if (target instanceof StateflowBlock) {
				return new StateflowObjectMethod(engine, target, name);
			} else if (target instanceof SimulinkDualBlock || target instanceof SimulinkBlock || target instanceof SimulinkModel) {
				return new SimulinkObjectMethod(engine, target, name);
			} 
		}
		return null;
	}

}