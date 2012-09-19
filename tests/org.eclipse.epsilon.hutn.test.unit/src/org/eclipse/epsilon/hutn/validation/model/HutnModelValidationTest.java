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
 * $Id: HutnModelValidationTest.java,v 1.1 2008/08/07 14:51:11 louis Exp $
 */
package org.eclipse.epsilon.hutn.validation.model;

import java.util.List;

import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.hutn.exceptions.HutnValidationException;
import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.hutn.test.model.HutnTestWithFamiliesMetaModel;

public class HutnModelValidationTest extends HutnTestWithFamiliesMetaModel {

	protected static List<ParseProblem> problems;
	
	protected static List<ParseProblem> modelValidationTest(Spec spec) throws HutnValidationException {
		return new HutnValidator().getProblemsForIntermediateModel(spec);
	}
}
