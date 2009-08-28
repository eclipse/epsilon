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

import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying.ConservativelyCopyModelElementsThatHaveARule;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying.ConservativelyCopyModelElementsThatHaveNoRules;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying.ConservativelyCopyNestedModelElements;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying.DoNotCopyContainedObjectWithUnknownMigratedClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ConservativelyCopyModelElementsThatHaveNoRules.class,
               ConservativelyCopyModelElementsThatHaveARule.class,
               ConservativelyCopyNestedModelElements.class,
               DoNotCopyContainedObjectWithUnknownMigratedClass.class})
public class Strong2StrongCopyingSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(Strong2StrongCopyingSuite.class);
	}
}
