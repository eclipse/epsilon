/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.eol.engine.test.acceptance;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.eclipse.epsilon.eol.engine.test.acceptance.equalityStatement.EqualityBecomesAssignmentInStatements;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({AssignmentTests.class, ComparisonTests.class, CreateDeleteTests.class, EqualityTests.class, CollectionsTests.class, MathTests.class, StringTests.class, AnnotatedOperationTests.class, IsDefinedTests.class, IterableTests.class, IWrapperTests.class,
	           EqualityBecomesAssignmentInStatements.class, ReturnTypeTests.class, BuiltInVariablesTests.class, ModelElementTypeResolutionTests.class})
public class EolAcceptanceTestSuite {

	public static Test suite() {
		return new JUnit4TestAdapter(EolAcceptanceTestSuite.class);
	}
}
