package org.eclipse.epsilon.picto;

import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPartReference;

public class PartListener implements IPartListener2 {

	@Override
	public void partActivated(IWorkbenchPartReference partRef) {}

	@Override
	public void partBroughtToTop(IWorkbenchPartReference partRef) {}

	@Override
	public void partClosed(IWorkbenchPartReference partRef) {}

	@Override
	public void partDeactivated(IWorkbenchPartReference partRef) {}

	@Override
	public void partOpened(IWorkbenchPartReference partRef) {}

	@Override
	public void partHidden(IWorkbenchPartReference partRef) {}

	@Override
	public void partVisible(IWorkbenchPartReference partRef) {}

	@Override
	public void partInputChanged(IWorkbenchPartReference partRef) {}

}
