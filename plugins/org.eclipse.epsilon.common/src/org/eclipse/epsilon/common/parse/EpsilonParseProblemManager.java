/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.common.parse;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.parse.problem.ParseProblem;

public class EpsilonParseProblemManager {
	
	public static EpsilonParseProblemManager INSTANCE = new EpsilonParseProblemManager();
	
	List<ParseProblem> parseProblems = new ArrayList<>();
	
	public void reset() {
		parseProblems.clear();
	}
	
	public void reportException(int line, int column, String reason) {
		ParseProblem problem = new ParseProblem();
		problem.setLine(line);
		problem.setColumn(column);
		problem.setReason(reason);
		parseProblems.add(problem);
	}
	
	public List<ParseProblem> getParseProblems() {
		return parseProblems;
	}
}
