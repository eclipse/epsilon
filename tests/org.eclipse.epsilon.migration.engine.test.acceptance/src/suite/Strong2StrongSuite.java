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

import test.strong2strong.copying.ConservativelyCopyModelElementsThatHaveNoRules;
import test.strong2strong.copying.ConservativelyCopyModelElementsThatHaveARule;
import test.strong2strong.copying.ConservativelyCopyNestedModelElements;
import test.strong2strong.copying.DoNotCopyContainedObjectWithUnknownMigratedClass;
import test.strong2strong.equivalences.EquivalentOfCollectionOfModelElements;
import test.strong2strong.equivalences.EquivalentOfModelElement;
import test.strong2strong.equivalences.IgnoreInstancesWithUnknownMigratedClass;
import test.strong2strong.rules.Guard;
import test.strong2strong.rules.MigrateToDifferentType;
import test.strong2strong.rules.Operation;
import test.strong2strong.rules.SeveralRules;
import test.strong2strong.rules.SeveralRulesForSameType;
import test.strong2strong.rules.ShorthandRule;
import test.strong2strong.rules.Simple;

@RunWith(Suite.class)
@SuiteClasses({Simple.class, ConservativelyCopyNestedModelElements.class, ConservativelyCopyModelElementsThatHaveNoRules.class,
               SeveralRules.class, SeveralRulesForSameType.class,
               MigrateToDifferentType.class, ShorthandRule.class,
               Guard.class,
               ConservativelyCopyModelElementsThatHaveARule.class, EquivalentOfModelElement.class, EquivalentOfCollectionOfModelElements.class,
               Operation.class,
               DoNotCopyContainedObjectWithUnknownMigratedClass.class,
               IgnoreInstancesWithUnknownMigratedClass.class})
public class Strong2StrongSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(Strong2StrongSuite.class);
	}
}
