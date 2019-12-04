/*********************************************************************
 * Copyright (c) 2019 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.epl;

import java.util.List;

import org.eclipse.epsilon.epl.dom.Pattern;
import org.eclipse.epsilon.epl.execute.context.IEplContext;
import org.eclipse.epsilon.erl.IErlModule;

/**
 * 
 * @since 1.6
 */
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
