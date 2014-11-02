package org.eclipse.epsilon.common.dt.editor.outline;

import org.antlr.runtime.CommonToken;
import org.eclipse.epsilon.common.dt.EpsilonCommonsPlugin;
import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.swt.graphics.Image;

public class AstModuleElementLabelProvider extends ModuleElementLabelProvider {

	@Override
	public String getText(Object element) {
		if (element instanceof AST) {
			AST ast = (AST) element;
			String debugInfo = "";
			if (element instanceof AbstractModuleElement) {
				debugInfo = ((AbstractModuleElement) element).getDebugInfo();
				if (debugInfo.length() > 0) debugInfo += " ";
			}
			return debugInfo + "(" + ast.getClass().getSimpleName() + 
					") " + ast.getText() + " " + 
					ast.getRegion().getStart().toString() + " -> " 
					+ ast.getRegion().getEnd().toString();
		}
		else if (element instanceof CommonToken) {
			return ((CommonToken) element).getText();
		}
		else {
			return element + "";
		}
	}
	
	@Override
	public Image getImage(Object element) {
		return EpsilonCommonsPlugin.getDefault().createImage("icons/element.gif");
	}
	
}
