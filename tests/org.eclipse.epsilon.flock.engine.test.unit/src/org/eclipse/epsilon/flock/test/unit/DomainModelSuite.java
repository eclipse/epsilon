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
package org.eclipse.epsilon.flock.test.unit;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.eclipse.epsilon.flock.model.domain.MigrationStrategyTests;
import org.eclipse.epsilon.flock.model.domain.common.GuardTests;
import org.eclipse.epsilon.flock.model.domain.rules.BodyTests;
import org.eclipse.epsilon.flock.model.domain.rules.MigrateRuleTests;
import org.eclipse.epsilon.flock.model.domain.rules.MigrateRulesTests;
import org.eclipse.epsilon.flock.model.domain.typemappings.RetypingTests;
import org.eclipse.epsilon.flock.model.domain.typemappings.TypeMappingConstructsTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({MigrationStrategyTests.class,
               TypeMappingConstructsTests.class,
               MigrateRuleTests.class, MigrateRulesTests.class, BodyTests.class,
               GuardTests.class,
               RetypingTests.class,
               CheckerSuite.class})
public class DomainModelSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(DomainModelSuite.class);
	}
}
