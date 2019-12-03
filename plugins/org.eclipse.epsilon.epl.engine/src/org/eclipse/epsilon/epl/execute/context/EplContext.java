package org.eclipse.epsilon.epl.execute.context;

import org.eclipse.epsilon.epl.execute.PatternMatchModel;
import org.eclipse.epsilon.epl.execute.PatternMatcher;
import org.eclipse.epsilon.erl.execute.context.ErlContext;

public class EplContext extends ErlContext implements IEplContext {

	protected PatternMatcher matcher;
	protected PatternMatchModel matchModel;
	
	@Override
	public void setPatternMatcher(PatternMatcher matcher) {
		this.matcher = matcher;
	}
	
	@Override
	public void setPatternMatchTrace(PatternMatchModel model) {
		this.matchModel = model;
	}

	@Override
	public PatternMatcher getPatternMatcher() {
		return this.matcher;
	}

	@Override
	public PatternMatchModel getPatternMatchTrace() {
		return this.matchModel;
	}

}
