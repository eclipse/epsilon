/**
 * *******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 * ******************************************************************************
 *
 * $Id: InvalidHutnAcceptanceTest.java,v 1.2 2008/08/07 12:44:24 louis Exp $
 */
package org.eclipse.epsilon.hutn.test.acceptance.util;

import java.util.List;

import org.eclipse.epsilon.hutn.test.util.HutnTestWithFamiliesMetaModel;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.hutn.HutnModule;
import org.eclipse.epsilon.hutn.IHutnModule;

public abstract class InvalidHutnAcceptanceTest extends HutnTestWithFamiliesMetaModel {

	protected static List<ParseProblem> parse(String hutn) throws Exception {
		final IHutnModule module = new HutnModule();
		
		module.parse(hutn);
		
		return module.getParseProblems();
	}
}
