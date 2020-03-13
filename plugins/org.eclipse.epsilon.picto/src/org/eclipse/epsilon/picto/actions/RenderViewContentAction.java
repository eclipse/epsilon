package org.eclipse.epsilon.picto.actions;

import java.util.List;

import org.eclipse.epsilon.picto.ViewContent;
import org.eclipse.epsilon.picto.ViewRenderer;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class RenderViewContentAction extends Action {
		
	protected ViewContent viewContent;
	protected ViewRenderer viewRenderer;
	protected List<ViewContent> viewContents;
	
	public RenderViewContentAction(ViewContent viewContent, List<ViewContent> viewContents, ViewRenderer viewRenderer) {
		super(viewContent.getLabel() + " source", AS_CHECK_BOX);
		this.viewContent = viewContent;
		this.viewRenderer = viewRenderer;
		this.viewContents = viewContents;
		this.setChecked(viewContent.isActive());
	}
	
	@Override
	public void run() {
		viewContent.setActive(true);
		this.setChecked(viewContent.isActive());
		for (ViewContent other : viewContents) {
			if (other != viewContent) {
				other.setActive(false);
			}
		}
		viewRenderer.display(new ViewContent("text", viewContent.getText()).getNext(viewRenderer).getFile());
	}
	
}