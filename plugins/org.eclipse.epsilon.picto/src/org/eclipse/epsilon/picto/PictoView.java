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

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.common.util.OperatingSystem;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.egl.IEgxModule;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.flexmi.EObjectLocation;
import org.eclipse.epsilon.flexmi.FlexmiResource;
import org.eclipse.epsilon.flexmi.dt.PartListener;
import org.eclipse.epsilon.flexmi.dt.RunnableWithException;
import org.eclipse.epsilon.picto.LazyEgxModule.LazyGenerationRuleContentPromise;
import org.eclipse.epsilon.picto.ViewRenderer.ZoomType;
import org.eclipse.epsilon.picto.source.DotSource;
import org.eclipse.epsilon.picto.source.EditingDomainProviderSource;
import org.eclipse.epsilon.picto.source.EmfaticSource;
import org.eclipse.epsilon.picto.source.FlexmiSource;
import org.eclipse.epsilon.picto.source.HtmlSource;
import org.eclipse.epsilon.picto.source.NeatoSource;
import org.eclipse.epsilon.picto.source.SvgSource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
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
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredTree;
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
	protected File renderedFile = null;
	protected boolean locked = false;
	protected ToggleTreeViewerAction hideTreeAction;
	protected HashMap<String, ViewTree> selectionHistory = new HashMap<>();
	protected File tempDir = null;
	protected ViewTree activeView = null;
	protected List<PictoSource> sources = 
			Arrays.asList(
					new EmfaticSource(), 
					new EditingDomainProviderSource(), 
					new FlexmiSource(),
					new HtmlSource(),
					new SvgSource(),
					new DotSource(),
					new NeatoSource());
	
	@Override
	public void createPartControl(Composite parent) {
		
		try { tempDir = Files.createTempDirectory("picto").toFile(); } catch (IOException e) {}
		
		sashForm = new SashForm(parent, SWT.HORIZONTAL);
		
		PatternFilter filter = new PatternFilter() {
			@Override
			protected boolean isLeafMatch(Viewer viewer, Object element) {
				ViewTree viewTree = (ViewTree) element;
				return wordMatches(viewTree.getName());
			}
		};
		FilteredTree filteredTree = new FilteredTree(sashForm, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.BORDER, filter, true);
		
		treeViewer = filteredTree.getViewer();
		treeViewer.setContentProvider(new ViewTreeContentProvider());
		treeViewer.setLabelProvider(new ViewTreeLabelProvider());
		treeViewer.addSelectionChangedListener(event -> {
			ViewTree view = ((ViewTree)event.getStructuredSelection().getFirstElement());
			if (view != null && view.getContent() != null) {
				try {
					selectionHistory.put(renderedFile.getAbsolutePath(), view);
					renderView(view);
				} catch (Exception ex) {
					viewRenderer.display("<html><pre>" + ex.getMessage() + "</pre></html>");
				}
			}
		});
		
		browserContainer = new BrowserContainer(sashForm, SWT.NONE);
		viewRenderer = new ViewRenderer(new Browser(browserContainer, SWT.NONE));
		
		new BrowserFunction(viewRenderer.getBrowser(), "showView") {
			public Object function(Object[] arguments) {
				
				if (arguments.length == 1) {
					String viewPath = arguments[0] + "";
					ViewTree view = (ViewTree) treeViewer.getInput();
					ViewTree viewTree = view.forPath(Arrays.asList(viewPath.split("/")));
					List<ViewTree> path = new ArrayList<>();
					while (viewTree != null) {
						path.add(0, viewTree);
						viewTree = viewTree.getParent();
					}
					treeViewer.setSelection(new TreeSelection(new TreePath(path.toArray())));
					treeViewer.refresh();
				}
				return null;
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
				return null;
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
				IWorkbenchPart part = partRef.getPart(false);
				if (editor != part && part instanceof IEditorPart && supports((IEditorPart) part)) {
					render((IEditorPart) part);
				}
			}

			@Override
			public void partClosed(IWorkbenchPartReference partRef) {
				if (locked) return;
				IWorkbenchPart workbenchPart = partRef.getPart(false);
				if (!(workbenchPart instanceof IEditorPart)) return;
				IEditorPart editorPart = (IEditorPart) workbenchPart;
				if (editorPart == PictoView.this) {
					getSite().getPage().removePartListener(this);
				}
				else if (supports(editorPart)) {
					render(null);
				}
			}
		};
		
		IToolBarManager barManager = getViewSite().getActionBars().getToolBarManager();
		barManager.add(new ZoomAction(ZoomType.IN));
		barManager.add(new ZoomAction(ZoomType.ACTUAL));
		barManager.add(new ZoomAction(ZoomType.OUT));
		barManager.add(new Separator());
		barManager.add(new CopyToClipboardAction(viewRenderer));
		barManager.add(new PrintAction());
		barManager.add(new SyncAction());
		barManager.add(new LockAction());
		barManager.add(hideTreeAction);
		
		this.getSite().getPage().addPartListener(partListener);

	}

	public void render(IEditorPart editor) {
		
		if (editor == null) {
			setTreeViewerVisible(false);
			viewRenderer.nothingToRender();
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
	
	
	
	@SuppressWarnings({ "resource", "unchecked" })
	public void renderEditorContent() {

		try {
			
			PictoSource source = getSource(editor);
			
			while (source.getFile(editor) == null) { Thread.sleep(100); }
			
			File modelFile = new File(source.getFile(editor).getLocation().toOSString());
			boolean rerender = renderedFile != null && renderedFile.getAbsolutePath().equals(modelFile.getAbsolutePath());
			renderedFile = modelFile;
			
			Resource resource;
			
			try {
				resource = source.getResource(editor);
			}
			catch (Exception ex) {
				throw new ResourceLoadingException(ex);
			}
			
			PictoMetadata renderingMetadata = source.getRenderingMetadata(editor);
			
			if (renderingMetadata != null) {
			
				IEolModule module;	
				InMemoryEmfModel model;
				
				if (renderingMetadata.getNsuri() != null) {
					EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(renderingMetadata.getNsuri());
					model = new InMemoryEmfModel("M", resource, ePackage);
				}
				else {
					model = new InMemoryEmfModel("M", resource);
				}
				
				model.setExpand(false);	
				
				if (renderingMetadata.getFormat().equals("egx")) {
					module = new LazyEgxModule();
				}
				else {
					module = new EglTemplateFactoryModuleAdapter(new EglFileGeneratingTemplateFactory());
				}
				
				if (renderingMetadata.getFile() == null) throw new Exception("No EGL file specified.");
				
				File eglFile = new File(renderingMetadata.getFile()); 
				if (!eglFile.isAbsolute()) {
					eglFile = new File(modelFile.getParentFile(), renderingMetadata.getFile());
				}
				
				if (!eglFile.exists()) throw new Exception("Cannot find file " + eglFile.getAbsolutePath());
				
				module.parse(eglFile);
				
				IEolContext context = module.getContext();
				context.setOutputStream(EpsilonConsole.getInstance().getDebugStream());
				context.setErrorStream(EpsilonConsole.getInstance().getErrorStream());
				context.setWarningStream(EpsilonConsole.getInstance().getWarningStream());		
				context.getModelRepository().addModel(model);
				
				if (renderingMetadata.getFormat().equals("egx")) {
					
					EglTemplateFactory templateFactory = new EglTemplateFactory();
					templateFactory.setTemplateRoot(eglFile.getParentFile().getAbsolutePath());
					((IEgxModule) module).getContext().setTemplateFactory(templateFactory);
					
					ViewTree viewTree = new ViewTree();
					
					List<LazyGenerationRuleContentPromise> instances = (List<LazyGenerationRuleContentPromise>) module.execute();
					for (LazyGenerationRuleContentPromise instance : instances) {
						String format = "html";
						String icon = "cccccc";
						Collection<String> path = new ArrayList<>(Arrays.asList(""));
						
						for (Variable variable : instance.getVariables()) {
							switch (variable.getName()) {
							case "format": format = variable.getValue() + ""; break;
							case "path": path = (Collection<String>) variable.getValue(); break;
							case "icon": icon = variable.getValue() + ""; break;
							}
						}
						
						viewTree.addPath(new ArrayList<>(path), instance, format, icon);
					}
					
					runInUIThread(new RunnableWithException() {
						
						@Override
						public void runWithException() throws Exception {
							setViewTree(viewTree, rerender);
							setTreeViewerVisible(true);
						}
					});
					
				}
				else {
					String content = module.execute() + "";
					runInUIThread(new RunnableWithException() {
						
						@Override
						public void runWithException() throws Exception {
							if (!rerender) activeView = new ViewTree();
							activeView.setPromise(new StringContentPromise(content));
							activeView.setFormat(renderingMetadata.getFormat());
							setTreeViewerVisible(false);
							renderView(activeView);
						}
					});
				}
			}
		}
		catch (Exception ex) {
			try { 
				runInUIThread(new RunnableWithException() {
					
					@Override
					public void runWithException() throws Exception {
						setTreeViewerVisible(false);
						renderView(new ViewTree("<html><pre>" + ex.getMessage() + "</pre></html>", "html"));
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
		
		ViewTree viewTree = (ViewTree) treeViewer.getInput();
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
			if (selected != null) {
				if (selected.getContent() == null) viewRenderer.nothingToRender();
				else renderView(selected);
			}
			else {
				viewRenderer.nothingToRender();
			}
		} else {
			
			ViewTree selection = null;
			ViewTree historicalView = selectionHistory.get(renderedFile.getAbsolutePath());
			
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
	
	protected void renderView(ViewTree view) throws Exception {
		
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
		
		String format = view.getFormat();
		String content = view.getContent();
		
		if (format.equals("html")) {
			viewRenderer.display(content);
		}
		else if (format.startsWith("graphviz-")) {
			
			String[] parts = format.split("-");
			
			String program = parts[1].trim();
			String imageType = "svg";
			if (parts.length > 2) {
				imageType = parts[2];
			}
			
			File temp = Files.createTempFile(tempDir.toPath(), "picto-renderer", ".dot").toFile();
			File image = new File(temp.getAbsolutePath() + "." + imageType);
			File log = new File(temp.getAbsolutePath() + ".log" );
			
			Files.write(Paths.get(temp.toURI()), content.getBytes());
			
			if (!OperatingSystem.isWindows()) program = "/usr/local/bin/" + program;
			
			ProcessBuilder pb = new ProcessBuilder(new String[] {program, "-T" + imageType, temp.getAbsolutePath(), "-o", image.getAbsolutePath()});
			pb.redirectError(log);
			Process p = pb.start();
			p.waitFor();
			
			if (image.exists()) {
				viewRenderer.display("<html><body style=\"zoom:" + viewRenderer.getZoom() + "\"><object data=\"" + image.getAbsolutePath() + "\" type=\"image/svg+xml\"></object></body></html>");
			}
			else if (log.exists()) {
				viewRenderer.display(log);
			}
		}
		else if (format.equals("text")) {
			File temp = File.createTempFile("picto-renderer", ".txt");
			Files.write(Paths.get(temp.toURI()), content.getBytes());
			viewRenderer.display(temp);
		}
		else {
			viewRenderer.nothingToRender();
		}
	}
	
	@Override
	public void dispose() {
		super.dispose();
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
	
	class PrintAction extends Action {
		public PrintAction() {
			setText("Print");
			setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_PRINT_EDIT));
		}
		
		@Override
		public void run() {
			viewRenderer.getBrowser().execute("javascript:window.print();");
		}
	}
	
	class ZoomAction extends Action {
		
		ZoomType type;
		
		public ZoomAction(ZoomType type) {
			this.type = type;
			if (type == ZoomType.IN) {
				setText("Zoom in");
				setImageDescriptor(Activator.getDefault().getImageDescriptor("icons/zoomin.gif"));
			}
			else if (type == ZoomType.OUT){
				setText("Zoom out");
				setImageDescriptor(Activator.getDefault().getImageDescriptor("icons/zoomout.gif"));	
			}
			else {
				setText("Reset");
				setImageDescriptor(Activator.getDefault().getImageDescriptor("icons/zoomactual.gif"));		
			}
		}
		
		@Override
		public void run() {
			viewRenderer.zoom(type);
		}
	}
	
	class SyncAction extends Action {
		public SyncAction() {
			setText("Sync");
			setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));
		}
		
		@Override
		public void run() {
			render(editor);
		}
	}
	
	class LockAction extends Action {
		public LockAction() {
			super("Lock", AS_CHECK_BOX);
			setImageDescriptor(Activator.getDefault().getImageDescriptor("icons/lock.gif"));
		}
		
		@Override
		public void run() {
			locked = !locked;
		}
	}
	
	class ToggleTreeViewerAction extends Action {
		
		public ToggleTreeViewerAction() {
			super("Toggle tree", AS_CHECK_BOX);
			setImageDescriptor(Activator.getDefault().getImageDescriptor("icons/tree.png"));
		}
		
		@Override
		public void run() {
			setTreeViewerVisible(treeViewerShouldBeVisible);
		}
	}
	
	protected boolean supports(IEditorPart editorPart) {
		return getSource(editorPart) != null;
	}
	
	protected PictoSource getSource(IEditorPart editorPart) {
		for (PictoSource source : sources) {
			if (source.supports(editorPart)) return source;
		}
		return null;
	}
	
}
