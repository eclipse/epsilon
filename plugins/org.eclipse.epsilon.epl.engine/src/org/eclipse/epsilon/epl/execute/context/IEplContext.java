package org.eclipse.epsilon.epl.execute.context;

import org.eclipse.epsilon.epl.execute.PatternMatchModel;
import org.eclipse.epsilon.epl.execute.PatternMatcher;
import org.eclipse.epsilon.erl.execute.context.IErlContext;

public interface IEplContext extends IErlContext {

	void setPatternMatcher(PatternMatcher matcher);
	
	PatternMatcher getPatternMatcher();
	
	PatternMatchModel getPatternMatchTrace();

	void setPatternMatchTrace(PatternMatchModel model);
}
