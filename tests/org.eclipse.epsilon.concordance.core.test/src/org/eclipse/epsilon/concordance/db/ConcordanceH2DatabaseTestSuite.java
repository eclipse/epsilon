/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.concordance.db;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.eclipse.epsilon.concordance.db.common.H2DatabaseQuerierTests;
import org.eclipse.epsilon.concordance.db.common.H2DatabaseTests;
import org.eclipse.epsilon.concordance.db.common.H2TableTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({H2DatabaseQuerierTests.class, H2DatabaseTests.class, H2TableTests.class,
               ConcordanceH2DatabaseInitialisationTests.class, ConcordanceH2DatabaseTests.class})
public class ConcordanceH2DatabaseTestSuite {

	public static Test suite() {
		return new JUnit4TestAdapter(ConcordanceH2DatabaseTestSuite.class);
	}
}
