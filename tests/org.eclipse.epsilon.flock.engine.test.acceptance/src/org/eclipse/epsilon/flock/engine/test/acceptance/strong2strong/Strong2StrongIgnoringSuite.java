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

import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying.ignoring.BodyTakesPriorityOverIgnore;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying.ignoring.GuardedIgnore;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying.ignoring.BodyAndIgnored;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying.ignoring.IgnoreEscapedProperty;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying.ignoring.IgnoreOneProperty;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying.ignoring.IgnoreSeveralProperties;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({IgnoreOneProperty.class,
               IgnoreEscapedProperty.class,
               IgnoreSeveralProperties.class,
               GuardedIgnore.class,
               BodyAndIgnored.class,
               BodyTakesPriorityOverIgnore.class})
public class Strong2StrongIgnoringSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(Strong2StrongIgnoringSuite.class);
	}
}
