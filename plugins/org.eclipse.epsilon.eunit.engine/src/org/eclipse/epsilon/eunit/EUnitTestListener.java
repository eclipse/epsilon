/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eunit;

/**
 * Simple interface for objects which receive notifications regarding the
 * progress of a test suite.
 *
 * @author Antonio García-Domínguez
 * @version 1.0
 */
public interface EUnitTestListener {

	String EXTENSION_POINT_ID = "org.eclipse.epsilon.workflow.eunit.listener";

	/**
	 * Notification sent before running a test case.
	 * @param module EUnit module under execution.
	 * @param test Description of the test case: its result has not been set yet.
	 */
	void beforeCase(EUnitModule module, EUnitTest test);

	/**
	 * Notification sent after running a test case.
	 * @param module EUnit module under execution.
	 * @param test Test case, with its result set.
	 */
	void afterCase(EUnitModule module, EUnitTest test);

}
