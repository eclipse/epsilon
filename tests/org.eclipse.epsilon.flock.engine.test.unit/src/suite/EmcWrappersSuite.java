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

import org.eclipse.epsilon.flock.emc.wrappers.AttributeValueTests;
import org.eclipse.epsilon.flock.emc.wrappers.CollectionOfModelValuesTests;
import org.eclipse.epsilon.flock.emc.wrappers.EnumValueTests;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElementTests;
import org.eclipse.epsilon.flock.emc.wrappers.ModelTests;
import org.eclipse.epsilon.flock.emc.wrappers.ModelValueWrapperTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ModelTests.class, ModelValueWrapperTests.class,
               AttributeValueTests.class, EnumValueTests.class,
               CollectionOfModelValuesTests.class,
               ModelElementTests.class})
public class EmcWrappersSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(EmcWrappersSuite.class);
	}
}
