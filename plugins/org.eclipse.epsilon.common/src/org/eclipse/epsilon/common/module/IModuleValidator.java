package org.eclipse.epsilon.common.module;

import java.util.List;


public interface IModuleValidator {
	
	public List<ModuleMarker> validate(IModule module);
	
}
