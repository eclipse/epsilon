package org.eclipse.epsilon.picto.actions;

import org.eclipse.epsilon.picto.PictoView;
import org.eclipse.jface.action.Action;

public class RenderActiveViewAction extends Action {
	
	protected PictoView pictoView;
	
	public RenderActiveViewAction(PictoView pictoView) {
		setText("View rendered");
		this.pictoView = pictoView;
	}
	
	@Override
	public void run() {
		try {
			pictoView.renderView(pictoView.getActiveView());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}