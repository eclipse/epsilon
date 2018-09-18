/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.erl.execute;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;
import org.eclipse.epsilon.eol.execute.control.IExecutionListener;
import org.eclipse.epsilon.erl.dom.NamedRule;
import org.eclipse.epsilon.common.util.profiling.BenchmarkUtils;

/**
 * Allows for repeated profiling of {@link NamedRule}s. This listener is not
 * thread-safe. For use in concurrent applications, each thread should have its
 * own copy of this listener. Once concurrent execution has completed, the results
 * can be merged using {@link #getExecutionTimes(Map...)}. Typically, serial thread
 * confinement is achieved automatically in implementations of {@link IEolContextParallel}
 * which have a dedicated {@linkplain ExecutorFactory} per thread.
 * 
 * @author Sina Madani
 */
public class RuleProfiler implements IExecutionListener {

	protected final Map<NamedRule, Duration> executionTimes = new HashMap<>();
	private long currentStartNanos;
	private NamedRule currentRule;
	
	@Override
	public void aboutToExecute(ModuleElement ast, IEolContext context) {
		if (ast instanceof NamedRule) {
			currentRule = (NamedRule) ast;
			currentStartNanos = System.nanoTime();
		}
	}

	@Override
	public void finishedExecuting(ModuleElement ast, Object result, IEolContext context) {
		if (ast == currentRule) {
			long execTimeNanos = System.nanoTime() - currentStartNanos;
			Duration currentDuration = executionTimes.get(ast);
			
			executionTimes.put(
				currentRule, 
				currentDuration != null ? currentDuration.plusNanos(execTimeNanos) : Duration.ofNanos(execTimeNanos)
			);
			
			currentRule = null;
		}
	}

	@Override
	public void finishedExecutingWithException(ModuleElement ast, EolRuntimeException exception, IEolContext context) {
		finishedExecuting(ast, exception, context);
	}
	
	public Map<NamedRule, Duration> getExecutionTimes() {
		return executionTimes;
	}
	
	@SafeVarargs
	public final void mergeExecutionTimes(Map<NamedRule, Duration>... others) {
		for (Map<NamedRule, Duration> execTimes : others) {
			for (Map.Entry<NamedRule, Duration> entry : execTimes.entrySet()) {
				Duration ruleDuration = executionTimes.get(entry.getKey());
				Duration entryDuration = entry.getValue();
				executionTimes.put(
					entry.getKey(),
					ruleDuration != null ? ruleDuration.plus(entryDuration) : entryDuration
				);
			}
		}
	}
	
	@Override
	public String toString() {
		return getExecutionTimes()
			.entrySet()
			.stream()
			.sorted((a, b) -> b.getValue().compareTo(a.getValue()))
			.map(entry -> "'"+entry.getKey()+"' took "+BenchmarkUtils.formatDuration(entry.getValue()))
			.collect(Collectors.joining(",\n"));
	}
	
}
