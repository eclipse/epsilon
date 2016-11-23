/*******************************************************************************
 * Copyright (c) 2016 Aston University.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.examples.testlang.dt.launching;

import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.dt.launching.EolLaunchConfigurationDelegate;
import org.eclipse.epsilon.examples.testlang.engine.TestLangModule;

public class TestLangLaunchConfigurationDelegate extends EolLaunchConfigurationDelegate {

	@Override
	public IEolModule createModule() {
		return new TestLangModule();
	}

	
}
