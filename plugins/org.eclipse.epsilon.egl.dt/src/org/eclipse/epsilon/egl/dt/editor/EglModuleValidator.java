package org.eclipse.epsilon.egl.dt.editor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.dt.editor.AbstractModuleValidator;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.IModuleValidator;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.common.module.ModuleMarker.Severity;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.eol.parse.EolParser;

public class EglModuleValidator extends AbstractModuleValidator implements IModuleValidator {
	
	@Override
	public List<ModuleMarker> validate(IModule module) {
		if (!appliesTo(module)) return Collections.emptyList();
		
		ArrayList<ModuleMarker> markers = new ArrayList<ModuleMarker>();
		
		// Fix for bug #393988
		AST firstHelper = null;
		
		for (AST ast : module.getAst().getChildren()) {
			if (ast.getType() != EolParser.HELPERMETHOD && ast.getType() != EolParser.BLOCK && ast.getType() != EolParser.ANNOTATIONBLOCK) {
				if (firstHelper != null && !isEmptyPrintStatement(ast)) {
					markers.add(new ModuleMarker(null, firstHelper.getRegion(), "All loose statements and textual content after the first operation will be ignored at runtime.", Severity.Warning));
				}
			}
			else if (ast.getType() == EolParser.HELPERMETHOD) {
				if (firstHelper == null) firstHelper = ast;
			}
		}
		
		return markers;
		
	}
	
	protected boolean appliesTo(IModule module) {
		return module instanceof EglTemplateFactoryModuleAdapter;
	}
	
	protected boolean isEmptyPrintStatement(AST ast) {
		if (ast.getText().equals(".") && ast.getChild(0).getText().equals("out") && ast.getChild(1).getText().equals("print")) {
			String text = ast.getChild(1).getFirstChild().getFirstChild().getText();
			return text.trim().equals("\\n") || text.trim().isEmpty();
		}
		return false;
	}

}
