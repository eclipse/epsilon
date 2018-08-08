package org.eclipse.epsilon.evl.execute.context.concurrent;

import org.eclipse.epsilon.erl.execute.context.concurrent.IErlContextParallel;
import org.eclipse.epsilon.evl.concurrent.EvlModuleParallel;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

public interface IEvlContextParallel extends IEvlContext, IErlContextParallel {

	@Override
	default EvlModuleParallel getModule() {
		return (EvlModuleParallel) IEvlContext.super.getModule();
	}
	
}
