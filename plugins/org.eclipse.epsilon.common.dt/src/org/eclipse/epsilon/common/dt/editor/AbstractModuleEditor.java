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

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.epsilon.common.dt.editor.contentassist.IAbstractModuleEditorTemplateContributor;
import org.eclipse.epsilon.common.dt.editor.outline.ModuleContentOutlinePage;
import org.eclipse.epsilon.common.dt.editor.outline.ModuleElementLabelProvider;
import org.eclipse.epsilon.commons.module.IModule;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.commons.util.ListBuilder;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.DefaultCharacterPairMatcher;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewer;
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
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditor;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.eclipse.ui.texteditor.TextOperationAction;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;


public abstract class AbstractModuleEditor extends AbstractDecoratedTextEditor { //implements IPropertyListener {
	
	protected Color backgroundColor = null;
	protected Job parseModuleJob = null;
	protected ArrayList<IModuleParseListener> moduleParsedListeners = new ArrayList<IModuleParseListener>();
	protected ArrayList<IAbstractModuleEditorTemplateContributor> templateContributors = new ArrayList<IAbstractModuleEditorTemplateContributor>();
	
	public static final Color COMMENT = new Color(Display.getCurrent(), new RGB(63, 127, 95));
	public static final Color ANNOTATION = new Color(Display.getCurrent(), new RGB(184, 160, 0));
	public static final Color EXECUTABLEANNOTATION = ANNOTATION;
	public static final Color STRING = new Color(Display.getCurrent(), new RGB(42, 0, 255));
	public static final Color DEFAULT = new Color(Display.getCurrent(), new RGB(0, 0, 0));
	public static final Color KEYWORD = new Color(Display.getCurrent(), new RGB(127, 0, 85));
	public static final Color BUILTIN = new Color(Display.getCurrent(), new RGB(42, 0, 255));
	public static final Color ASSERTION = new Color(Display.getCurrent(), new RGB(255, 0, 0));
	public static final Color TYPE = new Color(Display.getCurrent(), new RGB(0, 192, 0));
	public static final String PROBLEMMARKER = "org.eclipse.epsilon.common.dt.problemmarker";
	
	private ModuleContentOutlinePage outlinePage;

	public AbstractModuleEditor() {
		super();
		setDocumentProvider(new AbstractModuleEditorDocumentProvider());
		setEditorContextMenuId("#TextEditorContext");
	    setRulerContextMenuId("editor.rulerMenu");
		//addSmartTyping();
		//setSourceViewerConfiguration(new AbstractModuleEditorSourceViewerConfiguration(this));
	}
	
	public void addModuleParsedListener(IModuleParseListener listener) {
		this.moduleParsedListeners.add(listener);
	}
	
	public boolean removeModuleParsedListener(IModuleParseListener listener) {
		return moduleParsedListeners.remove(moduleParsedListeners);
	}
	
	public void addTemplateContributor(IAbstractModuleEditorTemplateContributor templateContributor) {
		this.templateContributors.add(templateContributor);
	}
	
	public boolean removeTemplateContributor(IAbstractModuleEditorTemplateContributor templateContributor) {
		return this.templateContributors.remove(templateContributor);
	}
	
	protected void notifyModuleParsedListeners(IModule module) {
		for (IModuleParseListener listener : moduleParsedListeners) {
			listener.moduleParsed(this, module);
		}
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
	
	public final static String EDITOR_MATCHING_BRACKETS = "matchingBrackets";
	public final static String EDITOR_MATCHING_BRACKETS_COLOR= "matchingBracketsColor";
	
	@Override
	protected void configureSourceViewerDecorationSupport(
			SourceViewerDecorationSupport support) {

		super.configureSourceViewerDecorationSupport(support);
		char[] matchChars = {'(', ')', '[', ']', '{', '}'}; 		
		ICharacterPairMatcher matcher = new DefaultCharacterPairMatcher(matchChars ,
				IDocumentExtension3.DEFAULT_PARTITIONING);
		support.setCharacterPairMatcher(matcher);
		support.setMatchingCharacterPainterPreferenceKeys(EDITOR_MATCHING_BRACKETS,EDITOR_MATCHING_BRACKETS_COLOR);
		
		IPreferenceStore store = getPreferenceStore();
		store.setDefault(EDITOR_MATCHING_BRACKETS, true);
		store.setDefault(EDITOR_MATCHING_BRACKETS_COLOR, "128,128,128");
	}
	
	@Override
	public Object getAdapter(Class required) {
		if (IContentOutlinePage.class.equals(required)) {
			return outlinePage;
		}

		return super.getAdapter(required);
	}
	
	public List<String> getAssertions(){
		return new ListBuilder<String>().build(
				"assert", "assertError");
	}
	
	public List<String> getTypes(){
		return new ListBuilder<String>().build(
			"String", "Boolean", "Integer", "Real",
			"Any", "Map", "Collection", "Bag", "Sequence",
			"Set", "OrderedSet", "Native", "List");
	}
	
	public abstract List<String> getKeywords();

	public abstract List<String> getBuiltinVariables();

	public ModuleContentOutlinePage createOutlinePage() {
		ModuleContentOutlinePage outline = 
			new ModuleContentOutlinePage(
					this.getDocumentProvider(), 
					this, 
					createModuleElementLabelProvider());
		
		addModuleParsedListener(outline);
		
		return outline;
	}

	public abstract IModule createModule();

	public abstract ModuleElementLabelProvider createModuleElementLabelProvider();
	
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
		//updateFoldingStructure();
	}

	@Override
	protected ISourceViewer createSourceViewer(Composite parent,
			IVerticalRuler ruler, int styles) {

		ISourceViewer viewer = new ProjectionViewer(parent, ruler,
				getOverviewRuler(), isOverviewRulerVisible(), styles);
		
		IDocument doc = this.getDocumentProvider().getDocument(
				this.getEditorInput());
		
		doc.addDocumentListener(new PairAutoCloser());
		// ensure decoration support has been created and configured.
		getSourceViewerDecorationSupport(viewer);
		
		return viewer;
	}
	
	//TODO : Improve the folding functionality

//	boolean useCodeFolding = false;
//	
//	public void updateFoldingStructure() {
//		if (!useCodeFolding) return;
//		
//		IModule module = createModule();
//		IDocument doc = this.getDocumentProvider().getDocument(
//				this.getEditorInput());
//		
//		try {
//			annotationModel.removeAllAnnotations();
//			module.parse(doc.get());
//			ListIterator li = module.getChildren().listIterator();
//			while (li.hasNext()){
//				ModuleElement child = (ModuleElement) li.next();
//				ProjectionAnnotation annotation = new ProjectionAnnotation();
//				Position pos =  new Position(0);
//				
//				int startOffset = 0;
//				
//				if (li.hasPrevious()){
//					startOffset = doc.getLineOffset(Math.max(child.getAst().getLine() - 1,0)) + child.getAst().getColumn();	
//				}
//				
//				int endOffset = Math.max(doc.getLength(),0);
//				if (li.hasNext()) {
//					ModuleElement nextElement = (ModuleElement) li.next();
//					endOffset = doc.getLineOffset(Math.max(nextElement.getAst().getLine() - 2,0)) + nextElement.getAst().getColumn() - 1;	
//					li.previous();
//				}
//				
//				pos.setOffset(startOffset);
//				pos.setLength(endOffset-startOffset);
//				annotationModel.addAnnotation(annotation,pos);
//			}
//
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
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
	//}
	
	@Override
	public void init(IEditorSite site, IEditorInput input) {
		try {
			super.init(site, input);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		
		AbstractModuleEditorSourceViewerConfiguration sourceViewerConfiguration = new AbstractModuleEditorSourceViewerConfiguration(this);
		setSourceViewerConfiguration(sourceViewerConfiguration);
		
		outlinePage = createOutlinePage();
		
		
		final int delay = 1000;
		
		parseModuleJob = new Job("Parsing module") {
			
			protected int status = -1;
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				
				if (!isClosed() && status != getText().hashCode()) {
					parseModule();
					status = getText().hashCode();
				}
				
				this.schedule(delay);
				return Status.OK_STATUS;
			}
		};
		
		parseModuleJob.schedule(delay);
	
	}
	
	public boolean isClosed() {
		return this.getDocumentProvider() == null;
	}
	
	public String getText() {
		return this.getDocumentProvider().getDocument(
				this.getEditorInput()).get();
	}
	
	public void parseModule() {
		FileEditorInput fileInputEditor = (FileEditorInput) getEditorInput();
		IFile file = fileInputEditor.getFile();
		
		final IModule module = createModule();
		final IDocument doc = this.getDocumentProvider().getDocument(
				this.getEditorInput());
		
		// Replace tabs with spaces to match
		// column numbers produced by the parser
		String code = doc.get();
		code = code.replaceAll("\t", " ");
		
		try {
			module.reset();
			module.parse(code, new File(file.getLocation().toOSString()));
		} catch (Exception e) {
			
		}
		
		// Update problem markers
		// Delete all the old markers and add new
		try {
			file.deleteMarkers(AbstractModuleEditor.PROBLEMMARKER, true, IResource.DEPTH_INFINITE);
			//file.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
			for (ParseProblem problem : module.getParseProblems()) {
				Map<String, Object> attr = new HashMap<String, Object>();
				attr.put(IMarker.LINE_NUMBER, new Integer(problem.getLine()));
				attr.put(IMarker.MESSAGE, problem.getReason());				
				int markerSeverity;
				if (problem.getSeverity() == ParseProblem.ERROR) {
					markerSeverity = IMarker.SEVERITY_ERROR;
				}
				else {
					markerSeverity = IMarker.SEVERITY_WARNING;
				}
				attr.put(IMarker.SEVERITY, markerSeverity);
				MarkerUtilities.createMarker(file, attr, AbstractModuleEditor.PROBLEMMARKER);
//				MarkerUtilities.createMarker(file, attr, IMarker.PROBLEM);
			}
		} catch (CoreException e1) {}
		
		if (module != null && module.getParseProblems().size() == 0) {
			notifyModuleParsedListeners(module);
		}
		
	}
	
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		// TODO Auto-generated method stub
		super.doSave(progressMonitor);
		if (!supportsDirtyTextParsing()) parseModule();
	}
	
	protected abstract boolean supportsHyperlinks();
	
	protected abstract boolean supportsDirtyTextParsing();
	
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
	@Override
	public void close(boolean save) {
		parseModuleJob.cancel();
		super.close(save);
	}
	
	public final List<Template> getTemplates() {
		
		List<Template> templates = new ArrayList<Template>();
		
		for (IAbstractModuleEditorTemplateContributor contributor : templateContributors) {
			templates.addAll(contributor.getTemplates());
		}
		
		return templates;
	}
	
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
