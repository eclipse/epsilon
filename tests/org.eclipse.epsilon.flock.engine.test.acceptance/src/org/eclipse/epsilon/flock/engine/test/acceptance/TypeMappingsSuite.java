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
import org.eclipse.epsilon.flock.engine.test.acceptance.typemappings.delete.DeleteAppliedToAbstractType;
import org.eclipse.epsilon.flock.engine.test.acceptance.typemappings.delete.DeleteWithGuard;
import org.eclipse.epsilon.flock.engine.test.acceptance.typemappings.delete.DeleteWithInvalidSyntax;
import org.eclipse.epsilon.flock.engine.test.acceptance.typemappings.retype.Retype;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({Delete.class,
               DeleteWithGuard.class,
               DeleteAppliedToAbstractType.class,
               DeleteWithInvalidSyntax.class,
               Retype.class})
public class TypeMappingsSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(RulesSuite.class);
	}
}
