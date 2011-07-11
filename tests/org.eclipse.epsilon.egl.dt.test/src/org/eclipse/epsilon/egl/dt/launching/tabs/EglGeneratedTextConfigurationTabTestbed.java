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
package org.eclipse.epsilon.egl.dt.launching.tabs;

import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.epsilon.common.dt.test.util.LaunchConfigurationTabTestBed;

public class EglGeneratedTextConfigurationTabTestbed extends LaunchConfigurationTabTestBed {

	@Override
	protected ILaunchConfigurationTab getLaunchConfigurationTab() {
		return new EglGeneratedTextConfigurationTab();
	}
	
	public static void main(String[] args) {
		new EglGeneratedTextConfigurationTabTestbed().run();
	}
}
