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

import org.eclipse.epsilon.flock.engine.test.acceptance.rules.AnnotatedOperation;
import org.eclipse.epsilon.flock.engine.test.acceptance.rules.Guard;
import org.eclipse.epsilon.flock.engine.test.acceptance.rules.GuardsShouldBeEvaluatedOnlyOnce;
import org.eclipse.epsilon.flock.engine.test.acceptance.rules.Operation;
import org.eclipse.epsilon.flock.engine.test.acceptance.rules.Retype;
import org.eclipse.epsilon.flock.engine.test.acceptance.rules.SetToNull;
import org.eclipse.epsilon.flock.engine.test.acceptance.rules.SeveralRules;
import org.eclipse.epsilon.flock.engine.test.acceptance.rules.SeveralRulesForSameType;
import org.eclipse.epsilon.flock.engine.test.acceptance.rules.SimpleRule;
import org.eclipse.epsilon.flock.engine.test.acceptance.rules.delete.DeleteRule;
import org.eclipse.epsilon.flock.engine.test.acceptance.rules.delete.DeleteRuleAppliedToAbstractType;
import org.eclipse.epsilon.flock.engine.test.acceptance.rules.delete.DeleteRuleWithGuard;
import org.eclipse.epsilon.flock.engine.test.acceptance.rules.delete.DeleteRuleWithInvalidSyntax;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({SimpleRule.class,
               SeveralRules.class, SeveralRulesForSameType.class,
               Retype.class,
               Guard.class, GuardsShouldBeEvaluatedOnlyOnce.class,
               Operation.class, AnnotatedOperation.class,
               SetToNull.class,
               DeleteRule.class, DeleteRuleWithGuard.class, DeleteRuleAppliedToAbstractType.class, DeleteRuleWithInvalidSyntax.class})
public class RulesSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(RulesSuite.class);
	}
}
