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

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.common.dt.EpsilonCommonsPlugin;
import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.commons.module.IModule;
import org.eclipse.epsilon.commons.module.ModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.eol.util.ReflectionUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;


public class ModuleContentOutlinePage extends ContentOutlinePage {

	protected IDocumentProvider documentProvider;
	protected IModule module;
	protected ITextEditor editor;
	protected ModuleElementLabelProvider labelProvider;
	protected ModuleContentOutlinePage thiz;
	protected Action linkWithEditorAction;
	
	public ModuleContentOutlinePage(IDocumentProvider documentProvider,
			ITextEditor editor, ModuleElementLabelProvider labelProvider) {
		super();
		this.documentProvider = documentProvider;
		this.editor = editor;
		this.labelProvider = labelProvider;
		addSelectionChangedListener(this);
		thiz = this;
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		//editor.addPropertyListener(new PropertyListener());
		getTreeViewer().setContentProvider(new ModuleContentProvider());
		getTreeViewer().setLabelProvider(labelProvider);
		
		IToolBarManager toolbarManager = getSite().getActionBars().getToolBarManager();
    	toolbarManager.add(new AlphabeticallySortAction());
    	linkWithEditorAction = new LinkWithEditorAction();
    	toolbarManager.add(linkWithEditorAction);
    	
		//update();
	}
	
	public void updateModule(IModule module) {
		if (getTreeViewer() != null)
		getTreeViewer().setInput(module);
	}
	
	public boolean isReady() {
		return notDisplayed() || getTreeViewer()!=null;
	}

	private boolean notDisplayed() {
		return getControl() == null || !getControl().isVisible();
	}
	
	/*
	public void update() {
		
		// Parse the module
		//IDocument document = documentProvider.getDocument(editor
		//		.getEditorInput());
		
		FileEditorInput fileInputEditor = (FileEditorInput) editor.getEditorInput();
		IFile file = fileInputEditor.getFile();
		
		try {
			module.reset();
			//module.parse(document.get());
			module.parse(new File(file.getLocation().toOSString()));
		} catch (Exception e) {
			// Ignore exception
		}
		
		// Update the outline
		getTreeViewer().setInput(module);
		
		// Update problem markers
		// Delete all the old markers and add new
		try {
			file.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
			for (ParseProblem problem : module.getParseProblems()) {
				Map attr = new HashMap();
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
				MarkerUtilities.createMarker(file, attr, IMarker.PROBLEM);
			}
		} catch (CoreException e1) {
			
		}

	}*/
	/*
	class PropertyListener implements IPropertyListener {

		public void propertyChanged(Object source, int propId) {
			if (propId == 257 && source == editor) {
				if (editor.isDirty() == false) {
					update();
				}
			}
		}
	}*/

	public AST toAst(Object o) {
		return (AST) o;
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		
		if (!linkWithEditorAction.isChecked()) return;
		
		ModuleElement element = (ModuleElement) (((IStructuredSelection) event
				.getSelection()).getFirstElement());
		
		if (element == null || element.getAst() == null)
			return;

		AST firstConcreteChild = AstUtil
				.getFirstConcreteChild(element.getAst());
		
		try {
			EclipseUtil.openEditorAt(firstConcreteChild.getFile(), firstConcreteChild.getLine(), firstConcreteChild.getColumn(), true);
		}
		catch (Exception ex) {
			//ex.printStackTrace();
		}
		/*
		try {
			int offset = (editor.getDocumentProvider().getDocument(
					editor.getEditorInput()).getLineOffset(
					firstConcreteChild.getLine() - 1) + firstConcreteChild
					.getColumn()) - 1;
			editor.setHighlightRange(offset, 0, true);
		} catch (Throwable t) {
			// Ignore
		}*/

	}

	public IModule getModule() {
		return module;
	}

	public void setModule(IModule module) {
		this.module = module;
	}
	
	class AlphabeticallySortAction extends Action {
		
		AlphabeticalSorter alphabeticalSorter = null;
		TreeViewer treeViewer = null;
		
		public AlphabeticallySortAction(){
			super(null,AS_CHECK_BOX);
			this.setImageDescriptor(EpsilonCommonsPlugin.getImageDescriptor("icons/alphabeticalSorter.gif"));
			this.setDescription("Sorts the contents of the view alphabetically");
			alphabeticalSorter = new AlphabeticalSorter();
			treeViewer = (TreeViewer) ReflectionUtil.getFieldValue(thiz,"treeViewer");
		}
		
		@Override
		public void run(){
			if (this.isChecked()){
				treeViewer.setSorter(alphabeticalSorter);
			}
			else {
				treeViewer.setSorter(null);
			}
		}
	}
	
	class LinkWithEditorAction extends Action {
		public LinkWithEditorAction(){
			super("Link with editor",AS_CHECK_BOX);
			this.setDescription("Links the outline view with the editor");
			this.setImageDescriptor(EpsilonCommonsPlugin.getImageDescriptor("icons/linkwitheditor.gif"));
			this.setChecked(true);
		}
	}
	
}
