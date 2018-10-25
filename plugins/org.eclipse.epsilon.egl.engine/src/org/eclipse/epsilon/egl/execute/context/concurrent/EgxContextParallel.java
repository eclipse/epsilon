/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.egl.execute.context.concurrent;

import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.execute.context.EglExecutionManager;
import org.eclipse.epsilon.egl.execute.context.EglFrameStackManager;
import org.eclipse.epsilon.egl.execute.context.EgxContext;
import org.eclipse.epsilon.eol.exceptions.concurrent.EolNestedParallelismException;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributorRegistry;
import org.eclipse.epsilon.erl.execute.RuleExecutorFactory;
import org.eclipse.epsilon.eol.execute.concurrent.DelegatePersistentThreadLocal;
import org.eclipse.epsilon.eol.execute.concurrent.PersistentThreadLocal;

public class EgxContextParallel extends EgxContext implements IEgxContextParallel {

	protected final int numThreads;
	protected int nestLevel;
	protected boolean isParallel = false;
	protected EolExecutorService executorService;
	protected PersistentThreadLocal<FrameStack> concurrentFrameStacks;
	protected PersistentThreadLocal<ExecutorFactory> concurrentExecutors;
	protected ThreadLocal<OperationContributorRegistry> concurrentMethodContributors;
	protected ThreadLocal<EglExecutionManager> concurrentExecutionManagers;
	
	public EgxContextParallel() {
		this(null, 0);
	}
	
	public EgxContextParallel(EglTemplateFactory templateFactory) {
		this(templateFactory, 0);
	}

	public EgxContextParallel(EglTemplateFactory templateFactory, int parallelism) {
		super(templateFactory);
		numThreads = parallelism > 0 ? parallelism : ConcurrencyUtils.DEFAULT_PARALLELISM;
	}
	
	protected void initMainThreadStructures() {
		frameStack = new FrameStack(null, true);
		executorFactory = new ExecutorFactory(null, true);
		setExecutionManager(new EglExecutionManager(new EglFrameStackManager(getFrameStack())));
	}
	
	protected void initThreadLocals() {
		concurrentMethodContributors = ThreadLocal.withInitial(OperationContributorRegistry::new);
		concurrentFrameStacks = new DelegatePersistentThreadLocal<>(() -> new FrameStack(frameStack, false));
		concurrentExecutors = new DelegatePersistentThreadLocal<>(() -> new RuleExecutorFactory(executorFactory, false));
		concurrentExecutionManagers = ThreadLocal.withInitial((() -> new EglExecutionManager(new EglFrameStackManager(getFrameStack()))));
	}
	
	protected void setBaseThreadSafety(boolean concurrent) {
		frameStack.setThreadSafe(concurrent);
		executorFactory.setThreadSafe(concurrent);
	}
	
	@Override
	protected void finalize() {
		if (executorService != null) {
			executorService.shutdownNow();
			executorService = null;
		}
	}
	
	@Override
	public void goParallel() {
		if (!isParallel) {
			initThreadLocals();
			isParallel = true;
		}
	}
	
	@Override
	public void endParallel() {
		isParallel = false;
		
		finalize();
		
		concurrentFrameStacks.removeAll();
		concurrentFrameStacks = null;
		concurrentMethodContributors = null;
		concurrentExecutors.removeAll();
		concurrentExecutors = null;
	}
	
	@Override
	public boolean isParallel() {
		return isParallel;
	}
	
	@Override
	public int getParallelism() {
		return numThreads;
	}
	
	@Override
	public void enterParallelNest(ModuleElement entryPoint) throws EolNestedParallelismException {
		if (++nestLevel > PARALLEL_NEST_THRESHOLD) {
			throw new EolNestedParallelismException(entryPoint);
		}
	}

	@Override
	public void exitParallelNest(ModuleElement entryPoint) {
		if (nestLevel > 0)
			nestLevel--;
	}

	@Override
	public int getNestedParallelism() {
		return nestLevel;
	}
	
	@Override
	public EolExecutorService getExecutorService() {
		if (executorService == null) {
			executorService = newExecutorService();
		}
		return executorService;
	}
	
	@Override
	public FrameStack getFrameStack() {
		return parallelGet(concurrentFrameStacks, super::getFrameStack);
	}
	
	@Override
	public void setFrameStack(FrameStack frameStack) {
		parallelSet(frameStack, concurrentFrameStacks, super::setFrameStack);
	}
	
	@Override
	public OperationContributorRegistry getOperationContributorRegistry() {
		return parallelGet(concurrentMethodContributors, super::getOperationContributorRegistry);
	}
	
	@Override
	public RuleExecutorFactory getExecutorFactory() {
		return (RuleExecutorFactory) parallelGet(concurrentExecutors, super::getExecutorFactory);
	}

	@Override
	public void setExecutorFactory(ExecutorFactory executorFactory) {
		if (executorFactory instanceof RuleExecutorFactory) {
			parallelSet((RuleExecutorFactory) executorFactory, concurrentExecutors, super::setExecutorFactory);
		}
	}
	
	@Override
	public String toString() {
		return super.toString()+" [parallelism="+getParallelism()+"]";
	}
	
}
