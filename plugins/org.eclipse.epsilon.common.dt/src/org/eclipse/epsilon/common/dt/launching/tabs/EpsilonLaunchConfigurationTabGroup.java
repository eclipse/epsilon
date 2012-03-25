package org.eclipse.epsilon.common.dt.launching.tabs;

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.epsilon.common.dt.util.LogUtil;

public abstract class EpsilonLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup{
		
		public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
			
			
			
			ArrayList<ILaunchConfigurationTab> tabList = new ArrayList<ILaunchConfigurationTab>();
			for (ILaunchConfigurationTab tab : getSourceConfigurationTabs()) {
				tabList.add(tab);
			}
			
			tabList.add(new ModelsConfigurationTab());
			
			for (ILaunchConfigurationTab tab : getOtherConfigurationTabs()) {
				tabList.add(tab);
			}
			
			IExtensionRegistry registry = Platform.getExtensionRegistry();
			IExtensionPoint extensionPoint = registry.getExtensionPoint("org.eclipse.epsilon.eol.dt.launchConfigurationExtension");
			IConfigurationElement[] configurationElements =  extensionPoint.getConfigurationElements();
			for (int i=0;i<configurationElements.length; i++){
				IConfigurationElement configurationElement = configurationElements[i];
				
				try {
					EpsilonLaunchConfigurationTabContributor contributor = (EpsilonLaunchConfigurationTabContributor) configurationElement.createExecutableExtension("tabContributor");
					for(ILaunchConfigurationTab tab : contributor.getTabs(this, dialog, mode)) {
						tabList.add(tab);
					}
				}
				catch (CoreException e) {
					LogUtil.log(e);
				}
			}
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
		
		public ILaunchConfigurationTab[] getOtherConfigurationTabs() {
			return new ILaunchConfigurationTab[]{};
		}
}