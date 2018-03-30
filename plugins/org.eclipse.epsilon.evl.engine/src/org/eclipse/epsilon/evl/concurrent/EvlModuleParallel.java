package org.eclipse.epsilon.evl.concurrent;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.execute.context.concurrent.EvlContextParallel;
import org.eclipse.epsilon.evl.execute.context.concurrent.IEvlContextParallel;

public abstract class EvlModuleParallel extends EvlModule {

	public static final EvlModuleParallel getDefaultImpl() {
		return new EvlModuleParallelElements();
	}
	
	@Override
	protected abstract void checkConstraints() throws EolRuntimeException;
	
	public EvlModuleParallel() {
		this.context = new EvlContextParallel();
	}
	
	public EvlModuleParallel(int parallelism) {
		this.context = new EvlContextParallel(parallelism);
	}
	
	@Override
	protected void prepareExecution() throws EolRuntimeException {
		super.prepareExecution();
		getContext().goParallel();
	}
	
	@Override
	protected void postExecution() throws EolRuntimeException {
		getContext().endParallel();
		super.postExecution();
	}
	
	@Override
	public IEvlContextParallel getContext() {
		return (IEvlContextParallel) context;
	}
	
	@Override
	public void setContext(IEolContext context) {
		if (context instanceof IEvlContextParallel) {
			super.setContext(context);
		}
	}
}
