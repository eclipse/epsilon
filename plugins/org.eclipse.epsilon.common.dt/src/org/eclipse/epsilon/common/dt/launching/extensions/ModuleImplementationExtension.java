package org.eclipse.epsilon.common.dt.launching.extensions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.epsilon.common.dt.exceptions.EpsilonDtException;
import org.eclipse.epsilon.common.dt.launching.dialogs.AbtsractModuleConfigurationDialog;
import org.eclipse.epsilon.common.module.IModule;

/**
 * The Module Implementation Extension stores configuration information about existing module
 * implementations
 * 
 * @author Horacio Hoyos Rodriguez
 *
 */
public class ModuleImplementationExtension {
	
	/**
	 * Get the ModuleImplementationExtension for a specific implementation. ModuleImplementationExtensions
	 * created via this method also provide
	 * @param impl the name of the implementation
	 * @return the ModuleImplementationExtension or null if not found in the extension registry
	 */
	public static ModuleImplementationExtension forImplementation(String impl) {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = registry.getExtensionPoint("org.eclipse.epsilon.common.dt.moduleImplementation");
		IConfigurationElement[] configurationElements =  extensionPoint.getConfigurationElements();
		for (IConfigurationElement configurationElement : configurationElements){
			if (configurationElement.getAttribute("name").equals(impl)) {	
				ModuleImplementationExtension moduleType = null;
				moduleType = new ModuleImplementationExtension(configurationElement);
				return moduleType;
				
			}
		}
		return null;
	}
	
	public static ModuleImplementationExtension defaultImplementation() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = registry.getExtensionPoint("org.eclipse.epsilon.common.dt.moduleImplementation");
		IConfigurationElement[] configurationElements =  extensionPoint.getConfigurationElements();
		for (IConfigurationElement configurationElement : configurationElements){
			if (Boolean.parseBoolean(configurationElement.getAttribute("default"))) {	
				ModuleImplementationExtension moduleType = null;
				moduleType = new ModuleImplementationExtension(configurationElement);
				return moduleType;
			}
		}
		return null;
	}
	
	
	private final String clazz;
	private final String name;
	private final String language;
	private final IConfigurationElement configurationElement;
	private final String dialogClazz;

	public ModuleImplementationExtension(IConfigurationElement configurationElement) {
		super();
		this.clazz = configurationElement.getAttribute("class");
		this.name = configurationElement.getAttribute("name");;
		this.language = configurationElement.getAttribute("language");
		this.dialogClazz = configurationElement.getAttribute("dialog");
		this.configurationElement = configurationElement;
	}
	
	public String getClazz() {
		return clazz;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLanguage() {
		return language;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends AbtsractModuleConfigurationDialog> T createDialog() throws EpsilonDtException {
		try {
			return (T) configurationElement.createExecutableExtension("dialog");
		} catch (CoreException e) {
			throw new EpsilonDtException("Error creating configuraiton dialog for " + this.name, e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T extends IModule> T createModule() throws CoreException {
		return (T) configurationElement.createExecutableExtension("class");
	}

	
 }
