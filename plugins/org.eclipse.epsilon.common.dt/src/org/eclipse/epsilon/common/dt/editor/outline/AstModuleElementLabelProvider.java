/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
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
