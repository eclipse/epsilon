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
package org.eclipse.epsilon.concordance.core.test;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.eclipse.epsilon.concordance.index.FileLocatorTests;
import org.eclipse.epsilon.concordance.model.ContentAnalyserTests;
import org.eclipse.epsilon.concordance.model.CrossReferenceAnalyserTests;
import org.eclipse.epsilon.concordance.model.CrossReferenceReconcilerTests;
import org.eclipse.epsilon.concordance.reporter.model.ResourceCategoriserTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({FileLocatorTests.class,
               ResourceCategoriserTests.class,
               ContentAnalyserTests.class, CrossReferenceAnalyserTests.class, CrossReferenceReconcilerTests.class})
public class ConcordanceCorePluggedInTestSuite {

	public static Test suite() {
		return new JUnit4TestAdapter(ConcordanceCorePluggedInTestSuite.class);
	}
}
