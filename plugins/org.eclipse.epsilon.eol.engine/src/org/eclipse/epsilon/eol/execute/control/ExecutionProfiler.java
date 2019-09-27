/*******************************************************************************
 * Copyright (c) 2008-2019 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Sina Madani - Refactoring and enhancements
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.control;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.util.profiling.BenchmarkUtils;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class ExecutionProfiler implements ExecutionController, IExecutionListener {
	
	protected final Map<ModuleElement, Duration> executionTimes = new HashMap<>();
	protected final Class<? extends ModuleElement> profiledTypes[];
	private ModuleElement currentAst;
	private long currentStartNanos;
	
	public ExecutionProfiler() {
		this(ModuleElement.class);
	}
	
	@SafeVarargs
	public ExecutionProfiler(Class<? extends ModuleElement>... profileClasses) {
		profiledTypes = profileClasses;
	}
	
	@Override
	public void control(ModuleElement ast, IEolContext context) {
		if (ast == null || Stream.of(profiledTypes).noneMatch(t -> t.isInstance(ast)))
			return;
		
		currentAst = ast;
		currentStartNanos = System.nanoTime();
	}
	
	@Override
	public void done(ModuleElement ast, IEolContext context) {
		if (ast == null || ast != currentAst) return;
		
		long execTimeNanos = System.nanoTime() - currentStartNanos;
		Duration currentDuration = executionTimes.get(ast);
		
		executionTimes.put(
			currentAst, 
			currentDuration != null ? currentDuration.plusNanos(execTimeNanos) : Duration.ofNanos(execTimeNanos)
		);
		
		currentAst = null;
	}

	@Override
	public void dispose() {
		executionTimes.clear();
		currentAst = null;
		currentStartNanos = 0;
	}

	@Override
	public void report(IEolContext context) {
		context.getErrorStream().println(this.toString());
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
	
	@SafeVarargs
	public final void mergeExecutionTimes(Map<? extends ModuleElement, Duration>... others) {
		for (Map<? extends ModuleElement, Duration> execTimes : others) {
			for (Map.Entry<? extends ModuleElement, Duration> entry : execTimes.entrySet()) {
				Duration ruleDuration = executionTimes.get(entry.getKey());
				Duration entryDuration = entry.getValue();
				executionTimes.put(
					entry.getKey(),
					ruleDuration != null ? ruleDuration.plus(entryDuration) : entryDuration
				);
			}
		}
	}
	
	public Map<ModuleElement, Duration> getExecutionTimes() {
		return executionTimes;
	}

	@Override
	public boolean isTerminated() {
		return false;
	}
	
	@Override
	public void aboutToExecute(ModuleElement ast, IEolContext context) {
		control(ast, context);
	}

	@Override
	public void finishedExecuting(ModuleElement ast, Object result, IEolContext context) {
		done(ast, context);
	}

	@Override
	public void finishedExecutingWithException(ModuleElement ast, EolRuntimeException exception, IEolContext context) {
		done(ast, context);
	}
}
