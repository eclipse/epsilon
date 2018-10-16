/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.erl.execute.context;

import org.eclipse.epsilon.eol.execute.ExecutorFactory;
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
	public void setExecutorFactory(ExecutorFactory executorFactory) {
		if (executorFactory instanceof RuleExecutorFactory) {
			this.executorFactory = executorFactory;
		}
		else {
			this.executorFactory = new RuleExecutorFactory(executorFactory);
		}
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
