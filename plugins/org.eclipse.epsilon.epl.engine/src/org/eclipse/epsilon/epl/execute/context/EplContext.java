/*********************************************************************
 * Copyright (c) 2019 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.epl.execute.context;

import org.eclipse.epsilon.epl.execute.PatternMatchModel;
import org.eclipse.epsilon.epl.execute.PatternMatcher;
import org.eclipse.epsilon.erl.execute.context.ErlContext;

/**
 * 
 * @author Betty Sanchez
 * @since 1.6
 */
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
