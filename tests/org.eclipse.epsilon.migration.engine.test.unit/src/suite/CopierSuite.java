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

import org.eclipse.epsilon.migration.copy.AttributeValueTest;
import org.eclipse.epsilon.migration.copy.ContainedObjectTest;
import org.eclipse.epsilon.migration.copy.ContainedObjectsTest;
import org.eclipse.epsilon.migration.copy.NonExistentAttributeValueTest;
import org.eclipse.epsilon.migration.copy.ObjectTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ObjectTest.class,
               AttributeValueTest.class, NonExistentAttributeValueTest.class,
               ContainedObjectTest.class, ContainedObjectsTest.class})
public class CopierSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(CopierSuite.class);
	}
}
