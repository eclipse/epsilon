/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.ecl.execute.context.concurrent;

import org.eclipse.epsilon.ecl.IEclModule;
import org.eclipse.epsilon.ecl.execute.context.IEclContext;
import org.eclipse.epsilon.ecl.trace.MatchTrace;
import org.eclipse.epsilon.eol.execute.concurrent.PersistentThreadLocal;
import org.eclipse.epsilon.eol.execute.context.concurrent.EolContextParallel;

public class EclContextParallel extends EolContextParallel implements IEclContext {

	protected PersistentThreadLocal<MatchTrace> tempMatchTraces;
	protected MatchTrace matchTrace;
	
	public EclContextParallel() {
		this(0);
	}

	public EclContextParallel(int parallelism) {
		super(parallelism, true);
	}

	@Override
	protected void initMainThreadStructures() {
		super.initMainThreadStructures();
		matchTrace = new MatchTrace(true);
	}
	
	@Override
	protected void initThreadLocals() {
		super.initThreadLocals();
		tempMatchTraces = new PersistentThreadLocal<>(MatchTrace::new);
	}
	
	@Override
	public void setMatchTrace(MatchTrace matchTrace) {
		this.matchTrace = matchTrace;
	}
	
	@Override
	public MatchTrace getMatchTrace() {
		return matchTrace;
	}

	@Override
	public MatchTrace getTempMatchTrace() {
		return parallelGet(tempMatchTraces, () -> null);
	}

	@Override
	public IEclModule getModule() {
		return (IEclModule) module;
	}
}
