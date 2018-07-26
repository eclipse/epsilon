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
package org.eclipse.epsilon.concordance.clients.test;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.eclipse.epsilon.concordance.clients.conformance.ConformanceCheckerTests;
import org.eclipse.epsilon.concordance.clients.migration.AutomaticMigrationTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ConformanceCheckerTests.class, AutomaticMigrationTests.class})
public class ConcordanceClientsTestSuite {

	public static Test suite() {
		return new JUnit4TestAdapter(ConcordanceClientsTestSuite.class);
	}
}
