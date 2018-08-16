/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.execute.concurrent.executors;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;
import org.eclipse.epsilon.common.concurrent.ConcurrentExecutionStatus;
import org.eclipse.epsilon.common.concurrent.SingleConcurrentExecutionStatus;
import org.eclipse.epsilon.eol.execute.concurrent.EolThreadFactory;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;

public class EolForkJoinExecutor extends ForkJoinPool implements EolExecutorService {

	static class EolForkJoinThreadFactory extends EolThreadFactory implements ForkJoinWorkerThreadFactory {
		
		public EolForkJoinThreadFactory() {
			super(new SingleConcurrentExecutionStatus());
		}

		ConcurrentExecutionStatus getExecStatus() {
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
	public ConcurrentExecutionStatus getExecutionStatus() {
		return ((EolForkJoinThreadFactory) getFactory()).getExecStatus();
	}	
}
