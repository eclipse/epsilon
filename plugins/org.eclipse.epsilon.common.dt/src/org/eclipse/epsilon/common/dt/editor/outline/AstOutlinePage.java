package org.eclipse.epsilon.common.dt.editor.outline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

public class AstOutlinePage extends ModuleContentOutlinePage {

	protected HashMap<AST, List<AST>> childrenCache = new HashMap<AST, List<AST>>();
	
	public AstOutlinePage(IDocumentProvider documentProvider,
			ITextEditor editor, ILabelProvider labelProvider) {
		super(documentProvider, editor, labelProvider);
	}
	
	@Override
	public Object getOutlineRoot(IModule module) {
		childrenCache.clear();
		return module.getAst();
	}
	
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		
		if (!linkWithEditorAction.isChecked()) return;
		
		try {
			
			AST selected = (AST) ((IStructuredSelection) event
					.getSelection()).getFirstElement();
			
			
			EclipseUtil.openEditorAt(selected);
			
			/*
			IDocument doc = editor.getDocumentProvider().getDocument(editor.getEditorInput());
			Region region = selected.getRegion();
			
			int startOffset = doc.getLineOffset(region.getStart().getLine()-1) + region.getStart().getColumn();
			int endOffset = doc.getLineOffset(region.getEnd().getLine()-1) + region.getEnd().getColumn();
			
			//EditorSelection editorSelection = getEditorSelection(selected);
			
			EclipseUtil.openEditorAt(selected.getFile(), region.getStart().getLine(), 
					region.getStart().getColumn(), endOffset - startOffset, false);*/
			
		}
		catch (Exception ex) {
			
		}
	}
	
	@Override
	protected IContentProvider createContentProvider() {
		return new ITreeContentProvider() {
			
			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				
			}
			
			@Override
			public void dispose() {
				
			}
			
			@Override
			public boolean hasChildren(Object element) {
				return getChildren(element).length > 0;
			}
			
			@Override
			public Object getParent(Object element) {
				//if (element inst)
				//return ((AST) element).getParent();
				return null;
			}
			
			@Override
			public Object[] getElements(Object inputElement) {
				return getChildren(inputElement);
			}
			
			@Override
			public Object[] getChildren(Object parentElement) {
				
				List<Object> children = new ArrayList<Object>();
				if (parentElement instanceof AST) {
					children.addAll(((AST) parentElement).getChildren());
					if (parentElement instanceof AbstractModuleElement) children.addAll(((AbstractModuleElement) parentElement).getComments());
				}
				return children.toArray();
				//return AstOutlinePage.this.getChildren((AST) parentElement)/*.getChildren()*/.toArray();
			}
		};
	}
	
	/*
	protected List<AST> getChildren(AST ast) {
		boolean onlyNonImaginary = true;
		if (onlyNonImaginary) {
			List<AST> realChildren = childrenCache.get(ast);
			if (realChildren == null) {
				realChildren = new ArrayList<AST>();
				for (AST child : ast.getChildren()) {
					if (child.isImaginary()) {
						realChildren.addAll(getChildren(child));
					}
					else {
						realChildren.add(child);
					}
				}
				childrenCache.put(ast, realChildren);
			}
			return realChildren;
		}
		else {
			return ast.getChildren();
		}
	}*/
	
}
