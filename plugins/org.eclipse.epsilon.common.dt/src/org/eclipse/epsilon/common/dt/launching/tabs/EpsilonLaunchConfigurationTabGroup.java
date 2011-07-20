package org.eclipse.epsilon.common.dt.launching.tabs;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

public abstract class EpsilonLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup{

		public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
			ILaunchConfigurationTab[] tabs = 
				new ILaunchConfigurationTab[]{
					getSourceConfigurationTab(),
					new ModelsConfigurationTab(),
					//new ProfilingConfigurationTab(),
					new CommonTab()
					};
			setTabs(tabs);
		}
		
		public abstract ILaunchConfigurationTab getSourceConfigurationTab();
		
}