package org.eclipse.epsilon.picto.actions;

import org.eclipse.epsilon.picto.PictoView;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class SyncAction extends Action {
	
	protected PictoView pictoView;
	
	public SyncAction(PictoView pictoView) {
		setText("Sync");
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));
		this.pictoView = pictoView;
	}
	
	@Override
	public void run() {
		pictoView.render(pictoView.getEditor());
	}
}