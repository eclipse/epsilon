package org.eclipse.epsilon.profiling.dt;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dt.launching.EolLaunchConfigurationAttributes;
import org.eclipse.epsilon.eol.dt.launching.EpsilonLaunchConfigurationDelegate;
import org.eclipse.epsilon.eol.dt.launching.EpsilonLaunchConfigurationDelegateListener; 
import org.eclipse.epsilon.profiling.Profiler;
import org.eclipse.epsilon.profiling.ProfilingExecutionListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

public class ProfilingLaunchConfigurationListener implements
		EpsilonLaunchConfigurationDelegateListener {
	
	protected boolean profilingEnabled = false;
	
	public ProfilingLaunchConfigurationListener() {
		
	}

	@Override
	public void aboutToParse(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor progressMonitor,
			IEolExecutableModule module) throws CoreException {
		
		
	}

	@Override
	public void aboutToExecute(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor progressMonitor,
			IEolExecutableModule module) throws Exception {
		
		profilingEnabled = configuration.getAttribute(ProfilingLaunchConfigurationAttributes.PROFILING_ENABLED, false);
		boolean resetProfiler = configuration.getAttribute(ProfilingLaunchConfigurationAttributes.RESET_PROFILER, false);
		boolean fineGrainedProfiling = configuration.getAttribute(ProfilingLaunchConfigurationAttributes.FINE_GRAINED_PROFILING, false);
		
		if (profilingEnabled) {
			
			if (resetProfiler) {
				Profiler.INSTANCE.reset();
			}
			
			Profiler.INSTANCE.start(configuration.getAttribute(EolLaunchConfigurationAttributes.SOURCE, ""));
			
			if (fineGrainedProfiling) {
				module.getContext().getExecutorFactory().addExecutionListener(new ProfilingExecutionListener());
			}
		}
	}

	@Override
	public void executed(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor progressMonitor,
			IEolExecutableModule module, Object result) throws Exception {
		
		if (profilingEnabled) {
			
			Profiler.INSTANCE.stop(configuration.getAttribute(EolLaunchConfigurationAttributes.SOURCE, ""));
			
			Profiler.INSTANCE.refresh();
			
			Display.getDefault().asyncExec(new Runnable() {
				
				@Override
				public void run() {
					try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.eclipse.epsilon.profiling.dt.ProfilerView");
					}
					catch (Exception ex) {ex.printStackTrace();}
				}
				
			});
		}
		
	}
	
	

}
