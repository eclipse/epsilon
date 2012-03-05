package org.eclipse.epsilon.eugenia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.eol.models.IModel;
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

	private GenerateAllStep firstStep = GenerateAllStep.clean;
	private GenerateAllStep lastStep = GenerateAllStep.gmfcode;
	private Map<GenerateAllStep, List<IModel>> extraModels = new HashMap<GenerateAllStep, List<IModel>>();

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

	public void selectionChanged(IAction action, ISelection sel) {
		IStructuredSelection selection = (IStructuredSelection) sel;
		Iterator<?> iterator = selection.iterator();
		if (iterator.hasNext()) {
			setSelectedFile((IFile) iterator.next());
		}
	}

	public void runImpl(final IAction action) throws Exception {
		EpsilonConsole.getInstance().clear();

		if (isBeforeOrEqual(firstStep, GenerateAllStep.clean)) {
			clearModels(action);
		}
		if (isBeforeOrEqual(lastStep, GenerateAllStep.clean)) return;

		if (isBeforeOrEqual(firstStep, GenerateAllStep.ecore)) {
			generateEcoreModel(action);
		}
		if (isBeforeOrEqual(lastStep, GenerateAllStep.ecore)) return;

		// Do Ecore to GenModel transformation
		if (isBeforeOrEqual(firstStep, GenerateAllStep.genmodel)) {
			generateGenmodel(action);
		}
		if (isBeforeOrEqual(lastStep, GenerateAllStep.genmodel)) return;

		if (isBeforeOrEqual(firstStep, GenerateAllStep.gmf)) {
			generateGMFBasicModels(action);
		}
		if (isBeforeOrEqual(lastStep, GenerateAllStep.gmf)) return;

		if (isBeforeOrEqual(firstStep, GenerateAllStep.gmfgen)) {
			generateGMFGenModel(action);
		}
		if (isBeforeOrEqual(lastStep, GenerateAllStep.gmfgen)) return;

		// Generate code from EMF
		if (isBeforeOrEqual(firstStep, GenerateAllStep.emfcode)) {
			generateEMFCode(action);
		}
		if (lastStep.compareTo(GenerateAllStep.emfcode) <= 0) return;

		// Generate diagram code from GmfGen
		generateGMFCode(action);
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

	public void setFirstStep(GenerateAllStep firstStep) {
		this.firstStep = firstStep;
	}

	public GenerateAllStep getFirstStep() {
		return firstStep;
	}

	public void addExtraModel(GenerateAllStep step, IModel model) {
		if (!extraModels.containsKey(step)) {
			extraModels.put(step, new ArrayList<IModel>());
		}
		final List<IModel> extraModelsForStep = extraModels.get(step);
		extraModelsForStep.add(model);
	}

	private boolean isBeforeOrEqual(GenerateAllStep stepA, GenerateAllStep stepB) {
		return stepA.compareTo(stepB) <= 0;
	}

	private void clearModels(final IAction action) throws Exception {
		ClearGmfFileSetAction clearGmfFileSetAction = new ClearGmfFileSetAction();
		clearGmfFileSetAction.setSelectedFile(selectedFile);
		clearGmfFileSetAction.runImpl(action);
	}

	private void generateEcoreModel(final IAction action) throws Exception {
		if (getSelectedFile().getLocationURI().toString().equals(gmfFileSet.getEmfaticPath())) {
			// Do Emfatic to Ecore transformation
			Emfatic2EcoreDelegate emfatic2EcoreDelegate = new Emfatic2EcoreDelegate();
			emfatic2EcoreDelegate.setSelectedFile(selectedFile);
			emfatic2EcoreDelegate.runImpl(action);
			emfatic2EcoreDelegate.refresh();
		}
	}

	private void generateGenmodel(final IAction action) throws Exception {
		EugeniaActionDelegate ecore2GenModelDelegate = new Ecore2GenModelDelegate();
		ecore2GenModelDelegate.setClearConsole(false);
		ecore2GenModelDelegate.setSelectedFile(selectedFile);
		ecore2GenModelDelegate.setExtraModels(extraModels.get(GenerateAllStep.genmodel));
		ecore2GenModelDelegate.runImpl(action);
		ecore2GenModelDelegate.refresh();

		FixGenModelDelegate fixEcoreGenModelDelegate = new FixGenModelDelegate();
		fixEcoreGenModelDelegate.setClearConsole(false);
		fixEcoreGenModelDelegate.setSelectedFile(selectedFile);
		fixEcoreGenModelDelegate.setExtraModels(extraModels.get(GenerateAllStep.genmodel));
		fixEcoreGenModelDelegate.runImpl(action);
		fixEcoreGenModelDelegate.refresh();
	}

	private void generateGMFBasicModels(final IAction action) throws Exception {
		// Do Ecore  to GmfTool, GmfGraph and GmfMap
		GenerateToolGraphMapDelegate generateToolGraphMapDelegate = new GenerateToolGraphMapDelegate();
		generateToolGraphMapDelegate.setClearConsole(false);
		generateToolGraphMapDelegate.setSelectedFile(selectedFile);
		generateToolGraphMapDelegate.setExtraModels(extraModels.get(GenerateAllStep.gmf));
		generateToolGraphMapDelegate.runImpl(action);
		generateToolGraphMapDelegate.refresh();
	}

	private void generateGMFGenModel(final IAction action) throws Exception {
		// Do GmfMap to GmfGen
		GmfMap2GmfGenDelegate gmfMap2GmfGenDelegate = new GmfMap2GmfGenDelegate();
		gmfMap2GmfGenDelegate.setClearConsole(false);
		gmfMap2GmfGenDelegate.setSelectedFile(selectedFile);
		gmfMap2GmfGenDelegate.setExtraModels(extraModels.get(GenerateAllStep.gmfgen));
		gmfMap2GmfGenDelegate.runImpl(action);
		gmfMap2GmfGenDelegate.refresh();

		// Do FixGmfGen
		FixGmfGenDelegate fixGmfGenDelegate = new FixGmfGenDelegate();
		fixGmfGenDelegate.setClearConsole(false);
		fixGmfGenDelegate.setSelectedFile(selectedFile);
		fixGmfGenDelegate.runImpl(action);
	}

	private void generateEMFCode(final IAction action) throws Exception {
		GenerateEmfCodeDelegate generateEmfCodeDelegate = new GenerateEmfCodeDelegate();
		generateEmfCodeDelegate.setSelectedFile(selectedFile);
		generateEmfCodeDelegate.runImpl(action);
		getSelectedFile().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
	}

	private void generateGMFCode(final IAction action) {
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

}
