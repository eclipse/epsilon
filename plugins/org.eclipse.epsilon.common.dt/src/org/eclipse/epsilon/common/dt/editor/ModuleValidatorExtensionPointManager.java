package org.eclipse.epsilon.common.dt.editor;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.epsilon.common.dt.extensions.ExtensionPointManager;
import org.eclipse.epsilon.common.module.IModuleValidator;

public class ModuleValidatorExtensionPointManager extends ExtensionPointManager<IModuleValidator>{
	
	public static ModuleValidatorExtensionPointManager getDefault() {
		if (managers.get(ModuleValidatorExtensionPointManager.class) == null) {
			managers.put(ModuleValidatorExtensionPointManager.class, new ModuleValidatorExtensionPointManager());
		}
		return (ModuleValidatorExtensionPointManager) managers.get(ModuleValidatorExtensionPointManager.class);
	}
	
	@Override
	protected IModuleValidator parse(IConfigurationElement element) throws Exception {
		return (IModuleValidator) element.createExecutableExtension("class");
	}

	@Override
	protected String getExtensionPointId() {
		return "org.eclipse.epsilon.common.dt.moduleValidator";
	}

}
