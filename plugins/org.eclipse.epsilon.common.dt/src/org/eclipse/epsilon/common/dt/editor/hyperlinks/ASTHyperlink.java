package org.eclipse.epsilon.common.dt.editor.hyperlinks;

import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;

public class ASTHyperlink implements IHyperlink {

	protected IRegion region;
	protected AST ast;
	protected AST targetAST;
	protected String label;
	
	public ASTHyperlink(IRegion region, AST ast, AST targetAST, String label) {
		this.region = region;
		this.ast = ast;
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
