/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.common.dt.editor.hyperlinks;

import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;

public class ASTHyperlink implements IHyperlink {

	protected IRegion region;
	protected ModuleElement targetAST;
	protected String label;
	
	public ASTHyperlink(IRegion region, ModuleElement targetAST, String label) {
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
		EclipseUtil.openEditorAt(targetAST);
	}
	

	
}
