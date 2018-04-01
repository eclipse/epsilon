package org.eclipse.epsilon.erl.execute.concurrent.executors;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;
import org.eclipse.epsilon.erl.execute.concurrent.ErlThreadFactory;

public class ErlForkJoinExecutor extends ForkJoinPool implements ErlExecutorService {

	static class ErlForkJoinThreadFactory extends ErlThreadFactory implements ForkJoinWorkerThreadFactory {
		public ErlForkJoinThreadFactory() {
			super(new ErlExecutionStatus());
		}

		ErlExecutionStatus getExecStatus() {
			return this.executionStatus;
		}
		
		@Override
		public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
			return (ForkJoinWorkerThread) setThreadProperties(new ForkJoinWorkerThread(pool){});
		}
	}
	
	public ErlForkJoinExecutor(int parallelism) {
		super(parallelism, new ErlForkJoinThreadFactory(), null, false);
	}

	@Override
	public ErlExecutionStatus getExecutionStatus() {
		return ((ErlForkJoinThreadFactory) getFactory()).getExecStatus();
	}	
}
