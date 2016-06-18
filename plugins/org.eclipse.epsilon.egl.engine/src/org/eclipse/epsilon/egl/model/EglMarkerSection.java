package org.eclipse.epsilon.egl.model;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;


public class EglMarkerSection extends EglSection {
	
	protected String text;
	
	@Override
	public void build(AST cst, IModule module) {
		text = cst.getFirstChild().getText();
	}
	
	@Override
	public String toString() {
		return text;
	}
	
}
