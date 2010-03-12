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

import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.rules.AnnotatedOperation;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.rules.Guard;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.rules.MigrateToDifferentType;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.rules.Operation;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.rules.SetToNull;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.rules.SeveralRules;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.rules.SeveralRulesForSameType;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.rules.ShorthandRule;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.rules.SimpleRule;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.rules.delete.DeleteRule;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.rules.delete.DeleteRuleAppliedToAbstractType;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.rules.delete.DeleteRuleWithGuard;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.rules.delete.DeleteRuleWithInvalidSyntax;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({SimpleRule.class,
               SeveralRules.class, SeveralRulesForSameType.class,
               MigrateToDifferentType.class,
               ShorthandRule.class,
               Guard.class,
               Operation.class, AnnotatedOperation.class,
               SetToNull.class,
               DeleteRule.class, DeleteRuleWithGuard.class, DeleteRuleAppliedToAbstractType.class, DeleteRuleWithInvalidSyntax.class})
public class Strong2StrongRulesSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(Strong2StrongRulesSuite.class);
	}
}
