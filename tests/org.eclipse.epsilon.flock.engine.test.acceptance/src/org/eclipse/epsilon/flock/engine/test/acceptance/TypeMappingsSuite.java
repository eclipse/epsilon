/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.flock.engine.test.acceptance;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.eclipse.epsilon.flock.engine.test.acceptance.typemappings.delete.Delete;
import org.eclipse.epsilon.flock.engine.test.acceptance.typemappings.delete.DeleteAppliesToSubtypes;
import org.eclipse.epsilon.flock.engine.test.acceptance.typemappings.delete.DeleteCanExcludeSomeSubtypes;
import org.eclipse.epsilon.flock.engine.test.acceptance.typemappings.delete.DeleteWithGuard;
import org.eclipse.epsilon.flock.engine.test.acceptance.typemappings.delete.DeleteWithInvalidSyntax;
import org.eclipse.epsilon.flock.engine.test.acceptance.typemappings.delete.StrictDeleteDoesNotApplyToSubtypes;
import org.eclipse.epsilon.flock.engine.test.acceptance.typemappings.retype.Retype;
import org.eclipse.epsilon.flock.engine.test.acceptance.typemappings.retype.RetypeAppliesToSubtypes;
import org.eclipse.epsilon.flock.engine.test.acceptance.typemappings.retype.RetypeCanExcludeSomeSubtypes;
import org.eclipse.epsilon.flock.engine.test.acceptance.typemappings.retype.RetypeWithGuard;
import org.eclipse.epsilon.flock.engine.test.acceptance.typemappings.retype.RetypeWithInvalidSyntax;
import org.eclipse.epsilon.flock.engine.test.acceptance.typemappings.retype.StrictRetypeDoesNotApplyToSubtypes;
import org.eclipse.epsilon.flock.engine.test.acceptance.typemappings.OnlyTheFirstApplicableTypeMappingIsAppliedPerModelElement;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({Delete.class,
               DeleteWithGuard.class,
               DeleteAppliesToSubtypes.class,
               DeleteCanExcludeSomeSubtypes.class,
               DeleteWithInvalidSyntax.class,
               StrictDeleteDoesNotApplyToSubtypes.class,
               Retype.class,
               RetypeWithGuard.class,
               RetypeAppliesToSubtypes.class,
               RetypeCanExcludeSomeSubtypes.class,
               RetypeWithInvalidSyntax.class,
               StrictRetypeDoesNotApplyToSubtypes.class,
               OnlyTheFirstApplicableTypeMappingIsAppliedPerModelElement.class})
public class TypeMappingsSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(RulesSuite.class);
	}
}
