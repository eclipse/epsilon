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
package suite;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.eclipse.epsilon.migration.MigrationContextTests;
import org.eclipse.epsilon.migration.execution.EquivalenceEstablisherTests;
import org.eclipse.epsilon.migration.execution.EquivalencesTests;
import org.eclipse.epsilon.migration.execution.RuleBasedEquivalenceTests;
import org.eclipse.epsilon.migration.execution.TypeBasedEquivalenceTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({MigrationContextTests.class,
               EquivalencesTests.class, RuleBasedEquivalenceTests.class, TypeBasedEquivalenceTests.class, EquivalenceEstablisherTests.class})
public class ExecutionSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(ExecutionSuite.class);
	}
}
