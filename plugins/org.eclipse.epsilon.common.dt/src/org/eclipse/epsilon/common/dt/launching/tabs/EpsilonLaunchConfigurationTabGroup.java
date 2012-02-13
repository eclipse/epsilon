package org.eclipse.epsilon.common.dt.launching.tabs;

import java.util.ArrayList;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

public abstract class EpsilonLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup{

		public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
			
			ArrayList<ILaunchConfigurationTab> tabList = new ArrayList<ILaunchConfigurationTab>();
			for (ILaunchConfigurationTab tab : getSourceConfigurationTabs()) {
				tabList.add(tab);
			}
			tabList.add(new ModelsConfigurationTab());
			tabList.add(new CommonTab());
			
			ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[tabList.size()];
			int i = 0;
			for (ILaunchConfigurationTab tab : tabList) {
				tabs[i] = tab;
				i++;
			}
			
			setTabs(tabs);
		}
		
		public abstract ILaunchConfigurationTab getSourceConfigurationTab();
		
		public ILaunchConfigurationTab[] getSourceConfigurationTabs() {
			return new ILaunchConfigurationTab[]{getSourceConfigurationTab()};
		}
}