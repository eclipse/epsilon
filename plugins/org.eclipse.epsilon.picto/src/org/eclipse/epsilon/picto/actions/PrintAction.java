package org.eclipse.epsilon.picto.actions;

import org.eclipse.epsilon.picto.ViewRenderer;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class PrintAction extends Action {
	
	protected ViewRenderer viewRenderer = null;
	
	public PrintAction(ViewRenderer viewRenderer) {
		setText("Print");
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_PRINT_EDIT));
		this.viewRenderer = viewRenderer;
	}
	
	@Override
	public void run() {
		viewRenderer.getBrowser().execute("javascript:window.print();");
	}
}