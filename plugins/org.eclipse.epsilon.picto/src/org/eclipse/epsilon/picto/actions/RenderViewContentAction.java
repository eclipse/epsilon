package org.eclipse.epsilon.picto.actions;

import org.eclipse.epsilon.picto.ViewContent;
import org.eclipse.epsilon.picto.ViewRenderer;
import org.eclipse.jface.action.Action;

public class RenderViewContentAction extends Action {
		
	protected ViewContent viewContent;
	protected ViewRenderer viewRenderer;
	
	public RenderViewContentAction(ViewContent viewContent, ViewRenderer viewRenderer) {
		super("View " + viewContent.getFormat() + " source", AS_CHECK_BOX);
		this.viewContent = viewContent;
		this.viewRenderer = viewRenderer;
	}
	
	@Override
	public void run() {
		viewRenderer.display(new ViewContent("text", viewContent.getText()).getNext(viewRenderer).getFile());
	}
	
}