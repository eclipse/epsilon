package org.eclipse.epsilon.common.dt.editor.hyperlinks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.epsilon.common.dt.editor.ASTLocation;
import org.eclipse.epsilon.common.dt.editor.ASTLocator;
import org.eclipse.epsilon.common.dt.editor.AbstractModuleEditor;
import org.eclipse.epsilon.common.dt.editor.IModuleParseListener;
import org.eclipse.epsilon.commons.module.IModule;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;

public class AbstractModuleEditorHyperlinkDetector implements IHyperlinkDetector, IModuleParseListener {

	protected AbstractModuleEditor editor;
	protected HashMap<AST, IRegion> astRegions = new HashMap<AST, IRegion>();
	protected IEolExecutableModule module = null;
	protected ASTLocator astLocator = null;
	
	public List<IHyperlink> createHyperlinks(AST ast) {
		
		ArrayList<IHyperlink> hyperlinks = new ArrayList<IHyperlink>();
		
		for (Object op : module.getOperations()) {
			EolOperation operation = (EolOperation) op;
			if (operation.getName().equals(ast.getText()) && operation.getFormalParameters().size() == ast.getFirstChild().getChildren().size()) {
				AST operationAst = operation.getAst();
				hyperlinks.add(new ASTHyperlink(astRegions.get(ast), operationAst, astLocator, operation.toString()));
			}
		}
		
		if (hyperlinks.isEmpty()) {
			for (Object op : module.getOperations()) {
				EolOperation operation = (EolOperation) op;
			
				if (operation.getName().equals(ast.getText())) {
					AST operationAst = operation.getAst();
					hyperlinks.add(new ASTHyperlink(astRegions.get(ast), operationAst, astLocator, operation.toString()));
				}
			}	
		}
		
		return hyperlinks;
	}

	public IHyperlink[] detectHyperlinks(ITextViewer textViewer,
			IRegion region, boolean canShowMultipleHyperlinks) {
		
		for (AST ast : astRegions.keySet()) {
			IRegion candidateRegion = astRegions.get(ast);
			
			if (region.getOffset() < candidateRegion.getOffset() + candidateRegion.getLength() 
					&& region.getOffset() > candidateRegion.getOffset()) {
				
				List<IHyperlink> hyperlinkList = createHyperlinks(ast);
				IHyperlink[] hyperlinks = new IHyperlink[hyperlinkList.size()];
				int i = 0;
				for (IHyperlink hyperlink : hyperlinkList) {
					hyperlinks[i] = hyperlink;
					i++;
				}
				if (hyperlinks.length > 0) return hyperlinks;
			}
			
		}
		
		return null;
		
	}
	
	protected boolean isInteresting(AST ast) {
		return ast.getType() == EolParser.FEATURECALL && 
			ast.getFirstChild() != null;
	}

	public void moduleParsed(AbstractModuleEditor editor, IModule module) {
		astRegions.clear();
		this.editor = editor;
		this.module = (IEolExecutableModule) module;
		this.astLocator = editor.getASTLocator(module);
		findInterestingASTs(module.getAst());
	}
	
	protected void findInterestingASTs(AST ast) {
		
		if (ast == null) return;
		
		IDocument doc = editor.getDocumentProvider().getDocument(
				editor.getEditorInput());
		
		if (isInteresting(ast)) {
			try {
				ASTLocation astLocation = astLocator.getLocation(ast);
				int linkOffset = doc.getLineOffset(astLocation.getLine()-1) + astLocation.getColumn();
				astRegions.put(ast, new Region(linkOffset, ast.getText().length()));
			} catch (BadLocationException e) { }
		}
		
		for (Object child : ast.getChildren()) {
			if (child instanceof AST) {
				findInterestingASTs((AST) child);
			}
		}
	}
	
}
