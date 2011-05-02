package org.eclipse.epsilon.eugenia;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
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

	private IFile selectedFile;
	private GmfFileSet gmfFileSet;
	private Shell shell;
	private IWorkbenchPart targetPart;
	private GenerateAllStep lastStep = GenerateAllStep.gmfcode;

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
		
		EpsilonConsole.getInstance().clear();
		
		// Clear previous files
		ClearGmfFileSetAction clearGmfFileSetAction = new ClearGmfFileSetAction();
		clearGmfFileSetAction.setSelectedFile(selectedFile);
		clearGmfFileSetAction.runImpl(action);
		if (lastStep.compareTo(GenerateAllStep.clean) <= 0) return;

		if (getSelectedFile().getLocationURI().toString().equals(gmfFileSet.getEmfaticPath())) {
			// Do Emfatic to Ecore transformation
			Emfatic2EcoreDelegate emfatic2EcoreDelegate = new Emfatic2EcoreDelegate();
			emfatic2EcoreDelegate.setSelectedFile(selectedFile);
			emfatic2EcoreDelegate.runImpl(action);
			emfatic2EcoreDelegate.refresh();
		}
		// Using compareTo instead of == is a bit more error-proof if we add new steps
		// or rearrange them.
		if (lastStep.compareTo(GenerateAllStep.ecore) <= 0) return;

		// Do Ecore to GenModel transformation
		Ecore2GenModelDelegate ecore2GenModelDelegate = new Ecore2GenModelDelegate();
		ecore2GenModelDelegate.setClearConsole(false);
		ecore2GenModelDelegate.setSelectedFile(selectedFile);
		ecore2GenModelDelegate.runImpl(action);
		ecore2GenModelDelegate.refresh();

		WorkspaceUtil.waitFor(gmfFileSet.getGenModelPath());
		if (lastStep.compareTo(GenerateAllStep.genmodel) <= 0) return;
		
		// Do Ecore  to GmfTool, GmfGraph and GmfMap
		GenerateToolGraphMapDelegate generateToolGraphMapDelegate = new GenerateToolGraphMapDelegate();
		generateToolGraphMapDelegate.setClearConsole(false);
		generateToolGraphMapDelegate.setSelectedFile(selectedFile);
		generateToolGraphMapDelegate.run(action);
		generateToolGraphMapDelegate.refresh();

		WorkspaceUtil.waitFor(gmfFileSet.getGmfMapPath());
		
		// Do GmfMap to GmfGen
		GmfMap2GmfGenDelegate gmfMap2GmfGenDelegate = new GmfMap2GmfGenDelegate();
		gmfMap2GmfGenDelegate.setClearConsole(false);
		gmfMap2GmfGenDelegate.setSelectedFile(selectedFile);
		gmfMap2GmfGenDelegate.run(action);
		gmfMap2GmfGenDelegate.refresh();
		
		WorkspaceUtil.waitFor(gmfFileSet.getGmfGenPath());
		
		// Do FixGmfGen
		FixGmfGenDelegate fixGmfGenDelegate = new FixGmfGenDelegate();
		fixGmfGenDelegate.setClearConsole(false);
		fixGmfGenDelegate.setSelectedFile(selectedFile);
		fixGmfGenDelegate.run(action);
		if (lastStep.compareTo(GenerateAllStep.gmf) <= 0) return;

		// Generate code from EMF
		GenerateEmfCodeDelegate generateEmfCodeDelegate = new GenerateEmfCodeDelegate();
		generateEmfCodeDelegate.setSelectedFile(selectedFile);
		try {
			generateEmfCodeDelegate.runImpl(action);
		}
		catch (Throwable t) {
			t.printStackTrace();
		}
		
		getSelectedFile().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		if (lastStep.compareTo(GenerateAllStep.emfcode) <= 0) return;

		// Generate diagram code from GmfGen
		final GenerateDiagramCodeDelegate generateDiagramCodeDelegate = new GenerateDiagramCodeDelegate();
		generateDiagramCodeDelegate.setSelectedFile(selectedFile);
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
		return selectedFile;
	}

	public void setSelectedFile(IFile file) {
		selectedFile = file;
		gmfFileSet = new GmfFileSet(selectedFile.getLocationURI().toString());
	}

	public void setLastStep(GenerateAllStep lastStep) {
		this.lastStep = lastStep;
	}

	public GenerateAllStep getLastStep() {
		return lastStep;
	}

	public void selectionChanged(IAction action, ISelection sel) {
		IStructuredSelection selection = (IStructuredSelection) sel;
		setSelectedFile((IFile) selection.iterator().next());
	}
	
}
