package org.eclipse.epsilon.ewl.dt.editor.outline;

import java.util.List;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.dt.editor.outline.EolModuleContentProvider;
import org.eclipse.epsilon.ewl.EwlModule;

public class EwlModuleContentProvider extends EolModuleContentProvider {
	
	@Override
	public List<ModuleElement> getVisibleChildren(ModuleElement moduleElement) {
		List<ModuleElement> visible = super.getVisibleChildren(moduleElement);
		
		if (moduleElement.getClass() == EwlModule.class) {
			EwlModule module = (EwlModule) moduleElement;
			visible.addAll(module.getImports());
			visible.addAll(module.getDeclaredModelDeclarations());
			visible.addAll(module.getWizards());
			visible.addAll(module.getDeclaredOperations());
		}
		
		return visible;
	}
	
}
