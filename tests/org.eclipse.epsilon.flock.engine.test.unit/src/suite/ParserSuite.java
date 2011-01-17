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

import org.eclipse.epsilon.flock.model.loader.DeletionLoaderTest;
import org.eclipse.epsilon.flock.model.loader.MigrateRuleLoaderTest;
import org.eclipse.epsilon.flock.model.loader.MigrationStrategyLoaderTest;
import org.eclipse.epsilon.flock.model.loader.RetypingLoaderTest;
import org.eclipse.epsilon.flock.parse.TestFlock;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestFlock.class,
               MigrationStrategyLoaderTest.class, MigrateRuleLoaderTest.class, DeletionLoaderTest.class, RetypingLoaderTest.class})
public class ParserSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(ParserSuite.class);
	}
}
