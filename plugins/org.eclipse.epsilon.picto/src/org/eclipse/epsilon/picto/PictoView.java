/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.picto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.picto.ViewRenderer.ZoomType;
import org.eclipse.epsilon.picto.actions.CopyToClipboardAction;
import org.eclipse.epsilon.picto.actions.LayersMenuAction;
import org.eclipse.epsilon.picto.actions.LockAction;
import org.eclipse.epsilon.picto.actions.PrintAction;
import org.eclipse.epsilon.picto.actions.SyncAction;
import org.eclipse.epsilon.picto.actions.ViewContentsMenuAction;
import org.eclipse.epsilon.picto.actions.ZoomAction;
import org.eclipse.epsilon.picto.source.PictoSource;
import org.eclipse.epsilon.picto.source.PictoSourceExtensionPointManager;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.text.IFindReplaceTarget;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.ViewPart;

public class PictoView extends ViewPart {
	
	public static final String ID = "org.eclipse.epsilon.picto.PictoView";
	
	protected ViewRenderer viewRenderer;
	protected BrowserContainer browserContainer;
	protected IEditorPart editor;
	protected EditorPropertyListener listener = new EditorPropertyListener();
	protected TreeViewer treeViewer;
	protected SashForm sashForm;
	protected int[] sashFormWeights = null;
	protected IEditorPart renderedEditor = null;
	protected boolean locked = false;
	protected ToggleTreeViewerAction hideTreeAction;
	protected HashMap<IEditorPart, ViewTree> selectionHistory = new HashMap<>();
	protected ViewTree activeView = null;
	protected PictoSource source = null;
	protected List<PictoSource> sources = new PictoSourceExtensionPointManager().getExtensions();
	protected ViewTreeLabelProvider viewTreeLabelProvider;
	
	@Override
	public void createPartControl(Composite parent) {
		
		sashForm = new SashForm(parent, SWT.HORIZONTAL);
		
		PatternFilter filter = new PatternFilter() {
			@Override
			protected boolean isLeafMatch(Viewer viewer, Object element) {
				ViewTree viewTree = (ViewTree) element;
				return wordMatches(viewTree.getName());
			}
		};
		FilteredViewTree filteredTree = new FilteredViewTree(sashForm, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.BORDER, filter, true);
		
		treeViewer = filteredTree.getViewer();
		treeViewer.setContentProvider(new ViewTreeContentProvider());
		viewTreeLabelProvider = new ViewTreeLabelProvider();
		treeViewer.setLabelProvider(viewTreeLabelProvider);
		treeViewer.addSelectionChangedListener(event -> {
			ViewTree view = ((ViewTree)event.getStructuredSelection().getFirstElement());
			if (view != null && view.getContent() != null) {
				try {
					selectionHistory.put(renderedEditor, view);
					renderView(view);
				} catch (Exception ex) {
					viewRenderer.display(ex);
				}
			}
		});
		treeViewer.addDoubleClickListener(event -> filteredTree.clearFilterText());
		
		browserContainer = new BrowserContainer(sashForm, SWT.NONE);
		viewRenderer = new ViewRenderer(this, new Browser(browserContainer, SWT.NONE));
		
		new BrowserFunction(viewRenderer.getBrowser(), "showView") {
			public Object function(Object[] arguments) {
				if (arguments.length == 1) {
					String viewPath = arguments[0] + "";
					ViewTree viewTree = getViewTree().forPath(Arrays.asList(viewPath.split("/")));
					List<ViewTree> path = new ArrayList<>();
					while (viewTree != null) {
						path.add(0, viewTree);
						viewTree = viewTree.getParent();
					}
					treeViewer.setSelection(new TreeSelection(new TreePath(path.toArray())));
					treeViewer.refresh();
				}
				throw new RuntimeException();
			};
		};
		
		new BrowserFunction(viewRenderer.getBrowser(), "showElement") {
			public Object function(Object[] arguments) {
				if (arguments.length == 2) {
					String id = arguments[0] + "";
					String uri = arguments[1] + "";
					PictoSource source = getSource(editor);
					source.showElement(id, uri, editor);
				}
				throw new RuntimeException();
			};
		};
		
		sashFormWeights = new int[] {20, 80};
		sashForm.setSashWidth(2);
		sashForm.setWeights(sashFormWeights);
		
		hideTreeAction = new ToggleTreeViewerAction();
		setTreeViewerVisible(false);
		
		IEditorPart activeEditor = getSite().getPage().getActiveEditor();
		if (activeEditor != null && supports(activeEditor)) {
			render(activeEditor);
		} else {
			render(null);
		}

		final PartListener partListener = new PartListener() {
			
			@Override
			public void partActivated(IWorkbenchPartReference partRef) {
				if (locked) return;
				Display.getCurrent().asyncExec(() -> {
					IWorkbenchPart part = partRef.getPart(false);
					if (editor != part && part instanceof IEditorPart && supports((IEditorPart) part)) {
						render((IEditorPart) part);
					}
				});
				
			}

			@Override
			public void partClosed(IWorkbenchPartReference partRef) {
				
				IWorkbenchPart workbenchPart = partRef.getPart(false);
				if (!(workbenchPart instanceof IEditorPart)) return;
				
				IEditorPart editorPart = (IEditorPart) workbenchPart;
				
				if (locked) {
					if (editor == editorPart) editor = null;
					return;
				}
				
				if (editorPart == PictoView.this) {
					getSite().getPage().removePartListener(this);
				} else if (editor == editorPart) {
					Display.getCurrent().asyncExec(() -> render(null));
				}
					
			}
		};
		
		IToolBarManager toolbar = getViewSite().getActionBars().getToolBarManager();
		toolbar.add(new ZoomAction(ZoomType.IN, viewRenderer));
		toolbar.add(new ZoomAction(ZoomType.ACTUAL, viewRenderer));
		toolbar.add(new ZoomAction(ZoomType.OUT, viewRenderer));
		toolbar.add(new Separator());
		toolbar.add(new LayersMenuAction(this));
		toolbar.add(new Separator());
		toolbar.add(new CopyToClipboardAction(this));
		toolbar.add(new PrintAction(viewRenderer));
		toolbar.add(new SyncAction(this));
		toolbar.add(new LockAction(this));
		toolbar.add(hideTreeAction);
		toolbar.add(new Separator());
		toolbar.add(new ViewContentsMenuAction(this));
		
		IMenuManager dropDownMenu = getViewSite().getActionBars().getMenuManager();
		dropDownMenu.add(new ClearViewTreeLabelProviderIconCacheAction());
		   
		this.getSite().getPage().addPartListener(partListener);

	}

	public void render(IEditorPart editor) {
		
		if (editor == null) {
			setTreeViewerVisible(false);
			viewRenderer.nothingToRender();
			this.editor = null;
		} else {
			if (this.editor != null)
				this.editor.removePropertyListener(listener);
			this.editor = editor;
			editor.addPropertyListener(listener);
			
			Job job = new Job("Rendering " + editor.getTitle()) {
				
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					renderEditorContent();
					return Status.OK_STATUS;
				}
			};
			job.setUser(true);
			job.schedule();
		}
	}
	
	protected boolean treeViewerShouldBeVisible;
	
	protected boolean isTreeViewerVisible() {
		if (sashForm.isDisposed()) return false;
		return sashForm.getSashWidth() > 0;
	}
	
	protected void setTreeViewerVisible(boolean visible) {
		this.treeViewerShouldBeVisible = visible;
		
		visible = treeViewerShouldBeVisible && !hideTreeAction.isChecked();
		
		if (isTreeViewerVisible() && !visible) { // Hide
			sashFormWeights = sashForm.getWeights();
			sashForm.setSashWidth(0);
			sashForm.setWeights(new int[] {0, 100});
		}
		else if (!isTreeViewerVisible() && visible) { // Show
			sashForm.setSashWidth(2);
			sashForm.setWeights(sashFormWeights);
		}
		
		browserContainer.setBorderVisible(visible);
	}
	
	
	public void renderEditorContent() {

		try {
			PictoSource newSource = getSource(editor);
			if (source != null) source.dispose();
			source = newSource;
			
			boolean rerender = renderedEditor == editor;
			renderedEditor = editor;
			
			final ViewTree viewTree = source.getViewTree(editor);
			runInUIThread(new RunnableWithException() {
				
				@Override
				public void runWithException() throws Exception {
					if (viewTree.getChildren().isEmpty()) {
						if (rerender) viewTree.setScrollPosition(viewRenderer.getScrollPosition());
						renderView(viewTree);
					}
					else {
						setViewTree(viewTree, rerender);
					}
					setTreeViewerVisible(!viewTree.getChildren().isEmpty());
					
				}
			});
			
		}
		catch (Exception ex) {
			try { 
				runInUIThread(new RunnableWithException() {
					
					@Override
					public void runWithException() throws Exception {
						setTreeViewerVisible(false);
						renderView(new ViewTree(viewRenderer.getZoomableVerbatim(ex.getMessage()), "html"));
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
			LogUtil.log(ex);
		}
	}
	
	public void runInUIThread(RunnableWithException runnable) throws Exception {
		Display.getDefault().syncExec(runnable);
		if (runnable.getException() != null) throw runnable.getException();
	}
	
	protected void setViewTree(ViewTree newViewTree, boolean rerender) throws Exception {
		
		ViewTree viewTree = getViewTree();
		if (viewTree == null || !rerender) {
			viewTree = newViewTree;
			treeViewer.setInput(viewTree);
		}
		else {
			viewTree.ingest(newViewTree);
		}
		
		treeViewer.refresh();
		
		if (rerender) {
			ViewTree selected = (ViewTree) treeViewer.getStructuredSelection().getFirstElement();
			if (selected != null && selected.getContent() != null) {
				renderView(selected);
			}
			else {
				viewRenderer.nothingToRender();
			}
		} else {
			
			ViewTree selection = null;
			ViewTree historicalView = selectionHistory.get(renderedEditor);
			
			if (historicalView != null) {
				selection = viewTree.forPath(historicalView.getPath());
				if (selection != null)
					selection.setScrollPosition(historicalView.getScrollPosition());
			}
			
			if (selection == null) {
				selection = viewTree.getFirstWithContent();
			}
			
			if (selection != null) {
				treeViewer.setSelection(new TreeSelection(new TreePath(new Object[] {selection})), true);
				treeViewer.refresh();
			}
			else {
				viewRenderer.nothingToRender();
			}
		}
	}
	
	public void renderView(ViewTree view) throws Exception {
		
		Browser browser = viewRenderer.getBrowser();
		
		if (activeView != null) {
			activeView.setScrollPosition(viewRenderer.getScrollPosition());
		}
		
		activeView = view;
		
		browser.addProgressListener(new ProgressListener() {
			
			@Override
			public void completed(ProgressEvent event) {
				viewRenderer.setScrollPosition(activeView.getScrollPosition());
				browser.removeProgressListener(this);
			}
			
			@Override
			public void changed(ProgressEvent event) {}
		});
		
		// Check if one of the source contents of the view is active
		ListIterator<ViewContent> contentIterator = view.getContents(this).listIterator();
		ViewContent content = null;
		while (contentIterator.hasNext() && content == null) {
			ViewContent next = contentIterator.next();
			if (next.isActive()) {
				content = next.getSourceContent(this);
			}
		}
		
		// ... if not, show the final rendered result
		if (content == null) content = view.getContent().getFinal(this);
		viewRenderer.display(content.getText());
		
	}
	
	@Override
	public void dispose() {
		super.dispose();
		if (source != null) source.dispose();
		if (editor != null)
			editor.removePropertyListener(listener);
	}

	@Override
	public void setFocus() {
		viewRenderer.getBrowser().setFocus();
	}

	class EditorPropertyListener implements IPropertyListener {
		@Override
		public void propertyChanged(Object source, int propId) {
			if (locked) return;
			if (propId == IEditorPart.PROP_DIRTY && !editor.isDirty()) {
				render(editor);
			}
		}
	}
	
	class ToggleTreeViewerAction extends Action {
		
		public ToggleTreeViewerAction() {
			super("Toggle tree", AS_CHECK_BOX);
			setImageDescriptor(PictoPlugin.getDefault().getImageDescriptor("icons/tree.png"));
		}
		
		@Override
		public void run() {
			setTreeViewerVisible(treeViewerShouldBeVisible);
		}
	}
	
	class ClearViewTreeLabelProviderIconCacheAction extends Action {
		public ClearViewTreeLabelProviderIconCacheAction() {
			super("Clear tree icon cache");
		}
		
		@Override
		public void run() {
			viewTreeLabelProvider.clearIconCache();
		}
	}
	
	protected boolean supports(IEditorPart editorPart) {
		return getSource(editorPart) != null;
	}
	
	protected PictoSource getSource(IEditorPart editorPart) {
		for (PictoSource source : sources) {
			if (source.supports(editorPart)) {
				return source;
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getAdapter(Class<T> adapter) {
	    if (IFindReplaceTarget.class.equals(adapter)) {
	    	return (T) new BrowserFindTarget(viewRenderer.getBrowser());
	    }
	    return super.getAdapter(adapter);
	}
	
	public IEditorPart getEditor() {
		return editor;
	}
	
	public boolean isLocked() {
		return locked;
	}
	
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
	public ViewTree getActiveView() {
		return activeView;
	}
	
	public ViewTree getViewTree() {
		return (ViewTree) treeViewer.getInput();
	}
	
	public ViewRenderer getViewRenderer() {
		return viewRenderer;
	}
	
}
