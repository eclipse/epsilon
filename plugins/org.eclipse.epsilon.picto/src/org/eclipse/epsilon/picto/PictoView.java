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

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.emfatic.core.generator.ecore.Builder;
import org.eclipse.emf.emfatic.core.generator.ecore.Connector;
import org.eclipse.emf.emfatic.core.generator.ecore.EmfaticSemanticWarning;
import org.eclipse.emf.emfatic.core.lang.gen.parser.EmfaticParserDriver;
import org.eclipse.emf.emfatic.ui.editor.EmfaticEditor;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.common.util.OperatingSystem;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.egl.IEgxModule;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.flexmi.FlexmiResource;
import org.eclipse.epsilon.flexmi.FlexmiResourceFactory;
import org.eclipse.epsilon.flexmi.dt.BrowserContainer;
import org.eclipse.epsilon.flexmi.dt.FlexmiEditor;
import org.eclipse.epsilon.flexmi.dt.PartListener;
import org.eclipse.epsilon.flexmi.dt.RunnableWithException;
import org.eclipse.gymnast.runtime.core.parser.ParseContext;
import org.eclipse.gymnast.runtime.core.parser.ParseMessage;
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
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.ViewPart;
import org.w3c.dom.ProcessingInstruction;

public class PictoView extends ViewPart {
	
	public static final String ID = "org.eclipse.epsilon.picto.PictoView";

	protected Browser browser;
	protected BrowserContainer browserContainer;
	protected IEditorPart editor;
	protected EditorPropertyListener listener = new EditorPropertyListener();
	protected TreeViewer treeViewer;
	protected double zoom = 1.0;
	protected SashForm sashForm;
	protected int[] sashFormWeights = null;
	protected File renderedFile = null;
	protected boolean locked = false;
	protected HashMap<String, ViewTree> selectionHistory = new HashMap<>();
	protected File tempDir = null;
	protected ViewTree activeView = null;
	
	@Override
	public void createPartControl(Composite parent) {
		
		try { tempDir = Files.createTempDirectory("picto").toFile(); } catch (IOException e) {}
		
		sashForm = new SashForm(parent, SWT.HORIZONTAL);
		
		PatternFilter filter = new PatternFilter() {
			@Override
			protected boolean isLeafMatch(Viewer viewer, Object element) {
				ViewTree viewTree = (ViewTree) element;
				return wordMatches(viewTree.getName()) || (viewTree.getContent() != null && wordMatches(viewTree.getContent()));
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
					display("<html><pre>" + ex.getMessage() + "</pre></html>");
				}
			}
		});
		
		browserContainer = new BrowserContainer(sashForm, SWT.NONE);
		browser = new Browser(browserContainer, SWT.NONE);
		
		new BrowserFunction(browser, "showView") {
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
		
		sashFormWeights = new int[] {20, 80};
		sashForm.setSashWidth(2);
		sashForm.setWeights(sashFormWeights);
		
		setTreeViewerVisible(false);
		
		IEditorPart activeEditor = getSite().getPage().getActiveEditor();
		if (supports(activeEditor)) {
			render(activeEditor);
		} else {
			render(null);
		}

		final PartListener partListener = new PartListener() {
			@Override
			public void partActivated(IWorkbenchPartReference partRef) {
				if (locked) return;
				IWorkbenchPart part = partRef.getPart(false);
				if (editor != part && supports(part)) {
					render((IEditorPart) part);
				}
			}

			@Override
			public void partClosed(IWorkbenchPartReference partRef) {
				if (locked) return;
				if (partRef.getPart(false) == PictoView.this) {
					getSite().getPage().removePartListener(this);
				}
				else if (supports(partRef.getPart(false))) {
					render(null);
				}
			}
		};
		
		IToolBarManager barManager = getViewSite().getActionBars().getToolBarManager();
		barManager.add(new ZoomAction(ZoomType.IN));
		barManager.add(new ZoomAction(ZoomType.ACTUAL));
		barManager.add(new ZoomAction(ZoomType.OUT));
		barManager.add(new Separator());
		barManager.add(new CopyToClipboardAction(browser));
		barManager.add(new PrintAction());
		barManager.add(new SyncAction());
		barManager.add(new LockAction());
		
		this.getSite().getPage().addPartListener(partListener);

	}

	public void render(IEditorPart editor) {
		
		if (editor == null) {
			nothingToRender();
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
	
	protected void setTreeViewerVisible(boolean visible) {
		if (sashForm.getSashWidth() > 0 && !visible) { // Hide
			sashFormWeights = sashForm.getWeights();
			sashForm.setSashWidth(0);
			sashForm.setWeights(new int[] {0, 100});
		}
		else if (sashForm.getSashWidth() == 0 && visible) { // Show
			sashForm.setSashWidth(2);
			sashForm.setWeights(sashFormWeights);
		}
		browserContainer.setBorderVisible(visible);
	}
	
	public void nothingToRender() {
		display("<html></html>");
	}
	
	@SuppressWarnings("resource")
	public void renderEditorContent() {

		try {
			while (getFile(editor) == null) { Thread.sleep(100); }
			
			File modelFile = new File(getFile(editor).getLocation().toOSString());
			boolean rerender = renderedFile != null && renderedFile.getAbsolutePath().equals(modelFile.getAbsolutePath());
			renderedFile = modelFile;
			
			Resource resource = getResource(editor);
			PictoMetadata renderingMetadata = getRenderingMetadata(editor);
			
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
					module = new EgxModule();
				}
				else {
					module = new EglTemplateFactoryModuleAdapter(new EglFileGeneratingTemplateFactory());
				}
				
				if (renderingMetadata.getFile() == null) throw new Exception("No EGL file specified.");
				
				File eglFile = new File(modelFile.getParentFile(), renderingMetadata.getFile());
				
				if (!eglFile.exists()) throw new Exception("Cannot find file " + eglFile.getAbsolutePath());
				
				module.parse(eglFile);
				
				IEolContext context = module.getContext();
				context.setOutputStream(EpsilonConsole.getInstance().getDebugStream());
				context.setErrorStream(EpsilonConsole.getInstance().getErrorStream());
				context.setWarningStream(EpsilonConsole.getInstance().getWarningStream());		
				context.getModelRepository().addModel(model);
				
				if (renderingMetadata.getFormat().equals("egx")) {
					RenderingEglTemplateFactory templateFactory = new RenderingEglTemplateFactory(tempDir);
					templateFactory.setTemplateRoot(eglFile.getParentFile().getAbsolutePath());
					((IEgxModule) module).getContext().setTemplateFactory(templateFactory);
					module.execute();
					
					runInUIThread(new RunnableWithException() {
						
						@Override
						public void runWithException() throws Exception {
							setViewTree(templateFactory.getViewTree(), rerender);
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
							activeView.setContent(content);
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
				if (selected.getContent() == null) nothingToRender();
				else renderView(selected);
			}
			else {
				nothingToRender();
			}
		} else {
			
			ViewTree selection = null;
			ViewTree historicalView = selectionHistory.get(renderedFile.getAbsolutePath());
			
			if (historicalView != null) {
				selection = viewTree.forPath(historicalView.getPath());
				selection.setScrollX(historicalView.getScrollX());
				selection.setScrollY(historicalView.getScrollY());
			}
			
			if (selection == null) {
				selection = viewTree.getFirstWithContent();
			}
			
			if (selection != null) {
				treeViewer.setSelection(new TreeSelection(new TreePath(new Object[] {selection})), true);
				treeViewer.refresh();
			}
			else {
				nothingToRender();
			}
		}
	}
	
	protected void renderView(ViewTree view) throws Exception {
		
		if (activeView != null) {
			Double scrollX = (Double) browser.evaluate("return window.scrollX;");
			Double scrollY = (Double) browser.evaluate("return window.scrollY;");
			activeView.setScrollX(scrollX.intValue());
			activeView.setScrollY(scrollY.intValue());
		}
		
		activeView = view;
		
		browser.addProgressListener(new ProgressListener() {
			
			@Override
			public void completed(ProgressEvent event) {
				browser.evaluate("window.scroll(" + activeView.getScrollX() + ", " + activeView.getScrollY() + ");");
				browser.removeProgressListener(this);
			}
			
			@Override
			public void changed(ProgressEvent event) {}
		});
		
		String format = view.getFormat();
		String content = view.getContent();
		
		if (format.equals("html")) {
			display(content);
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
				display("<html><body style=\"zoom:" + zoom + "\"><object data=\"" + image.getAbsolutePath() + "\" type=\"image/svg+xml\"></object></body></html>");
			}
			else if (log.exists()) {
				display(log);
			}
		}
		else if (format.equals("text")) {
			File temp = File.createTempFile("picto-renderer", ".txt");
			Files.write(Paths.get(temp.toURI()), content.getBytes());
			display(temp);
		}
		else {
			nothingToRender();
		}
	}
	
	protected void display(String text) {
		browser.setText(text);
	}
	
	protected void display(File file) {
		browser.setUrl(URI.createFileURI(file.getAbsolutePath()).toString());
	}
	
	@Override
	public void dispose() {
		super.dispose();
		if (editor != null)
			editor.removePropertyListener(listener);
	}

	@Override
	public void setFocus() {
		browser.setFocus();
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
			browser.execute("javascript:window.print();");
		}
	}
	
	public enum ZoomType {
		IN,
		OUT,
		ACTUAL
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
			if (type == ZoomType.IN) zoom = Math.min(zoom + 0.1, 3.0);
			else if (type == ZoomType.OUT) zoom = Math.max(0, zoom - 0.1);
			else zoom = 1.0;
			
			browser.execute("javascript:document.body.style.zoom=" + zoom + ";");
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
	
	protected PictoMetadata getRenderingMetadata(IEditorPart editorPart) {
		if (editor instanceof FlexmiEditor) {
			FlexmiResource resource = (FlexmiResource) getResource(editorPart);
			ProcessingInstruction renderProcessingInstruction = (ProcessingInstruction) ((FlexmiResource) resource).
						getProcessingInstructions().stream().filter(p -> p.getTarget().startsWith("render-")).findFirst().orElse(null);
			if (renderProcessingInstruction != null) {
				PictoMetadata metadata = new PictoMetadata();
				metadata.setFormat(renderProcessingInstruction.getTarget().substring("render-".length()));
				metadata.setFile(renderProcessingInstruction.getData().trim());
				return metadata;
			}
		}
		else if (editor instanceof IEditingDomainProvider || editor instanceof EmfaticEditor) {
			IFile file = getFile(editorPart);
			IFile renderingMetadataFile = file.getParent().getFile(Path.fromPortableString(file.getName() + ".picto"));
			if (renderingMetadataFile.exists()) {
				PictoMetadata metadata = new PictoMetadata();
				Properties properties = new Properties();
				try {
					properties.load(renderingMetadataFile.getContents(true));
					metadata.setFormat(properties.getProperty("format", "text"));
					metadata.setFile(properties.getProperty("file"));
					metadata.setNsuri(properties.getProperty("nsuri"));
					return metadata;
				} catch (Exception e) {
					LogUtil.log(e);
				}
			}
		}
		return null;
	}
	
	protected Resource getResource(IEditorPart editorPart) {
		if (editorPart instanceof FlexmiEditor) {
			IFile file = getFile(editorPart);
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new FlexmiResourceFactory());
			Resource resource = resourceSet.createResource(URI.createFileURI(file.getLocation().toOSString()));
			try {
				resource.load(null);
				return resource;
			} catch (IOException e) {
				LogUtil.log(e);
			}
		}
		else if (editorPart instanceof EmfaticEditor) {
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(getFile(editorPart).getContents()));
				EmfaticParserDriver parser = new EmfaticParserDriver(URI.createFileURI("some.emf"));
				ParseContext parseContext = parser.parse(reader);
				ResourceSet resourceSet = new ResourceSetImpl();
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new ResourceFactoryImpl());
				Resource resource = resourceSet.createResource(URI.createFileURI("some.ecore"));
				Builder builder = new Builder();
				NullProgressMonitor monitor = new NullProgressMonitor();
				builder.build(parseContext, resource, monitor);
				if (!parseContext.hasErrors()) {
					Connector connector = new Connector(builder);
					connector.connect(parseContext, resource, monitor);
				}
				
				boolean showStopper = false;
				for (ParseMessage pm : parseContext.getMessages()) {
					showStopper |= !(pm instanceof EmfaticSemanticWarning.EcoreValidatorDiagnostic);
				}
				
				if (!showStopper) {
					return resource;
				}
			} catch (Exception ex) {
				LogUtil.log(ex);
			}
		}
 		else if (editorPart instanceof IEditingDomainProvider) {
			return ((IEditingDomainProvider) editorPart).getEditingDomain().getResourceSet().getResources().get(0);
		}
		
		return null;
	}
	
	protected boolean supports(IWorkbenchPart editorPart) {
		return editorPart instanceof FlexmiEditor || 
				editorPart instanceof EmfaticEditor || 
				editorPart instanceof IEditingDomainProvider;
	}
	
	protected IFile getFile(IEditorPart editorPart) {
		if (editorPart instanceof FlexmiEditor) {
			return ((FlexmiEditor) editorPart).getFile();
		}
		else if (editorPart instanceof EmfaticEditor) {
			return ((EmfaticEditor) editorPart).getFile();
		}
		else if (editorPart instanceof IEditingDomainProvider) {
			IEditorInput input = editorPart.getEditorInput();
			if (input instanceof IFileEditorInput) {
				return ((IFileEditorInput)input).getFile();
			}
			else 
				return null;
		}
		return null;
	}
	
}
