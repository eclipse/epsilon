package org.eclipse.epsilon.ecl.dt.editor.outline;

import java.util.List;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.ecl.EclModule;
import org.eclipse.epsilon.erl.dt.editor.outline.ErlModuleContentProvider;

public class EclModuleContentProvider extends ErlModuleContentProvider {
	
	@Override
	public List<ModuleElement> getVisibleChildren(ModuleElement moduleElement) {
		List<ModuleElement> visible = super.getVisibleChildren(moduleElement);
		
		if (moduleElement.getClass() == EclModule.class) {
			EclModule module = (EclModule) moduleElement;
			visible.addAll(module.getImports());
			visible.addAll(module.getDeclaredModelDeclarations());
			visible.addAll(module.getDeclaredPre());
			visible.addAll(module.getDeclaredMatchRules());
			visible.addAll(module.getDeclaredPost());
			visible.addAll(module.getDeclaredOperations());
		}
		
		return visible;
	}
	
}
