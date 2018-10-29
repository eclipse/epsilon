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

import java.util.ArrayList;
import org.eclipse.epsilon.ecl.dom.MatchRule;
import org.eclipse.epsilon.ecl.execute.context.concurrent.IEclContextParallel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

/**
 * Matches each pair of elements in parallel for all rules.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EclModuleParallelRules extends EclModuleParallel {

	public EclModuleParallelRules() {
		super();
	}
	
	public EclModuleParallelRules(int parallelism) {
		super(parallelism);
	}
	
	@Override
	protected void matchAllRules(boolean greedy) throws EolRuntimeException {
		boolean ofTypeOnly = !greedy;
		IEclContextParallel context = getContext();
		ArrayList<Runnable> jobs = new ArrayList<>();
		
		for (MatchRule matchRule : getMatchRules()) {
			if (!matchRule.isAbstract() && !matchRule.isLazy(context) && (ofTypeOnly || matchRule.isGreedy())) {
				for (Object left : matchRule.getLeftInstances(context, ofTypeOnly)) {
					for (Object right : matchRule.getRightInstances(context, ofTypeOnly)) {
						jobs.add(() -> {
							try {
								matchRule.matchPair(context, ofTypeOnly, left, right);
							}
							catch (EolRuntimeException ex) {
								context.handleException(ex);
							}
						});
					}
				}
			}
		}
		
		context.executeParallel(this, jobs);
	}
}
