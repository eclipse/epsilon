package org.eclipse.epsilon.eol.execute.context.concurrent;

import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolThreadPoolExecutor;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributorRegistry;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.execute.concurrent.DelegatePersistentThreadLocal;

/**
 * Skeletal implementation of a parallel IEolContext.
 * 
 * @author Sina Madani
 */
public class EolContextParallel extends EolContext implements IEolContextParallel {

	protected int numThreads;
	protected boolean isParallel = false;
	private EolExecutorService executorService;
	
	// Data strcutures which will be written to and read from during parallel execution:
	protected DelegatePersistentThreadLocal<FrameStack> concurrentFrameStacks;
	protected DelegatePersistentThreadLocal<OperationContributorRegistry> concurrentMethodContributors;
	protected DelegatePersistentThreadLocal<ExecutorFactory> concurrentExecutors;
	
	public EolContextParallel() {
		this(0);
	}

	/**
	 * @param parallelism The number of threads to use.
	 */
	public EolContextParallel(int parallelism) {
		setNumThreads(parallelism);
		initMainThreadStructures();
		initThreadLocals();
	}

	/**
	 * @see #EolContextParallel(IEolContext, int)
	 */
	public EolContextParallel(IEolContext context) {
		this(context, 0);
	}
	
	/**
	 * Copy constructor.
	 * NOTE: The context parameter may be modified.
	 * 
	 * @param context The context to copy from. Structures
	 * in this parameter may be modified to be thread-safe.
	 * @param parallelism The number of threads to use.
	 */
	public EolContextParallel(IEolContext context, int parallelism) {
		setNumThreads(parallelism);
		frameStack = context.getFrameStack().clone();
		frameStack.setThreadSafe(true);
		methodContributorRegistry = context.getOperationContributorRegistry();
		methodContributorRegistry.setThreadSafe(true);
		executorFactory = context.getExecutorFactory();
		executorFactory.setThreadSafe(true);
		initThreadLocals();
	}
	
	protected int setNumThreads(int parallelism) {
		return (numThreads = parallelism > 0 ? parallelism : ConcurrencyUtils.DEFAULT_PARALLELISM);
	}
	
	protected void initMainThreadStructures() {
		// This will be the "base" of others, so make it thread-safe for concurrent reads
		frameStack = new FrameStack(null, true);
		methodContributorRegistry = new OperationContributorRegistry(null, true);
		executorFactory = new ExecutorFactory(null, true);
	}
	
	protected void initThreadLocals() {
		concurrentFrameStacks = new DelegatePersistentThreadLocal<>(numThreads, () -> new FrameStack(frameStack, false));
		concurrentMethodContributors = new DelegatePersistentThreadLocal<>(numThreads, () -> new OperationContributorRegistry(methodContributorRegistry, false));
		concurrentExecutors = new DelegatePersistentThreadLocal<>(numThreads, () -> new ExecutorFactory(executorFactory, false));
	}
	
	@Override
	public void goParallel() {
		isParallel = true;
	}
	
	@Override
	public void endParallel() {
		isParallel = false;
		concurrentFrameStacks.removeAll();
		concurrentMethodContributors.removeAll();
		concurrentExecutors.removeAll();
	}
	
	@Override
	public final boolean isParallel() {
		return isParallel;
	}
	
	@Override
	public final int getParallelism() {
		return numThreads;
	}
	
	@Override
	public EolExecutorService getExecutorService() {
		return executorService;
	}
	
	@Override
	public void setExecutorService(EolExecutorService exector) {
		this.executorService = exector;
	}
	
	@Override
	public EolExecutorService newExecutorService() {
		return EolThreadPoolExecutor.fixedPoolExecutor(numThreads);
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
	public ExecutorFactory getExecutorFactory() {
		return parallelGet(concurrentExecutors, super::getExecutorFactory);
	}

	@Override
	public void setExecutorFactory(ExecutorFactory executorFactory) {
		parallelSet(executorFactory, concurrentExecutors, super::setExecutorFactory);
	}
	
	@Override
	public OperationContributorRegistry getOperationContributorRegistry() {
		return parallelGet(concurrentMethodContributors, super::getOperationContributorRegistry);
	}
	
	@Override
	public IEolModule getModule() {
		return (IEolModule) super.getModule();
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+" [parallelism="+getParallelism()+']';
	}
}
