/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.common.dt.editor.hyperlinks;

import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;

public class ASTHyperlink implements IHyperlink {

	protected IRegion region;
	protected AST targetAST;
	protected String label;
	
	public ASTHyperlink(IRegion region, AST targetAST, String label) {
		this.region = region;
		this.targetAST = targetAST;
		this.label = label;
	}
	
	public IRegion getHyperlinkRegion() {
		return region;
	}

	public String getTypeLabel() {
		return label;
	}

	public String getHyperlinkText() {
		return label; //ast.getText();
	}

	public void open() {
		EclipseUtil.openEditorAt(targetAST.getFile(), targetAST.getLine(), targetAST.getColumn(), false);
	}
	

	
}
