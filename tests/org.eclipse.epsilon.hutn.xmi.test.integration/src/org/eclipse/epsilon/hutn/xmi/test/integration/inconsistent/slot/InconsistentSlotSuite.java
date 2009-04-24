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
package org.eclipse.epsilon.hutn.xmi.test.integration.inconsistent.slot;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.eclipse.epsilon.hutn.xmi.test.integration.inconsistent.slot.attribute.InconsistentAttributeSlotSuite;
import org.eclipse.epsilon.hutn.xmi.test.integration.inconsistent.slot.containment.InconsistentClassObjectSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({InconsistentAttributeSlotSuite.class,
               InconsistentClassObjectSuite.class,
               SeveralSlotsWithNoFeature.class})
public class InconsistentSlotSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(InconsistentSlotSuite.class);
	}
}
