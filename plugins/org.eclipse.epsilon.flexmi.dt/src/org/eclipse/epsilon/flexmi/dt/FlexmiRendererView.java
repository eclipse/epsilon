package org.eclipse.epsilon.flexmi.dt;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.util.OperatingSystem;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.flexmi.FlexmiResource;
import org.eclipse.epsilon.flexmi.FlexmiResourceFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.w3c.dom.ProcessingInstruction;

public class FlexmiRendererView extends ViewPart {
	
	public static final String ID = "org.eclipse.epsilon.flexmi.dt.FlexmiRendererView";

	protected Browser browser;
	protected FlexmiEditor editor;
	protected FlexmiEditorPropertyListener listener = new FlexmiEditorPropertyListener();
	protected TreeViewer treeViewer;
	protected double zoom = 1.0;
	
	@Override
	public void createPartControl(Composite parent) {
		
		IActionBars bars = getViewSite().getActionBars();
		bars.getToolBarManager().add(new ZoomAction(true));
		bars.getToolBarManager().add(new ZoomAction(false));
		bars.getToolBarManager().add(new Separator());
		bars.getToolBarManager().add(new PrintAction());
		bars.getToolBarManager().add(new SyncAction());
		
		browser = new Browser(parent, SWT.NONE);
		
		IEditorPart activeEditor = getSite().getPage().getActiveEditor();
		if (activeEditor instanceof FlexmiEditor) {
			render((FlexmiEditor) activeEditor);
		} else {
			render(null);
		}

		final PartListener partListener = new PartListener() {
			@Override
			public void partActivated(IWorkbenchPartReference partRef) {
				if (partRef.getPart(false) instanceof FlexmiEditor) {
					render((FlexmiEditor) partRef.getPart(false));
				}
			}

			@Override
			public void partClosed(IWorkbenchPartReference partRef) {
				if (partRef.getPart(false) == FlexmiRendererView.this) {
					getSite().getPage().removePartListener(this);
				}
				else if (partRef.getPart(false) instanceof FlexmiEditor) {
					render(null);
				}
			}
		};
		
		this.getSite().getPage().addPartListener(partListener);

	}

	public void render(FlexmiEditor editor) {

		if (editor == null) {
			nothingToRender();
		} else {
			if (this.editor != null)
				this.editor.removePropertyListener(listener);
			this.editor = editor;
			editor.addPropertyListener(listener);
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					renderEditorContent();
				}
			});

		}
	}
	
	public void nothingToRender() {
		browser.setText("<html>Nothing to render.</html>");
	}
	
	public void renderEditorContent() {

		try {
			while (editor.getFile() == null) {
				Thread.sleep(100);
			}
			File flexmiFile = new File(editor.getFile().getLocation().toOSString());
			
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new FlexmiResourceFactory());
			FlexmiResource resource = (FlexmiResource) resourceSet
					.createResource(URI.createFileURI(flexmiFile.getAbsolutePath()));
			resource.load(null);
			
			ProcessingInstruction renderProcessingInstruction = (ProcessingInstruction) resource.
						getProcessingInstructions().stream().filter(p -> p.getTarget().startsWith("render-")).findFirst().orElse(null);
			
			if (renderProcessingInstruction != null) {
				EglTemplateFactoryModuleAdapter module = new EglTemplateFactoryModuleAdapter(
						new EglFileGeneratingTemplateFactory());
				module.parse(new File(flexmiFile.getParentFile(), renderProcessingInstruction.getData().trim()));
				IEglContext context = module.getContext();
				context.setOutputStream(EpsilonConsole.getInstance().getDebugStream());
				context.setErrorStream(EpsilonConsole.getInstance().getErrorStream());
				context.setWarningStream(EpsilonConsole.getInstance().getWarningStream());		
				
				InMemoryEmfModel model = new InMemoryEmfModel(resource);
				model.setName("M");
				module.getContext().getModelRepository().addModel(model);
				
				String format = renderProcessingInstruction.getTarget().substring("render-".length());
				
				if (format.equals("html")) {
					browser.setText(module.execute() + "");
				}
				else if (format.startsWith("graphviz-")) {
					
					String[] parts = format.split("-");
					
					String program = parts[1].trim();
					String imageType = "svg";
					if (parts.length > 2) {
						imageType = parts[2];
					}
					
					File temp = File.createTempFile("flexmi-renderer", ".dot");
					File image = new File(temp.getAbsolutePath() + "." + imageType);
					File log = new File(temp.getAbsolutePath() + ".log" );
					
					Files.write(Paths.get(temp.toURI()), (module.execute() + "").getBytes());
					
					if (!OperatingSystem.isWindows()) program = "/usr/local/bin/" + program;
					
					ProcessBuilder pb = new ProcessBuilder(new String[] {program, "-T" + imageType, temp.getAbsolutePath(), "-o", image.getAbsolutePath()});
					pb.redirectError(log);
					Process p = pb.start();
					p.waitFor();
					
					if (image.exists()) {
						browser.setText("<html><body style=\"zoom:" + zoom + "\"><img src='" + image.getAbsolutePath() + "'></img></body></html>");
					}
					else if (log.exists()) {
						browser.setUrl(URI.createFileURI(log.getAbsolutePath()).toString());
					}
				}
				else if (format.equals("text")) {
					File temp = File.createTempFile("flexmi-renderer", ".txt");
					Files.write(Paths.get(temp.toURI()), (module.execute() + "").getBytes());
					browser.setUrl(URI.createFileURI(temp.getAbsolutePath()).toString());
				}
				else {
					nothingToRender();
				}
			}
			else {
				nothingToRender();
			}
			
		} catch (Exception ex) {
			browser.setText("<html><pre>" + ex.getMessage() + "</pre></html>");
			ex.printStackTrace();
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
		browser.setFocus();
	}

	class FlexmiEditorPropertyListener implements IPropertyListener {
		@Override
		public void propertyChanged(Object source, int propId) {
			if (propId == FlexmiEditor.PROP_DIRTY && !editor.isDirty()) {
				renderEditorContent();
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
	
	class ZoomAction extends Action {
		
		boolean in = true;
		
		public ZoomAction(boolean in) {
			this.in = in;
			if (in) {
				setText("Zoom in");
				setImageDescriptor(Activator.getDefault().getImageDescriptor("icons/zoomin.gif"));
			}
			else {
				setText("Zoom out");
				setImageDescriptor(Activator.getDefault().getImageDescriptor("icons/zoomout.gif"));	
			}
		}
		
		@Override
		public void run() {
			if (in) zoom = Math.min(zoom + 0.1, 3.0);
			else zoom = Math.max(0, zoom - 0.1);
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
}
