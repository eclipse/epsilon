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
import org.eclipse.epsilon.commons.util.ReflectionUtil;

public class EolLaunchConfigurationMigrationDelegate implements
		ILaunchConfigurationMigrationDelegate {

	public boolean isCandidate(ILaunchConfiguration candidate)
			throws CoreException {
		
		//System.err.println(candidate.getType().getName());
		
		//ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
		
		//LaunchConfigurationInfo lci = (LaunchConfigurationInfo) ReflectionUtil.invokeMethodSafe(candidate, "getInfo", new ArrayList<Object>());
		
		
		//for (Object key : candidate.getAttributes().keySet()) {
		//	System.err.println(key + " -> " + candidate.getAttributes().get(key));
		//}
		
		return true;
	}

	public void migrate(ILaunchConfiguration candidate) throws CoreException {
		// TODO Auto-generated method stub
		
		ILaunchConfigurationWorkingCopy wc = candidate.getWorkingCopy();
		
		//LaunchConfigurationWorkingCopy x;
		
		
		
		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
		
		ILaunchConfigurationType type = manager.getLaunchConfigurationType("org.eclipse.epsilon.eol.dt.launching.EolLaunchConfigurationDelegate");
		
		//System.err.println(type);
		
		// Info is LaunchConfigurationInfo
		Object info = null;
		try {
			info = ReflectionUtil.invokeMethod(wc, "getInfo", new ArrayList<Object>());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add(type);
		try {
			ReflectionUtil.invokeMethod(info, "setType", parameters);
			System.err.println(
					ReflectionUtil.invokeMethod(info, "getType", new ArrayList<Object>())
			);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		wc.doSave();
		
		
		
	}

}
