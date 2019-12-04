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
import org.eclipse.epsilon.erl.execute.context.IErlContext;

/**
 * 
 * @author Betty Sanchez
 * @since 1.6
 */
public interface IEplContext extends IErlContext {

	void setPatternMatcher(PatternMatcher matcher);
	
	PatternMatcher getPatternMatcher();
	
	PatternMatchModel getPatternMatchTrace();

	void setPatternMatchTrace(PatternMatchModel model);
}
