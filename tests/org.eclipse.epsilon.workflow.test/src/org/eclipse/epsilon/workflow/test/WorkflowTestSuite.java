/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.test;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.eclipse.epsilon.workflow.tasks.AntLibTests;
import org.eclipse.epsilon.workflow.tasks.LoadModelTaskTests;
import org.eclipse.epsilon.workflow.tasks.emf.LoadModelTests;
import org.eclipse.epsilon.workflow.tasks.eunit.EUnitBasicTests;
import org.eclipse.epsilon.workflow.tasks.eunit.EUnitInlineModelTests;
import org.eclipse.epsilon.workflow.tasks.eunit.EUnitWithEGLTests;
import org.eclipse.epsilon.workflow.tasks.eunit.EUnitWithEVLTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({LoadModelTaskTests.class,
               LoadModelTests.class,
               AntLibTests.class,
               EUnitBasicTests.class,
               EUnitWithEVLTests.class,
               EUnitWithEGLTests.class,
               EUnitInlineModelTests.class})
public class WorkflowTestSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(WorkflowTestSuite.class);
	}
}
