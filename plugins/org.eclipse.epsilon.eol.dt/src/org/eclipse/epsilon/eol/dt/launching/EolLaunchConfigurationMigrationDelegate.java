/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.dt.launching;

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationMigrationDelegate;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.common.util.ReflectionUtil;

public class EolLaunchConfigurationMigrationDelegate implements
		ILaunchConfigurationMigrationDelegate {

	public boolean isCandidate(ILaunchConfiguration candidate)
			throws CoreException {
		
		return true;
	}

	public void migrate(ILaunchConfiguration candidate) throws CoreException {
		ILaunchConfigurationWorkingCopy wc = candidate.getWorkingCopy();
		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType type = manager.getLaunchConfigurationType("org.eclipse.epsilon.eol.dt.launching.EolLaunchConfigurationDelegate");
		
		// Info is LaunchConfigurationInfo
		Object info = null;
		try {
			info = ReflectionUtil.invokeMethod(wc, "getInfo", new ArrayList<Object>());
		} catch (Exception e1) {
			LogUtil.log(e1);
		}
		
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add(type);
		try {
			ReflectionUtil.invokeMethod(info, "setType", parameters);
			ReflectionUtil.invokeMethod(info, "getType", new ArrayList<Object>());
		} catch (Exception e) {
			LogUtil.log(e);
		}
		
		wc.doSave();
		
		
		
	}

}
