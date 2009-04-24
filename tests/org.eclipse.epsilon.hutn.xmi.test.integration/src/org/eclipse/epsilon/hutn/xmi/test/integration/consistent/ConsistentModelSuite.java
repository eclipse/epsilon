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
package org.eclipse.epsilon.hutn.xmi.test.integration.consistent;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.eclipse.epsilon.hutn.xmi.test.integration.consistent.classObjects.ClassObjectSuite;
import org.eclipse.epsilon.hutn.xmi.test.integration.consistent.packageObjects.PackageObjectSuite;
import org.eclipse.epsilon.hutn.xmi.test.integration.consistent.slots.SlotSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({PackageObjectSuite.class, ClassObjectSuite.class, SlotSuite.class})
public class ConsistentModelSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(ConsistentModelSuite.class);
	}
}
