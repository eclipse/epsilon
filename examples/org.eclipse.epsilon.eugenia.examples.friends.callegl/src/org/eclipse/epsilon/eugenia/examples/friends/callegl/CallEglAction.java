package org.eclipse.epsilon.eugenia.examples.friends.callegl;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;

import friends.FriendsPackage;
import friends.diagram.part.FriendsDiagramEditor;


public class CallEglAction implements IWorkbenchWindowActionDelegate {

	/**
	 * The constructor.
	 */
	public CallEglAction() {
	}

	public void run(IAction action) {
		
		// Get the active editor
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		
		// This is only meaningful if the editor is a Friends diagram editor
		if (editor instanceof FriendsDiagramEditor) {
			FriendsDiagramEditor friendsDiagramEditor = 
				(FriendsDiagramEditor) editor;
			
			// Get the EMF model under the editor
			Resource resource = getFirstSemanticModelResource(
					friendsDiagramEditor.getEditingDomain().
					getResourceSet());
			
			if (resource == null) return;
			
			// Wrap it as an InMemoryEmfModel
			InMemoryEmfModel m = new InMemoryEmfModel("M", resource, FriendsPackage.eINSTANCE);
			
			// Construct the EGL module
			EglTemplateFactoryModuleAdapter module = 
				new EglTemplateFactoryModuleAdapter(new EglFileGeneratingTemplateFactory());
			
			try {
				
				// Parse the EGL module and add to it the wrapped model
				URI uri = Activator.getDefault().getBundle().getResource("templates/example.egl").toURI();
				module.parse(uri);
				module.getContext().getModelRepository().addModel(m);
				
				IFile modelFile = ResourcesPlugin.getWorkspace().getRoot().
					getFile(new Path(resource.getURI().path().substring("/resource/".length())));
				
				FileOutputStream fos = new FileOutputStream(
						new File(modelFile.getLocation().toOSString() + ".gen.txt"));
				
				// Execute the EGL module and write the result to
				// a file next to the model
				fos.write((module.execute() + "").getBytes());
				fos.flush(); fos.close();
				
				modelFile.getParent().refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
				
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}
	}
	
	public Resource getFirstSemanticModelResource(ResourceSet resourceSet) {
		for (Resource resource : resourceSet.getResources()) {
			if (!(resource instanceof GMFResource)) {
				return resource;
			}
		}
		return null;
	}
	
	public void selectionChanged(IAction action, ISelection selection) {}

	public void dispose() {}

	public void init(IWorkbenchWindow window) { }
}