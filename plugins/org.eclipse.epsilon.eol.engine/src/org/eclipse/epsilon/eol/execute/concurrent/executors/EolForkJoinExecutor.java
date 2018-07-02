package org.eclipse.epsilon.eol.execute.concurrent.executors;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;
import org.eclipse.epsilon.eol.execute.concurrent.EolThreadFactory;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutionStatus;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;

public class EolForkJoinExecutor extends ForkJoinPool implements EolExecutorService {

	static class EolForkJoinThreadFactory extends EolThreadFactory implements ForkJoinWorkerThreadFactory {
		
		public EolForkJoinThreadFactory() {
			super(new EolExecutionStatus());
		}

		EolExecutionStatus getExecStatus() {
			return this.executionStatus;
		}
		
		@Override
		public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
			return setThreadProperties(new ForkJoinWorkerThread(pool){});
		}
	}
	
	public EolForkJoinExecutor() {
		this(Runtime.getRuntime().availableProcessors());
	}
	
	public EolForkJoinExecutor(int parallelism) {
		super(parallelism, new EolForkJoinThreadFactory(), null, false);
	}

	@Override
	public EolExecutionStatus getExecutionStatus() {
		return ((EolForkJoinThreadFactory) getFactory()).getExecStatus();
	}	
}
