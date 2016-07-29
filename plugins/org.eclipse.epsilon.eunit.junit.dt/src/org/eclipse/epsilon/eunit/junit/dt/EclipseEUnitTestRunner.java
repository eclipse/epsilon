/*******************************************************************************
 * Copyright (c) 2012-2016 Antonio Garcia-Dominguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eunit.junit.dt;

import org.eclipse.core.runtime.Platform;
import org.eclipse.epsilon.eol.dt.launching.EclipseContextManager;
import org.eclipse.epsilon.eol.userinput.JavaConsoleUserInput;
import org.junit.runners.model.InitializationError;

/**
 * Specialization of {@link EUnitTestRunner} for running within Eclipse.
 */
public class EclipseEUnitTestRunner extends EUnitTestRunner {

	public EclipseEUnitTestRunner(Class<? extends IEUnitSuite> testClass) throws InitializationError {
		super(testClass);
		if (Platform.getExtensionRegistry() != null) {
			EclipseContextManager.setup(module.getContext());

			// Disable notification through dialogs: it's bad for automated test cases.
			// Use the console instead.
			module.getContext().setUserInput(new JavaConsoleUserInput());
		}
	}
}
