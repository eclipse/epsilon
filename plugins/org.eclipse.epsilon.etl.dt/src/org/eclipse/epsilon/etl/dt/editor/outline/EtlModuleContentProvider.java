package org.eclipse.epsilon.etl.dt.editor.outline;

import java.util.List;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.erl.dt.editor.outline.ErlModuleContentProvider;
import org.eclipse.epsilon.etl.EtlModule;

public class EtlModuleContentProvider extends ErlModuleContentProvider {
	
	@Override
	public List<ModuleElement> getVisibleChildren(ModuleElement moduleElement) {
		List<ModuleElement> visible = super.getVisibleChildren(moduleElement);
		
		if (moduleElement.getClass() == EtlModule.class) {
			EtlModule module = (EtlModule) moduleElement;
			visible.addAll(module.getImports());
			visible.addAll(module.getDeclaredModelDeclarations());
			visible.addAll(module.getDeclaredPre());
			visible.addAll(module.getDeclaredTransformationRules());
			visible.addAll(module.getDeclaredPost());
			visible.addAll(module.getDeclaredOperations());
		}
		
		return visible;
	}
	
}
