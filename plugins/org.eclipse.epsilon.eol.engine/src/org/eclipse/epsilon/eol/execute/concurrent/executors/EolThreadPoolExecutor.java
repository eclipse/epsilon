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

import java.util.concurrent.*;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.EolConcurrentExecutionStatus;
import org.eclipse.epsilon.eol.execute.concurrent.EolThreadFactory;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolThreadPoolExecutor;

/**
 * Fixed number of threads with unbounded queueing. The threads
 * are always recycled and never destroyed.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EolThreadPoolExecutor extends ThreadPoolExecutor implements EolExecutorService {

	protected final EolConcurrentExecutionStatus execStatus = new EolConcurrentExecutionStatus();
	
	public EolThreadPoolExecutor(int numThreads) {
		super(numThreads, numThreads, Long.MAX_VALUE, TimeUnit.NANOSECONDS, new LinkedBlockingQueue<>(), (r, e) -> {});
		setThreadFactory(new EolThreadFactory(this::handleException, numThreads));
	}
	
	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);
		if (t instanceof Exception) {
			handleException(EolRuntimeException.findCause(t));
		}
	}

	@Override
	public EolConcurrentExecutionStatus getExecutionStatus() {
		return execStatus;
	}
	
	@Override
	protected void terminated() {
		super.terminated();
		if (execStatus != null && execStatus.isInProgress()) {
			execStatus.completeSuccessfully();
		}
	}
}
