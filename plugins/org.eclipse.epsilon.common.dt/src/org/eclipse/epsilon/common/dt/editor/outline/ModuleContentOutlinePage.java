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

import org.eclipse.epsilon.common.dt.EpsilonCommonsPlugin;
import org.eclipse.epsilon.common.dt.editor.AbstractModuleEditor;
import org.eclipse.epsilon.common.dt.editor.IModuleParseListener;
import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.util.ReflectionUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;


public class ModuleContentOutlinePage extends ContentOutlinePage implements IModuleParseListener {

	protected IDocumentProvider documentProvider;
	protected IModule module;
	protected ITextEditor editor;
	protected ILabelProvider labelProvider;
	protected Action linkWithEditorAction;
	
	public ModuleContentOutlinePage(IDocumentProvider documentProvider,
			ITextEditor editor, ILabelProvider labelProvider) {
		super();
		this.documentProvider = documentProvider;
		this.editor = editor;
		this.labelProvider = labelProvider;
		addSelectionChangedListener(this);
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		getTreeViewer().setContentProvider(createContentProvider());
		getTreeViewer().setLabelProvider(labelProvider);
		getSite().setSelectionProvider(getTreeViewer());
		
		IToolBarManager toolbarManager = getSite().getActionBars().getToolBarManager();
    	toolbarManager.add(new AlphabeticallySortAction());
    	linkWithEditorAction = new LinkWithEditorAction();
    	toolbarManager.add(linkWithEditorAction);
    	
		//update();
	}
	
	protected IContentProvider createContentProvider() {
		return new ModuleContentProvider();
	}
	
	public boolean isReady() {
		return notDisplayed() || getTreeViewer()!=null;
	}

	private boolean notDisplayed() {
		return getControl() == null || !getControl().isVisible();
	}

	public AST toAst(Object o) {
		return (AST) o;
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		
		if (!linkWithEditorAction.isChecked()) return;
		
		try {
			EditorSelection editorSelection = getEditorSelection(((IStructuredSelection) event
					.getSelection()).getFirstElement());
			
			EclipseUtil.openEditorAt(editorSelection.getFile(), editorSelection.getLine(), 
					editorSelection.getColumn(), true);
		}
		catch (Exception ex) {
			//ex.printStackTrace();
		}
	}
	
	protected EditorSelection getEditorSelection(Object selection) {
		
		ModuleElement element = (ModuleElement) (selection);
		
		if (element == null || element.getAst() == null)
			return null;

		AST firstConcreteChild = AstUtil
				.getFirstConcreteChild(element.getAst());
		
		return new EditorSelection(firstConcreteChild.getFile(), firstConcreteChild.getLine(), firstConcreteChild.getColumn());
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
			treeViewer = (TreeViewer) ReflectionUtil.getFieldValue(ModuleContentOutlinePage.this ,"treeViewer");
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

	public void moduleParsed(AbstractModuleEditor editor, final IModule module) {
		if (getSite() != null) {
			getSite().getShell().getDisplay().asyncExec(new Runnable() {
				
				public void run() {
					if (getTreeViewer() != null)
						getTreeViewer().setInput(getOutlineRoot(module));				
				}
			});
		}
	}
	
	public Object getOutlineRoot(IModule module) { return module; }
	
}
