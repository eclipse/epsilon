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
 
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolExecutableModule;

public class EolLaunchConfigurationDelegate extends EpsilonLaunchConfigurationDelegate {
	
	// TODO : Remove some duplication between LaunchConfigurationDelegates
//	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor progressMonitor) throws CoreException {
//		
//		EpsilonConsole.getInstance().clear();
//		
//		IEolModule module = createEolModule();
//		
//		if (!parse(module, EolLaunchConfigurationAttributes.SOURCE, configuration, mode, launch, progressMonitor)) return;
//		
//		EolDebugTarget target = null;
//		
//		try { 
//			EclipseContextManager.setup(module.getContext(),configuration, progressMonitor, launch);
//			String subtask = "Executing";
//			progressMonitor.subTask(subtask);
//			progressMonitor.beginTask(subtask, 100);
//			
//			if ("run".equalsIgnoreCase(mode)) {
//				module.execute();
//			}
//			else {
//				// Copy launch configuration attributes to launch
//				Map configurationAttributes = configuration.getAttributes();
//				for (Object key : configurationAttributes.keySet()) {
//					launch.setAttribute(key + "", configurationAttributes.get(key) + "");
//				}
//				
//				target = new EolDebugTarget(launch, module);
//				launch.addDebugTarget(target);
//				target.debug();
//			}
//			
//		} catch (EolRuntimeException e) {
//			e.printStackTrace();
//			module.getContext().getErrorStream().println(e.toString());
//			progressMonitor.setCanceled(true);
//		}
//		finally{
//			if (target != null) target.terminate();
//			EclipseContextManager.teardown(module.getContext());
//		}
//		
//		progressMonitor.done();
//	}
	
	@Override
	public IEolExecutableModule createModule() {
		return new EolModule();
	}
	
}
