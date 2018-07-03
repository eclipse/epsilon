package org.eclipse.epsilon.eol.concurrent;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.concurrent.EolContextParallel;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;

public class EolModuleParallel extends EolModule {

	public EolModuleParallel() {
		this(0);
	}
	
	public EolModuleParallel(int numThreads) {
		this.context = new EolContextParallel(numThreads);
	}
	
	@Override
	protected void prepareContext() {
		super.prepareContext();
		getContext().goParallel();
	}
	
	@Override
	public void setContext(IEolContext context) {
		if (context instanceof IEolContextParallel) {
			super.setContext(context);
		}
	}
	
	@Override
	public IEolContextParallel getContext() {
		return (IEolContextParallel) context;
	}
}
