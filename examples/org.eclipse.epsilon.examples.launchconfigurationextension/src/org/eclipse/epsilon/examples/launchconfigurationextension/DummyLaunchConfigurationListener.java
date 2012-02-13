package org.eclipse.epsilon.examples.launchconfigurationextension;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.epsilon.eol.dt.launching.EpsilonLaunchConfigurationDelegateListener;
import org.eclipse.epsilon.eol.IEolExecutableModule;

public class DummyLaunchConfigurationListener implements EpsilonLaunchConfigurationDelegateListener {

	@Override
	public void aboutToParse(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor progressMonitor,
			IEolExecutableModule module) throws CoreException {
		module.getContext().getOutputStream().println("about to parse...");
	}

	@Override
	public void aboutToExecute(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor progressMonitor,
			IEolExecutableModule module) throws Exception {
		module.getContext().getOutputStream().println("about to execute...");
	}

	@Override
	public void executed(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor progressMonitor,
			IEolExecutableModule module, Object result) throws Exception {
		module.getContext().getOutputStream().println("executed.");
		
	}

}
