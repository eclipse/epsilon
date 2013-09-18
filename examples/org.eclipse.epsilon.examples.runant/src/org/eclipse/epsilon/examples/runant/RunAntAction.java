package org.eclipse.epsilon.examples.runant;

import org.eclipse.ant.launching.IAntLaunchConstants;
import org.eclipse.core.resources.IFile;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.externaltools.internal.model.IExternalToolConstants;

public class RunAntAction implements IObjectActionDelegate {

	protected Shell shell;
	protected IStructuredSelection selection = null;
	
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	public void run(IAction action) {
		
		try {
		
			IFile iFile = (IFile) selection.getFirstElement();
			
			ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
			ILaunchConfigurationType lcType = launchManager.getLaunchConfigurationType(IAntLaunchConstants.ID_ANT_LAUNCH_CONFIGURATION_TYPE);
			 
			String name = launchManager.generateLaunchConfigurationName("Run ANT");
			ILaunchConfigurationWorkingCopy wc = lcType.newInstance(null, name);
			wc.setAttribute(ILaunchManager.ATTR_PRIVATE, true);
			wc.setAttribute(IExternalToolConstants.ATTR_LOCATION, iFile.getLocation().toOSString());
			 
			wc.launch(ILaunchManager.RUN_MODE, null);	
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = (IStructuredSelection) selection;
	}

}
