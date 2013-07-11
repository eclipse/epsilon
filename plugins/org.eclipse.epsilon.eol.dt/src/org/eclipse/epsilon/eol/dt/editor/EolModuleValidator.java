package org.eclipse.epsilon.eol.dt.editor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.IModuleValidator;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.common.module.ModuleMarker.Severity;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.parse.EolParser;

public class EolModuleValidator implements IModuleValidator {
	
	protected boolean appliesTo(IModule module) {
		return module.getClass() == EolModule.class;
	}
	
	@Override
	public List<ModuleMarker> validate(IModule module) {
		if (!appliesTo(module)) return Collections.emptyList();
		
		ArrayList<ModuleMarker> markers = new ArrayList<ModuleMarker>();
		
		// Fix for bug #393988
		AST firstHelper = null;
		
		for (AST ast : module.getAst().getChildren()) {
			if (ast.getType() != EolParser.HELPERMETHOD && ast.getType() != EolParser.BLOCK) {
				if (firstHelper != null) {
					markers.add(new ModuleMarker(null, ast.getRegion(), "All statements after the first operation will be ignored at runtime.", Severity.Warning));
				}
			}
			else if (ast.getType() == EolParser.HELPERMETHOD) {
				if (firstHelper == null) firstHelper = ast;
			}
		}
		
		return markers;
		
	}
	
}
