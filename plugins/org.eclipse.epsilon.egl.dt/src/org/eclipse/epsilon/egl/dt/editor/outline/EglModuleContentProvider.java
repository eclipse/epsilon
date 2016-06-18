package org.eclipse.epsilon.egl.dt.editor.outline;

import java.util.List;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.eol.dt.editor.outline.EolModuleContentProvider;

public class EglModuleContentProvider extends EolModuleContentProvider {
	
	@Override
	public List<ModuleElement> getVisibleChildren(ModuleElement moduleElement) {
		List<ModuleElement> visible = super.getVisibleChildren(moduleElement);
		
		if (moduleElement.getClass() == EglTemplateFactoryModuleAdapter.class) {
			EglTemplateFactoryModuleAdapter module = (EglTemplateFactoryModuleAdapter) moduleElement;
			visible.addAll(module.getImports());
			visible.addAll(module.getDeclaredModelDeclarations());
			visible.addAll(module.getCurrentTemplate().getModule().getMarkers());
			visible.addAll(module.getDeclaredOperations());
			
		}
		
		return visible;
	}
	
}
