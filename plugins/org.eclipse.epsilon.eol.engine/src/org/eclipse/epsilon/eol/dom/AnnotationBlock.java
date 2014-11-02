package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.parse.AST;

public class AnnotationBlock extends AbstractModuleElement {
	
	protected List<Annotation> annotations = new ArrayList<Annotation>();
	
	@Override
	public void build() {
		super.build();
		for (AST ast : getChildren()) {
			annotations.add((Annotation) ast);
		}
	}
	
	public List<Annotation> getAnnotations() {
		return annotations;
	}
}
