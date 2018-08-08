package org.eclipse.epsilon.erl.execute.context;

import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.erl.IErlModule;
import org.eclipse.epsilon.erl.execute.RuleExecutorFactory;

public class ErlContext extends EolContext implements IErlContext {

	public ErlContext() {
		executorFactory = new RuleExecutorFactory();
	}

	public ErlContext(IErlContext other) {
		super(other);
		executorFactory = new RuleExecutorFactory();
	}

	@Override
	public RuleExecutorFactory getExecutorFactory() {
		return (RuleExecutorFactory) executorFactory;
	}

	@Override
	public IErlModule getModule() {
		return (IErlModule) module;
	}

}
