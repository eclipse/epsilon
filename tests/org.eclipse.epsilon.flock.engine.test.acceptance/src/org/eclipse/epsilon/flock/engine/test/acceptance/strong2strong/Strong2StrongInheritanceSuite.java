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
package org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.inheritance.IgnoredPropertiesAreAccumalatedOverTypeHierachy;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.inheritance.ReuseIgnoredProperties;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.inheritance.ReuseMigrationAndRetype;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.inheritance.ReuseMigrationForAbstractType;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.inheritance.ReuseMigrationForConcreteType;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.inheritance.ReuseMigrationForSomeSubtypes;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.inheritance.RulesRunInTheOrderThatTheyAppear;
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
public class Strong2StrongInheritanceSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(Strong2StrongInheritanceSuite.class);
	}
}
