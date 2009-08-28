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

import org.eclipse.epsilon.flock.model.MigrationRuleApplyToTests;
import org.eclipse.epsilon.flock.model.MigrationRuleIsOfOriginalTypeTests;
import org.eclipse.epsilon.flock.model.MigrationRuleSatisfiesGuardTests;
import org.eclipse.epsilon.flock.model.MigrationStrategyRuleForTests;
import org.eclipse.epsilon.flock.model.checker.MigrationStrategyCheckerTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({MigrationStrategyRuleForTests.class,
               MigrationRuleIsOfOriginalTypeTests.class, MigrationRuleSatisfiesGuardTests.class,
               MigrationRuleApplyToTests.class,
               MigrationStrategyCheckerTests.class})
public class DomainModelSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(DomainModelSuite.class);
	}
}
