package org.eclipse.epsilon.eugenia;

import org.eclipse.core.internal.resources.Workspace;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

public class GenerateAllDelegate implements IObjectActionDelegate {

	protected ISelection selection = null;
	protected Shell shell = null;
	protected GmfFileSet gmfFileSet = null;
	protected IWorkbenchPart targetPart = null;
	
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.shell = targetPart.getSite().getShell();
		this.targetPart = targetPart;
	}

	public void run(final IAction action) {
		Job job = new Job("Generating all GMF models") {
			protected IStatus run(IProgressMonitor monitor) {
				try {
					runImpl(action);
				} catch (Exception ex) {
					// Produce log message before displaying message
					// Swapping the order seems to prevent the message
					// from being logged
					LogUtil.log(ex);
					
					PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {

						public void run() {
							MessageDialog.openError(shell, "Error",
							"An error has occured. Please see the Error Log.");
						}
						
					});
				}
				return Status.OK_STATUS;
			}
		};
		job.setPriority(Job.SHORT);
		job.schedule(); // start as soon as possible
	}

	public void runImpl(final IAction action) throws Exception {
		
		// Clear previous files
		ClearGmfFileSetAction clearGmfFileSetAction = new ClearGmfFileSetAction();
		clearGmfFileSetAction.setSelection(selection);
		clearGmfFileSetAction.runImpl(action);
		
		if (getSelectedFile().getLocationURI().toString().equals(gmfFileSet.getEmfaticPath())) {
			// Do Emfatic to Ecore transformation
			Emfatic2EcoreDelegate emfatic2EcoreDelegate = new Emfatic2EcoreDelegate();
			emfatic2EcoreDelegate.setSelection(selection);
			emfatic2EcoreDelegate.runImpl(action);
			emfatic2EcoreDelegate.refresh();
		}
		
		// Do Ecore to GenModel transformation
		Ecore2GenModelDelegate ecore2GenModelDelegate = new Ecore2GenModelDelegate();
		ecore2GenModelDelegate.setSelection(this.selection);
		ecore2GenModelDelegate.runImpl(action);
		ecore2GenModelDelegate.refresh();
		
		WorkspaceUtil.waitFor(gmfFileSet.getGenModelPath());
		
		// Do Ecore  to GmfTool, GmfGraph and GmfMap
		GenerateToolGraphMapDelegate generateToolGraphMapDelegate = new GenerateToolGraphMapDelegate();
		generateToolGraphMapDelegate.setSelection(this.selection);
		generateToolGraphMapDelegate.run(action);
		generateToolGraphMapDelegate.refresh();
		
		WorkspaceUtil.waitFor(gmfFileSet.getGmfMapPath());
		
		// Do GmfMap to GmfGen
		GmfMap2GmfGenDelegate gmfMap2GmfGenDelegate = new GmfMap2GmfGenDelegate();
		gmfMap2GmfGenDelegate.setSelection(this.selection);
		gmfMap2GmfGenDelegate.run(action);
		gmfMap2GmfGenDelegate.refresh();
		
		WorkspaceUtil.waitFor(gmfFileSet.getGmfGenPath());
		
		// Do FixGmfGen
		FixGmfGenDelegate fixGmfGenDelegate = new FixGmfGenDelegate();
		fixGmfGenDelegate.setSelection(this.selection);
		fixGmfGenDelegate.run(action);
		
		// Generate code from EMF
		GenerateEmfCodeDelegate generateEmfCodeDelegate = new GenerateEmfCodeDelegate();
		generateEmfCodeDelegate.setSelection(this.selection);
		try {
			generateEmfCodeDelegate.runImpl(action);
		}
		catch (Throwable t) {
			t.printStackTrace();
		}
		System.err.println("DONE");
		getSelectedFile().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		
		
		// Generate diagram code from GmfGen
		final GenerateDiagramCodeDelegate generateDiagramCodeDelegate = new GenerateDiagramCodeDelegate();
		generateDiagramCodeDelegate.setSelection(selection);
		generateDiagramCodeDelegate.setTargetPart(targetPart);
		Display.getDefault().syncExec(new Runnable() {
			
			public void run() {
				try {
					generateDiagramCodeDelegate.runImpl(action);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}
	
	public IFile getSelectedFile() {
		IStructuredSelection selection = (IStructuredSelection) this.selection;
		IFile file = (IFile) selection.iterator().next();
		return file;
	}
	
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
		this.gmfFileSet = new GmfFileSet(getSelectedFile().getLocationURI().toString());
	}
	
}
