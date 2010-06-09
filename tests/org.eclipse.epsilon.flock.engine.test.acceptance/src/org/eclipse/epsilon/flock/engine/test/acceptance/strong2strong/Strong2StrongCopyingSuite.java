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

import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying.CopyListWhenLowerboundDecreases;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying.CopyListWhenUpperboundIncreases;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying.CopyModelElementsThatHaveARule;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying.CopyModelElementsThatHaveNoRules;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying.CopyNestedModelElements;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying.CopyPersistsIdentity;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying.CopySingleValueToList;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying.CopyValueFromAnotherModel;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying.DoNotCopyListToSingleValue;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying.DoNotCopyContainedObjectWithUnknownMigratedClass;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying.DoNotCopyListWhenLowerboundIncreases;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying.DoNotCopyListWhenUpperboundDecreases;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CopyModelElementsThatHaveNoRules.class,
               CopyModelElementsThatHaveARule.class,
               CopyNestedModelElements.class,
               DoNotCopyContainedObjectWithUnknownMigratedClass.class,
               CopySingleValueToList.class, DoNotCopyListToSingleValue.class,
               CopyListWhenUpperboundIncreases.class, DoNotCopyListWhenUpperboundDecreases.class,
               CopyListWhenLowerboundDecreases.class, DoNotCopyListWhenLowerboundIncreases.class,
               CopyValueFromAnotherModel.class,
               CopyPersistsIdentity.class})
public class Strong2StrongCopyingSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(Strong2StrongCopyingSuite.class);
	}
}
