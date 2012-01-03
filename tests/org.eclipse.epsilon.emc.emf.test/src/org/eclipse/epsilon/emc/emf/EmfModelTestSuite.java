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
package org.eclipse.epsilon.emc.emf;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({EmfModelLoadTests.class,
               EmfModelStoreTests.class,
               EmfModelGetPropertiesOfTests.class,
               EmfModelPropertyMigratorTests.class})
public class EmfModelTestSuite {

	public static Test suite() {
		return new JUnit4TestAdapter(EmfModelTestSuite.class);
	}
}

