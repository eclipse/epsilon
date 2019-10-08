/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.ecl.concurrent;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.epsilon.ecl.EclModule;
import org.eclipse.epsilon.ecl.dom.MatchRule;
import org.eclipse.epsilon.ecl.execute.context.concurrent.*;
import org.eclipse.epsilon.eol.dom.Annotation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;
import org.eclipse.epsilon.erl.execute.context.concurrent.IErlContextParallel;

/**
 * A no-op parallel module, useful only for extending and setting
 * threads in parallelMatches.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EclModuleParallel extends EclModule {

	protected static final Set<String> CONFIG_PROPERTIES = new HashSet<>(2);
	static {
		CONFIG_PROPERTIES.add(IEolContextParallel.NUM_THREADS_CONFIG);
	}
	
	public EclModuleParallel() {
		this(null);
	}
	
	public EclModuleParallel(IEclContextParallel context) {
		super(context != null ? context : new EclContextParallel());
	}
	
	@Override
	protected void matchAllRules(boolean greedy) throws EolRuntimeException {
		boolean ofTypeOnly = !greedy;
		IEclContextParallel context = getContext();
		EolExecutorService executor = context.beginParallelTask();
		
		for (MatchRule matchRule : getMatchRules()) {
			if (!matchRule.isAbstract() && !matchRule.isLazy(context) && (ofTypeOnly || matchRule.isGreedy())) {
				Collection<?> leftInstances = matchRule.getLeftInstances(context, ofTypeOnly);
				Collection<?> rightInstances = matchRule.getRightInstances(context, ofTypeOnly);
				
				Annotation pAnnotation = matchRule.getAnnotation(IErlContextParallel.PARALLEL_ANNOTATION_NAME);
				
				if (pAnnotation != null) {
					if (matchRule.getBooleanAnnotationValue(IErlContextParallel.PARALLEL_ANNOTATION_NAME, context, () ->
						new Variable[] {
							Variable.createReadOnlyVariable("leftInstances", leftInstances),
							Variable.createReadOnlyVariable("rightInstances", rightInstances),
							Variable.createReadOnlyVariable("matchRule", matchRule),
							Variable.createReadOnlyVariable("THREADS", context.getParallelism())
					})) {
						for (Object left : leftInstances) {
							for (Object right : rightInstances) {
								executor.execute(() -> matchRule.matchPair(context, ofTypeOnly, left, right));
							}
						}
					}
				}
				else {
					for (Object left : leftInstances) {
						for (Object right : rightInstances) {
							matchRule.matchPair(context, ofTypeOnly, left, right);
						}
					}
				}
			}
		}
		
		executor.awaitCompletion();
		context.endParallelTask();
	}
	
	@Override
	public IEclContextParallel getContext() {
		return (IEclContextParallel) super.getContext();
	}
	
	@Override
	public Set<String> getConfigurationProperties() {
		return CONFIG_PROPERTIES;
	}
	
	/**
	 * WARNING: This method should only be called by the DT plugin for initialization purposes,
	 * as the context will be reset!
	 */
	@Override
	public void configure(Map<String, ?> properties) throws IllegalArgumentException {
		super.configure(properties);
		setContext(IEolContextParallel.configureContext(properties, EclContextParallel::new, getContext()));
	}
}
