package org.eclipse.epsilon.eugenia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.emc.emf.EmfModelResourceFactory;
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

public abstract class EugeniaWorkflowDelegate implements IObjectActionDelegate {

	protected IFile selectedFile;
	protected Shell shell;
	protected IWorkbenchPart targetPart;
	protected boolean successful = true;
	protected boolean showErrorDialog = true;

	private EugeniaActionDelegateStep firstStep = null;
	private EugeniaActionDelegateStep lastStep = null;
	private Map<EugeniaActionDelegateStep, List<IModel>> extraModels = new HashMap<EugeniaActionDelegateStep, List<IModel>>();

	public String getErrorMessage() {
		return "Generating some/all of the target models was "
				+ "unsucessful due to problems in the Ecore model. Please consult the Problems view for a "
				+ "detailed account of the problems encountered.";
	}
	
	protected abstract List<EugeniaActionDelegate> getDelegates();
	
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

					PlatformUI.getWorkbench().getDisplay()
							.syncExec(new Runnable() {

								public void run() {
									MessageDialog
											.openError(shell, "Error",
													"An error has occured. Please see the Error Log.");
								}

							});
				} finally {
					EmfModelResourceFactory.getInstance().clearCache();
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

		boolean foundFirst = false;
		EugeniaActionDelegateStep previousStep = null;

		// If unset, calculate first and last steps
		List<EugeniaActionDelegate> delegates = getDelegates();
		if (!delegates.isEmpty()) {
			if (firstStep == null)
				firstStep = delegates.get(0).getStep();
			if (lastStep == null)
				lastStep = delegates.get(delegates.size() - 1).getStep();
		}

		for (EugeniaActionDelegate delegate : delegates) {

			if (!foundFirst && getFirstStep() == delegate.getStep()) foundFirst = true; 
			else if (!foundFirst) continue;

			if (previousStep == getLastStep() && delegate.getStep() != getLastStep()) return;
			
			boolean passed = run(delegate, action);
			
			System.err.println(delegate + "->" + passed);
			
			if (!passed) {
				fail();
				return;
			}

			previousStep = delegate.getStep();
		}
	}

	public boolean isSuccessful() {
		return successful;
	}

	public void fail() {
		successful = false;
		if (showErrorDialog) {
			PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

				@Override
				public void run() {
					if (PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null) {
						MessageDialog.openError(PlatformUI.getWorkbench()
								.getActiveWorkbenchWindow().getShell(),
								"Eugenia", getErrorMessage());
					}
				}
			});
		}
	}

	public IFile getSelectedFile() {
		return selectedFile;
	}

	public void setSelectedFile(IFile file) {
		selectedFile = file;
	}

	public void setLastStep(EugeniaActionDelegateStep lastStep) {
		this.lastStep = lastStep;
	}

	public EugeniaActionDelegateStep getLastStep() {
		return lastStep;
	}

	public void setFirstStep(EugeniaActionDelegateStep firstStep) {
		this.firstStep = firstStep;
	}

	public EugeniaActionDelegateStep getFirstStep() {
		return firstStep;
	}

	public void addExtraModel(EugeniaActionDelegateStep step, IModel model) {
		if (!extraModels.containsKey(step)) {
			extraModels.put(step, new ArrayList<IModel>());
		}
		final List<IModel> extraModelsForStep = extraModels.get(step);
		extraModelsForStep.add(model);
	}

	private boolean run(final EugeniaActionDelegate delegate,
			final IAction action) throws Exception {
		delegate.setSelection(selectedFile);
		if (!delegate.isApplicable())
			return true;

		delegate.setExtraModels(extraModels.get(delegate.getStep()));

		if (delegate.requiresUIThread()) {
			Display.getDefault().syncExec(new Runnable() {
				public void run() {
					try {
						delegate.runImpl(action);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} else {
			delegate.runImpl(action);
		}
		delegate.refresh();
		
		if (delegate instanceof GuardedEcoreModelGenerationDelegate) {	
			return ((GuardedEcoreModelGenerationDelegate) delegate).isValid();
		} else {
			return true;
		}
	}

	public boolean isShowErrorDialog() {
		return showErrorDialog;
	}

	public void setShowErrorDialog(boolean showErrorDialog) {
		this.showErrorDialog = showErrorDialog;
	}

}
