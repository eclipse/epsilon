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
package org.eclipse.epsilon.flock.engine.test.acceptance;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.eclipse.epsilon.flock.engine.test.acceptance.inheritance.IgnoredPropertiesAreAccumalatedOverTypeHierachy;
import org.eclipse.epsilon.flock.engine.test.acceptance.inheritance.ReuseIgnoredProperties;
import org.eclipse.epsilon.flock.engine.test.acceptance.inheritance.ReuseMigrationAndRetype;
import org.eclipse.epsilon.flock.engine.test.acceptance.inheritance.ReuseMigrationForAbstractType;
import org.eclipse.epsilon.flock.engine.test.acceptance.inheritance.ReuseMigrationForConcreteType;
import org.eclipse.epsilon.flock.engine.test.acceptance.inheritance.ReuseMigrationForSomeSubtypes;
import org.eclipse.epsilon.flock.engine.test.acceptance.inheritance.RulesRunInTheOrderThatTheyAppear;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ReuseMigrationForAbstractType.class,
               ReuseMigrationForConcreteType.class,
               ReuseMigrationForSomeSubtypes.class,
               ReuseMigrationAndRetype.class,
               RulesRunInTheOrderThatTheyAppear.class,
               ReuseIgnoredProperties.class,
               IgnoredPropertiesAreAccumalatedOverTypeHierachy.class})
public class InheritanceSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(InheritanceSuite.class);
	}
}
