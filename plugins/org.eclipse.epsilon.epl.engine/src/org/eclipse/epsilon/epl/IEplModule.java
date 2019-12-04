package org.eclipse.epsilon.epl;

import java.util.List;

import org.eclipse.epsilon.epl.dom.Pattern;
import org.eclipse.epsilon.epl.execute.context.IEplContext;
import org.eclipse.epsilon.erl.IErlModule;

public interface IEplModule extends IErlModule {

	void setPatternMatchModelName(String patternMatchModelName);

	String getPatternMatchModelName();

	int getMaximumLevel();

	void setRepeatWhileMatches(boolean repeatWhileMatches);

	boolean isRepeatWhileMatches();

	void setMaxLoops(int maxLoops);

	int getMaxLoops();

	List<Pattern> getPatterns();

	List<Pattern> getDeclaredPatterns();

	@Override
	default IEplContext getContext() {
		return (IEplContext) ((IErlModule)this).getContext();
	}

}
