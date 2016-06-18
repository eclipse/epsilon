package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;

public class AnnotationBlock extends AbstractModuleElement {
	
	protected List<Annotation> annotations = new ArrayList<Annotation>();
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		for (AST ast : cst.getChildren()) {
			annotations.add((Annotation) module.createAst(ast, this));
		}
	}
	
	public List<Annotation> getAnnotations() {
		return annotations;
	}
}
