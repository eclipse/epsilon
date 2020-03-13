package org.eclipse.epsilon.picto.actions;

import java.util.List;

import org.eclipse.epsilon.picto.PictoView;
import org.eclipse.epsilon.picto.ViewContent;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class RenderActiveViewAction extends Action {
	
	protected PictoView pictoView;
	protected List<ViewContent> viewContents;
	
	public RenderActiveViewAction(PictoView pictoView, List<ViewContent> viewContents) {
		setText("Close source view");
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_REMOVE_DISABLED));
		this.pictoView = pictoView;
		this.viewContents = viewContents;
	}
	
	@Override
	public void run() {
		try {
			for (ViewContent viewContent : viewContents) {
				viewContent.setActive(false);
			}
			pictoView.renderView(pictoView.getActiveView());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}