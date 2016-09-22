package org.eclipse.epsilon.edl.dt.editor.outline;

import java.util.List;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.edl.EdlModule;
import org.eclipse.epsilon.edl.ProcessRule;
import org.eclipse.epsilon.eol.dt.editor.outline.EolModuleContentProvider;

public class EdlModuleContentProvider extends EolModuleContentProvider {
	
	@Override
	public ModuleElement getFocusedModuleElement(ModuleElement moduleElement) {
		
		if (moduleElement instanceof ProcessRule) {
			return ((ProcessRule) moduleElement).getParameter();
		}
		
		return super.getFocusedModuleElement(moduleElement);
	}
	
	@Override
	public List<ModuleElement> getVisibleChildren(ModuleElement moduleElement) {
		List<ModuleElement> visible = super.getVisibleChildren(moduleElement);
		
		if (moduleElement.getClass() == EdlModule.class) {
			EdlModule module = (EdlModule) moduleElement;
			visible.addAll(module.getImports());
			visible.addAll(module.getDeclaredModelDeclarations());
			visible.addAll(module.getDeclaredProcessRules());
			visible.addAll(module.getDeclaredOperations());
		}		
		
		return visible;
	}
	
}
