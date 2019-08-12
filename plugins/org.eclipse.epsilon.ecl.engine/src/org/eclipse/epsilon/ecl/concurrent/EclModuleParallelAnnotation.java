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
import org.eclipse.epsilon.ecl.dom.MatchRule;
import org.eclipse.epsilon.ecl.execute.context.concurrent.IEclContextParallel;
import org.eclipse.epsilon.eol.dom.Annotation;
import org.eclipse.epsilon.eol.dom.ExecutableAnnotation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.erl.concurrent.IErlModuleParallel;

/**
 * Parallel execution for ECL only on rules annotated with <code>@parallel</code>.
 * @author Sina Madani
 * @since 1.6
 */
public class EclModuleParallelAnnotation extends EclModuleParallel implements IErlModuleParallel {

	public EclModuleParallelAnnotation() {
		super();
	}

	public EclModuleParallelAnnotation(int parallelism) {
		super(parallelism);
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
				
				Annotation pAnnotation = matchRule.getAnnotation(PARALLEL_ANNOTATION_NAME);
				
				if (pAnnotation != null) {
					Variable[] annotationVariables = pAnnotation instanceof ExecutableAnnotation ?
						new Variable[] {
							Variable.createReadOnlyVariable("leftInstances", leftInstances),
							Variable.createReadOnlyVariable("rightInstances", rightInstances),
							Variable.createReadOnlyVariable("matchRule", matchRule),
							Variable.createReadOnlyVariable("THREADS", context.getParallelism())
						} : new Variable[0];
					if (shouldBeParallel(pAnnotation, annotationVariables)) {
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
	
}
