package org.eclipse.epsilon.epl.dt.editor.outline;

import java.util.List;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.epl.EplModule;
import org.eclipse.epsilon.epl.dom.Pattern;
import org.eclipse.epsilon.erl.dt.editor.outline.ErlModuleContentProvider;

public class EplModuleContentProvider extends ErlModuleContentProvider {
	
	@Override
	public List<ModuleElement> getVisibleChildren(ModuleElement moduleElement) {
		List<ModuleElement> visible = super.getVisibleChildren(moduleElement);
		
		if (moduleElement.getClass() == EplModule.class) {
			EplModule module = (EplModule) moduleElement;
			visible.addAll(module.getImports());
			visible.addAll(module.getDeclaredModelDeclarations());
			visible.addAll(module.getDeclaredPre());
			visible.addAll(module.getDeclaredPatterns());
			visible.addAll(module.getDeclaredPost());
			visible.addAll(module.getDeclaredOperations());
		}
		
		return visible;
	}
	
	@Override
	public ModuleElement getFocusedModuleElement(ModuleElement moduleElement) {
		if (moduleElement instanceof Pattern) {
			return ((Pattern) moduleElement).getNameExpression();
		}
		return super.getFocusedModuleElement(moduleElement);
	}
	
}
