package org.eclipse.epsilon.eol.dt.launching;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.epsilon.eol.IEolExecutableModule;

public interface EpsilonLaunchConfigurationDelegateListener {
	
	public void aboutToParse(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor progressMonitor, IEolExecutableModule module) throws Exception;
	
	public void aboutToExecute(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor progressMonitor, IEolExecutableModule module) throws Exception;
	
	public void executed(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor progressMonitor, IEolExecutableModule module, Object result) throws Exception;
	
}
