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
		super(parallelism);
		
		matchTrace = new MatchTrace(true);
		tempMatchTraces = new PersistentThreadLocal<>(MatchTrace::new);
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
