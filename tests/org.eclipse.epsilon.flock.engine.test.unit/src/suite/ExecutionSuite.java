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

import org.eclipse.epsilon.flock.FlockExecutionTests;
import org.eclipse.epsilon.flock.equivalences.EquivalencesTests;
import org.eclipse.epsilon.flock.equivalences.TypeBasedEquivalenceTests;
import org.eclipse.epsilon.flock.equivalences.factory.DefaultEquivalenceFactoryTests;
import org.eclipse.epsilon.flock.execution.EolExecutorTests;
import org.eclipse.epsilon.flock.execution.MigrateRuleContextTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({FlockExecutionTests.class,
               DefaultEquivalenceFactoryTests.class,
               EquivalencesTests.class, TypeBasedEquivalenceTests.class,
               EolExecutorTests.class, MigrateRuleContextTests.class})
public class ExecutionSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(ExecutionSuite.class);
	}
}
