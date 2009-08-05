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

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.strong2strong.AutomaticallyCopyModelElementsThatHaveNoStrategy;
import test.strong2strong.ConservativeCopy;
import test.strong2strong.ContainedObjects;
import test.strong2strong.EquivalentOperation;
import test.strong2strong.MigrateToDifferentType;
import test.strong2strong.ShorthandRule;
import test.strong2strong.SeveralRules;
import test.strong2strong.SeveralRulesForSameType;
import test.strong2strong.Simple;
import test.strong2strong.Guard;

@RunWith(Suite.class)
@SuiteClasses({Simple.class, ContainedObjects.class, AutomaticallyCopyModelElementsThatHaveNoStrategy.class,
               SeveralRules.class, SeveralRulesForSameType.class,
               MigrateToDifferentType.class, ShorthandRule.class,
               Guard.class,
               ConservativeCopy.class, EquivalentOperation.class})
public class Strong2StrongSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(Strong2StrongSuite.class);
	}
}
