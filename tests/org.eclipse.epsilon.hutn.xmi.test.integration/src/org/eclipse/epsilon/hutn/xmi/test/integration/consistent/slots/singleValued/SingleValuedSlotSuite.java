/*******************************************************************************
 * Copyright (c) 2008 The University of York.
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
package org.eclipse.epsilon.hutn.xmi.test.integration.consistent.slots.singleValued;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.eclipse.epsilon.hutn.xmi.test.integration.consistent.slots.singleValued.Boolean;
import org.eclipse.epsilon.hutn.xmi.test.integration.consistent.slots.singleValued.Enum;
import org.eclipse.epsilon.hutn.xmi.test.integration.consistent.slots.singleValued.Float;
import org.eclipse.epsilon.hutn.xmi.test.integration.consistent.slots.singleValued.Integer;
import org.eclipse.epsilon.hutn.xmi.test.integration.consistent.slots.singleValued.Reference;
import org.eclipse.epsilon.hutn.xmi.test.integration.consistent.slots.singleValued.String;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({String.class, Integer.class, Float.class, Boolean.class, Enum.class,
               Reference.class, ReferenceWithSubType.class})
public class SingleValuedSlotSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(SingleValuedSlotSuite.class);
	}
}
