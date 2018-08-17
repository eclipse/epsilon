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
import org.eclipse.epsilon.ecl.EclModule;
import org.eclipse.epsilon.ecl.dom.MatchRule;
import org.eclipse.epsilon.ecl.execute.context.concurrent.EclContextParallel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class EclModuleParallel extends EclModule {

	public EclModuleParallel() {
		this(0);
	}
	
	public EclModuleParallel(int parallelism) {
		this.context = new EclContextParallel(parallelism);
	}
	
	@Override
	protected void prepareExecution() throws EolRuntimeException {
		super.prepareExecution();
		getContext().goParallel();
	}
	
	@Override
	protected void postExecution() throws EolRuntimeException {
		getContext().endParallel();
		super.postExecution();
	}
	
	@Override
	protected void matchAllRules(boolean greedy) throws EolRuntimeException {
		boolean ofTypeOnly = !greedy;
		EclContextParallel context = getContext();
		ArrayList<Runnable> jobs = new ArrayList<>();
		
		for (MatchRule matchRule : getMatchRules()) {
			if (!matchRule.isAbstract() && !matchRule.isLazy(context) && (ofTypeOnly || matchRule.isGreedy())) {
				for (Object left : matchRule.getLeftInstance(context, ofTypeOnly)) {
					for (Object right : matchRule.getRightInstance(context, ofTypeOnly)) {
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

	@Override
	public EclContextParallel getContext() {
		return (EclContextParallel) context;
	}
	
	@Override
	public void setContext(IEolContext context) {
		if (context instanceof EclContextParallel) {
			super.setContext(context);
		}
	}
}
