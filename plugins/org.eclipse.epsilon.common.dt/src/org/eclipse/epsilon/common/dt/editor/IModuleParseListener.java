package org.eclipse.epsilon.common.dt.editor;

import org.eclipse.epsilon.commons.module.IModule;

public interface IModuleParseListener {
	
	public void moduleParsed(AbstractModuleEditor editor, IModule module);
	
}
