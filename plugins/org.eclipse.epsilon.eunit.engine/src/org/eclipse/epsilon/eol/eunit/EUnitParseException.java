/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.eunit;

import java.util.List;

import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

/**
 * Exception for when EUnit modules have parsing problems. Normally we just
 * hang on and continue processing, but with EUnit we prefer to just abort
 * execution.
 *
 * @author Antonio García-Domínguez
 * @version 1.0
 */
public class EUnitParseException extends EolRuntimeException {

	private static final long serialVersionUID = 1L;

	private List<ParseProblem> parseProblems;

	public EUnitParseException(List<ParseProblem> parseProblems) {
		this.parseProblems = parseProblems;
	}

	public List<ParseProblem> getProblems() {
		return parseProblems;
	}

	@Override
	public String getMessage() {
		return "Found " + parseProblems.size() + " parse problems";
	}
}
