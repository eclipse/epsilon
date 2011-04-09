package org.eclipse.epsilon.common.dt.editor.hyperlinks;

import org.eclipse.epsilon.common.dt.editor.ASTLocation;
import org.eclipse.epsilon.common.dt.editor.ASTLocator;
import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;

public class ASTHyperlink implements IHyperlink {

	protected IRegion region;
	protected AST targetAST;
	protected String label;
	protected ASTLocator astLocator;
	
	public ASTHyperlink(IRegion region, AST targetAST, ASTLocator astLocator, String label) {
		this.region = region;
		this.targetAST = targetAST;
		this.label = label;
		this.astLocator = astLocator;
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
		ASTLocation targetLocation = astLocator.getLocation(targetAST);
		EclipseUtil.openEditorAt(targetAST.getFile(), targetLocation.getLine(), targetLocation.getColumn(), false);
	}
	

	
}
