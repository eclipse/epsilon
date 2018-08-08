package org.eclipse.epsilon.erl.execute.context;

import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.erl.IErlModule;
import org.eclipse.epsilon.erl.execute.RuleExecutorFactory;

public interface IErlContext extends IEolContext {

	@Override
	RuleExecutorFactory getExecutorFactory();
	
	@Override
	IErlModule getModule();
	
}
