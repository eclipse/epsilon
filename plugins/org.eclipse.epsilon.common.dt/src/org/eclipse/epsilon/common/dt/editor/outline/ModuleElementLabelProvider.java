/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.common.dt.editor.outline;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;


public abstract class ModuleElementLabelProvider implements ILabelProvider {
	
	public abstract Image getImage(Object element);

	public String getText(Object element) {
		//ModuleElement el = (ModuleElement) element;
		//Visitor v = new Visitor();
		//v.visit(el.getAst());
		//return "(" + v.startLine + ":" + v.startColumn + "-" + v.endLine + ":" + v.endColumn + ") " + el.toString();
		return String.valueOf(element);
	}

	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}
	
	
	class Visitor {
		public int startLine = 0;
		public int startColumn = 0;
		public int endLine = 0;
		public int endColumn = 0;
		
		protected void visit(AST ast){
			if (ast == null) return;
			if (ast.getLine() < startLine ||
					(ast.getLine() == startLine 
							&& ast.getColumn() < startColumn)) {
				startLine = ast.getLine();
				startColumn = ast.getColumn();
			}
			if (ast.getLine() > endLine ||
					(ast.getLine() == endLine 
							&& ast.getColumn() > endColumn)) {
				endLine = ast.getLine();
				endColumn = ast.getColumn();
			}		
			AST child = ast.getFirstChild();
			while (ast!=null){
				visit(child);
				ast = ast.getNextSibling();
			}
		}
	}
}
