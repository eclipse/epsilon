package org.eclipse.epsilon.evl.execute.context.concurrent;

import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;
import org.eclipse.epsilon.evl.concurrent.EvlModuleParallel;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

public interface IEvlContextParallel extends IEvlContext, IEolContextParallel {

	@Override
	default EvlModuleParallel getModule() {
		return (EvlModuleParallel) IEvlContext.super.getModule();
	}
	
}
