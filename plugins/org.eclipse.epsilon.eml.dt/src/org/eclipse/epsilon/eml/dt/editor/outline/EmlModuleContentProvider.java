package org.eclipse.epsilon.eml.dt.editor.outline;

import java.util.List;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eml.EmlModule;
import org.eclipse.epsilon.etl.dt.editor.outline.EtlModuleContentProvider;

public class EmlModuleContentProvider extends EtlModuleContentProvider {
	
	@Override
	public List<ModuleElement> getVisibleChildren(ModuleElement moduleElement) {
		List<ModuleElement> visible = super.getVisibleChildren(moduleElement);
		
		if (moduleElement.getClass() == EmlModule.class) {
			EmlModule module = (EmlModule) moduleElement;
			visible.addAll(module.getImports());
			visible.addAll(module.getDeclaredModelDeclarations());
			visible.addAll(module.getDeclaredPre());
			visible.addAll(module.getDeclaredTransformationRules());
			visible.addAll(module.getDeclaredMergeRules());
			visible.addAll(module.getDeclaredPost());
			visible.addAll(module.getDeclaredOperations());
		}
		
		return visible;
	}
	
}
