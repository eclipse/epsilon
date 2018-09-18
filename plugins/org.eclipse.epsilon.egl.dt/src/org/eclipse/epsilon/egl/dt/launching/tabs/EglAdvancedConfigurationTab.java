/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* Contributors:
*     Horacio Hoyos - initial API and implementation
**********************************************************************/
package org.eclipse.epsilon.egl.dt.launching.tabs;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.launching.extensions.ModuleImplementationExtension;
import org.eclipse.epsilon.common.dt.launching.tabs.AbstractAdvancedConfigurationTab;
import org.eclipse.epsilon.egl.dt.EglPlugin;
import org.eclipse.epsilon.egl.dt.launching.EglLaunchConfigurationDelegate;

/**
 * The Class EglAdvancedConfigurationTab.
 * @since 1.6
 * @author Horacio Hoyos Rodriguez
 */
public class EglAdvancedConfigurationTab extends AbstractAdvancedConfigurationTab {
	
	@Override
	public EpsilonPlugin getPlugin() {
		return EglPlugin.getDefault();
	}
	
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		super.initializeFrom(configuration);
	}
	
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);
		String language;
		try {
			language = EglLaunchConfigurationDelegate.getImplementationFromSource(configuration);
			configuration.setAttribute(IMPL_NAME, language);
		} catch (CoreException e) {
			System.err.println("Unable to save implementation name.");
		}
		
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	
	}

	@Override
	public String getLanguage(ILaunchConfiguration configuration) {
		return EglLaunchConfigurationDelegate.getLanguageFromSource(configuration);
	}
	
	@Override
	public List<String> getImplementations(ILaunchConfiguration configuration) {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = registry.getExtensionPoint("org.eclipse.epsilon.common.dt.moduleImplementation");
		IConfigurationElement[] configurationElements =  extensionPoint.getConfigurationElements();
		String language = getLanguage(configuration);
		for (int i=0;i<configurationElements.length; i++){
			IConfigurationElement configurationElement = configurationElements[i];
			String configLanguage = configurationElement.getAttribute("language");
			if (configLanguage.equals(language)) {	
				ModuleImplementationExtension moduleType = null;
				moduleType = new ModuleImplementationExtension(configurationElement);
				getImplementations().put(moduleType.getName(), moduleType);
			}
		}
		// For EGL/EGX, if an unknown extension is used, we add all EGL and EGX implementations.
		if (getImplementations().isEmpty()) {
			for (int i=0;i<configurationElements.length; i++){
				IConfigurationElement configurationElement = configurationElements[i];
				String configLanguage = configurationElement.getAttribute("language");
				if (configLanguage.equals("EGL") || configLanguage.equals("EGX")) {	
					ModuleImplementationExtension moduleType = null;
					moduleType = new ModuleImplementationExtension(configurationElement);
					getImplementations().put(moduleType.getName(), moduleType);
				}
			}
		}
		return getImplementations().values().stream().sorted(new Comparator<ModuleImplementationExtension>() {

			@Override
			public int compare(ModuleImplementationExtension o1, ModuleImplementationExtension o2) {
				if (o1.isDefault()) {
					return -1;
				}
				if (o2.isDefault()) {
					return 1;
				}
				return 0;
			}
				})
				.map(i -> i.getName())
				.collect(Collectors.toList());
	}
	
	
}
