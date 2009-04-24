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
package org.eclipse.epsilon.hutn.xmi.test.integration.inconsistent;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.eclipse.epsilon.hutn.xmi.test.integration.inconsistent.object.InconsistentObjectSuite;
import org.eclipse.epsilon.hutn.xmi.test.integration.inconsistent.slot.InconsistentSlotSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({InconsistentObjectSuite.class,
               InconsistentSlotSuite.class})
public class InconsistentModelSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(InconsistentModelSuite.class);
	}
}
