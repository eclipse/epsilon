package org.eclipse.epsilon.common.dt.editor.outline;

import org.eclipse.epsilon.common.dt.EpsilonCommonsPlugin;
import org.eclipse.epsilon.common.dt.editor.outline.ModuleElementLabelProvider;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.swt.graphics.Image;

public class AstModuleElementLabelProvider extends ModuleElementLabelProvider {

	@Override
	public String getText(Object element) {
		AST ast = (AST) element;
		String label = ast.getText() + " " + ast.getRegion().getStart().toString() + " -> " + ast.getRegion().getEnd().toString();
		return label;
	}
	
	@Override
	public Image getImage(Object element) {
		return EpsilonCommonsPlugin.getDefault().createImage("icons/element.gif");
	}
	
}
