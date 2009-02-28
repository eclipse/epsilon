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
package org.eclipse.epsilon.common.dt.editor;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;

import org.eclipse.epsilon.common.dt.editor.contentassist.AbstractModuleEditorCompletionProcessor;
import org.eclipse.epsilon.commons.module.IModule;
import org.eclipse.epsilon.commons.module.ModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IWhitespaceDetector;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.DefaultAnnotationHover;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.text.source.projection.ProjectionAnnotation;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditor;
import org.eclipse.ui.texteditor.TextOperationAction;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;


public abstract class AbstractModuleEditor extends AbstractDecoratedTextEditor implements
		IPropertyListener {
	
	protected Color backgroundColor = null;
	
	public static final Color COMMENT = new Color(Display.getCurrent(), new RGB(63, 127, 95));

	public static final Color ANNOTATION = new Color(Display.getCurrent(), new RGB(184, 160, 0));

	//public static final Color EXECUTABLEANNOTATION = new Color(Display.getCurrent(), new RGB(255, 0, 0));
	public static final Color EXECUTABLEANNOTATION = ANNOTATION;//new Color(Display.getCurrent(), new RGB(212, 176, 123));

	// static Color COMMENT = new Color(Display.getCurrent(), new RGB(128, 128,
	// 128));
	
	public static final Color STRING = new Color(Display.getCurrent(), new RGB(42, 0, 255));

	public static final Color DEFAULT = new Color(Display.getCurrent(), new RGB(0, 0, 0));

	public static final Color KEYWORD = new Color(Display.getCurrent(), new RGB(127, 0, 85));

	public static final Color BUILTIN = new Color(Display.getCurrent(), new RGB(42, 0, 255));
	
	public static final Color ASSERTION = new Color(Display.getCurrent(), new RGB(255, 0, 0));
	
	//static Color TYPE = new Color(Display.getCurrent(), new RGB(127, 159, 191));
	
	public static final Color TYPE = new Color(Display.getCurrent(), new RGB(0, 192, 0));

	private IContentOutlinePage outlinePage;

	public AbstractModuleEditor() {
		super();
		setDocumentProvider(new AbstractModuleEditorDocumentProvider());
		setEditorContextMenuId("#TextEditorContext");
		//setSourceViewerConfiguration(new AbstractModuleEditorSourceViewerConfiguration(this));
	}
	
	public void insertText(String text) {
		IDocument doc = this.getDocumentProvider().getDocument(
				this.getEditorInput());
		TextSelection selection = (TextSelection) getSelectionProvider().getSelection();
		try {
			doc.replace(selection.getOffset(), 0, text);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	// for auto-closing wait a bit before actually auto completing
	// if what pressed is . and is between parentheses, move it outside
	// if what pressed is ; and its right is a ) move it outside
	// ctrl + . moves . outside
	// enter between {} adds new line + tab
	// shift + space adds (|)
	protected void addSmartTyping() {
		
		boolean enableAutoClosing = false;
		if (!enableAutoClosing) return;
		
		IDocument doc = this.getDocumentProvider().getDocument(
				this.getEditorInput());
	
		doc.addDocumentListener(new IDocumentListener() {
			
			boolean auto = false;
			
			public void documentAboutToBeChanged(DocumentEvent event) {
				if (auto) return;
				if (event.fText.equalsIgnoreCase("'") || 
						event.fText.equalsIgnoreCase("\"") || 
						event.fText.equalsIgnoreCase("{") || 
						event.fText.equalsIgnoreCase("(")) {
					
					auto = true;
					try {
						String add = "'";
						if (event.fText.equalsIgnoreCase("(")) add = ")";
						if (event.fText.equalsIgnoreCase("\"")) add = "\"";
						if (event.fText.equalsIgnoreCase("{")) add = "}";
						
						event.fDocument.replace(event.fOffset, 0, add);
					} catch (BadLocationException e) {
						e.printStackTrace();
					}
					auto = false;
				}
			}

			public void documentChanged(DocumentEvent event) {

			}
			
		});
	}
	
	/*
	 * protected void createActions() { super.createActions(); Action action =
	 * new ContentAssistAction(
	 * ResourceBundle.getBundle("org.eclipse.escript.editor.messages"),
	 * "ContentAssistProposal.", this);
	 * action.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
	 * setAction("ContentAssistProposal", action);
	 * markAsStateDependentAction("ContentAssistProposal", true); }
	 */
	
	
	
	@Override
	public Object getAdapter(Class required) {
		if (IContentOutlinePage.class.equals(required)) {
			if (outlinePage == null) {
				outlinePage = createOutlinePage();
			}
			return outlinePage;
		}

		return super.getAdapter(required);
	}
	
	public List getAssertions(){
		ArrayList list = new ArrayList();
		list.add("assert");
		list.add("assertError");
		return list;
	}
	
	public List getTypes(){
		ArrayList list = new ArrayList();
		list.add("String");
		list.add("Boolean");
		list.add("Integer");
		list.add("Real");
		list.add("Any");
		list.add("Map");
		list.add("Collection");
		list.add("Bag");
		list.add("Sequence");
		list.add("Set");
		list.add("OrderedSet");
		list.add("Native");
		list.add("Nothing");
		return list;
	}
	
	public abstract List getKeywords();

	public abstract List getBuiltinVariables();

	public abstract IContentOutlinePage createOutlinePage();

	public abstract IModule getModule();

	/*
	 * class CompletionProcessor implements IContentAssistProcessor { private
	 * final IContextInformation[] NO_CONTEXTS = new IContextInformation[0];
	 * private final char[] PROPOSAL_ACTIVATION_CHARS = new char[] {
	 * 's','f','p','n','m', }; private ICompletionProposal[] NO_COMPLETIONS =
	 * new ICompletionProposal[0];
	 * 
	 * public ICompletionProposal[] computeCompletionProposals(ITextViewer
	 * viewer, int offset) { try { IDocument document = viewer.getDocument();
	 * ArrayList result = new ArrayList(); String prefix = lastWord(document,
	 * offset); String indent = lastIndent(document, offset); EscriptModel model =
	 * EscriptModel.getModel(document, null); model.getContentProposals(prefix,
	 * indent, offset, result); return (ICompletionProposal[])
	 * result.toArray(new ICompletionProposal[result.size()]); } catch
	 * (Throwable e) { e.printStackTrace(); return NO_COMPLETIONS; } } private
	 * String lastWord(IDocument doc, int offset) { try { for (int n = offset-1;
	 * n >= 0; n--) if (!Character.isJavaIdentifierPart(doc.getChar(n))) return
	 * doc.get(n + 1, offset-n-1); } catch (BadLocationException e) {
	 * e.printStackTrace(); } return ""; } private String lastIndent(IDocument
	 * doc, int offset) { try { int start = offset-1; while (start >= 0 &&
	 * doc.getChar(start)!= '\n') start--; int end = start; while (end < offset &&
	 * Character.isSpaceChar(doc.getChar(end))) end++; return doc.get(start+1,
	 * end-start-1); } catch (BadLocationException e) { //e.printStackTrace(); }
	 * return ""; } public IContextInformation[]
	 * computeContextInformation(ITextViewer viewer, int offset) { return
	 * NO_CONTEXTS; } public char[]
	 * getCompletionProposalAutoActivationCharacters() { return
	 * PROPOSAL_ACTIVATION_CHARS; } public char[]
	 * getContextInformationAutoActivationCharacters() { return null; } public
	 * IContextInformationValidator getContextInformationValidator() { return
	 * null; } public String getErrorMessage() { return null; } }
	 * 
	 * public class TextHover implements ITextHover { public IRegion
	 * getHoverRegion(ITextViewer textViewer, int offset) { return new
	 * Region(offset, 0); } public String getHoverInfo(ITextViewer textViewer,
	 * IRegion hoverRegion) { try { IDocument document =
	 * textViewer.getDocument(); EscriptModel model =
	 * EscriptModel.getModel(document, null); return
	 * model.getElementAt(hoverRegion.getOffset()).getHoverHelp(); } catch
	 * (Exception e) { return ""; } } }
	 */

	ProjectionSupport projectionSupport;

	AnnotationModel annotationModel;

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		ProjectionViewer viewer = (ProjectionViewer) getSourceViewer();
		projectionSupport = new ProjectionSupport(viewer,
				getAnnotationAccess(), getSharedColors());
		projectionSupport.install();

		// turn projection mode on
		viewer.doOperation(ProjectionViewer.TOGGLE);
		annotationModel = viewer.getProjectionAnnotationModel();
		updateFoldingStructure();
	}

	@Override
	protected ISourceViewer createSourceViewer(Composite parent,
			IVerticalRuler ruler, int styles) {

		ISourceViewer viewer = new ProjectionViewer(parent, ruler,
				getOverviewRuler(), isOverviewRulerVisible(), styles);
		
		// ensure decoration support has been created and configured.
		getSourceViewerDecorationSupport(viewer);
		
		return viewer;
	}
	
	//TODO : Improve the folding functionality

	boolean useCodeFolding = false;
	
	public void updateFoldingStructure() {
		if (!useCodeFolding) return;
		
		IModule module = getModule();
		IDocument doc = this.getDocumentProvider().getDocument(
				this.getEditorInput());
		
		try {
			annotationModel.removeAllAnnotations();
			module.parse(doc.get());
			ListIterator li = module.getChildren().listIterator();
			while (li.hasNext()){
				ModuleElement child = (ModuleElement) li.next();
				ProjectionAnnotation annotation = new ProjectionAnnotation();
				Position pos =  new Position(0);
				
				int startOffset = 0;
				
				if (li.hasPrevious()){
					startOffset = doc.getLineOffset(Math.max(child.getAst().getLine() - 1,0)) + child.getAst().getColumn();	
				}
				
				int endOffset = Math.max(doc.getLength(),0);
				if (li.hasNext()) {
					ModuleElement nextElement = (ModuleElement) li.next();
					endOffset = doc.getLineOffset(Math.max(nextElement.getAst().getLine() - 2,0)) + nextElement.getAst().getColumn() - 1;	
					li.previous();
				}
				
				pos.setOffset(startOffset);
				pos.setLength(endOffset-startOffset);
				annotationModel.addAnnotation(annotation,pos);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// annotationModel.modifyAnnotationPosition(annotation,new
		// Position(0,10));
		/*
		 * Annotation[] annotations = new Annotation[positions.size()];
		 * 
		 * //this will hold the new annotations along //with their corresponding
		 * positions HashMap newAnnotations = new HashMap();
		 * 
		 * for(int i = 0; i < positions.size();i++) { ProjectionAnnotation
		 * annotation = new ProjectionAnnotation();
		 * 
		 * newAnnotations.put(annotation, positions.get(i));
		 * 
		 * annotations[i] = annotation; }
		 * 
		 * annotationModel.mmodifyAnnotation(oldAnnotations,
		 * newAnnotations,null);
		 * 
		 * oldAnnotations = annotations;
		 */
	}
	
	protected Position getPosition(AST ast){
		Position pos = new Position(0);
		Visitor visitor = new Visitor();
		visitor.visit(ast);
		IDocument doc = this.getDocumentProvider().getDocument(
				this.getEditorInput());
		int startOffset = 0;
		int endOffset = 0;
		
		try {
			startOffset = doc.getLineOffset(visitor.startLine - 1) + visitor.startColumn - 1;
			endOffset = doc.getLineOffset(visitor.endLine - 1) + visitor.endColumn - 1;
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		pos.setOffset(startOffset);
		pos.setLength(endOffset-startOffset);
		return pos;
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
	
	@Override
	public void init(IEditorSite site, IEditorInput input) {
		try {
			super.init(site, input);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		setSourceViewerConfiguration(new AbstractModuleEditorSourceViewerConfiguration(this));
		addPropertyListener(this);
	}

	public void propertyChanged(Object source, int propId) {
		if (propId == 257 && source == this) {
			if (this.isDirty() == false) {
				//TODO : Add a preference page for enabling/disabling code folding
				//updateFoldingStructure();
			}
		}
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
	public abstract List<Template> getTemplates();
	
	private static final String CONTENTASSIST_PROPOSAL_ID = 
		   "com.bdaum.HTMLeditor.ContentAssistProposal"; 
		protected void createActions() {
		   super.createActions();

		   // This action will fire a CONTENTASSIST_PROPOSALS operation
		   // when executed
		   IAction action = 
		      new TextOperationAction(new ResourceBundle(){

				@Override
				public Enumeration<String> getKeys() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				protected Object handleGetObject(String key) {
					// TODO Auto-generated method stub
					return null;
				}},
		      "ContentAssistProposal", this, SourceViewer.CONTENTASSIST_PROPOSALS);
		   action.setActionDefinitionId(CONTENTASSIST_PROPOSAL_ID);

		   // Tell the editor about this new action
		   setAction(CONTENTASSIST_PROPOSAL_ID, action);

		   // Tell the editor to execute this action 
		   // when Ctrl+Spacebar is pressed
		   setActionActivationCode(CONTENTASSIST_PROPOSAL_ID,' ', -1, SWT.CTRL);
		}
}
