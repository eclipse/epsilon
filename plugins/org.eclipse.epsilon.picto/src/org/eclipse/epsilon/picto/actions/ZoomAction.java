package org.eclipse.epsilon.picto.actions;

import org.eclipse.epsilon.picto.PictoPlugin;
import org.eclipse.epsilon.picto.ViewRenderer;
import org.eclipse.epsilon.picto.ViewRenderer.ZoomType;
import org.eclipse.jface.action.Action;

public class ZoomAction extends Action {
		
	protected ZoomType type;
	protected ViewRenderer viewRenderer;
	
	
	public ZoomAction(ZoomType type, ViewRenderer viewRenderer) {
		this.type = type;
		this.viewRenderer = viewRenderer;
		if (type == ZoomType.IN) {
			setText("Zoom in");
			setImageDescriptor(PictoPlugin.getDefault().getImageDescriptor("icons/zoomin.gif"));
		}
		else if (type == ZoomType.OUT){
			setText("Zoom out");
			setImageDescriptor(PictoPlugin.getDefault().getImageDescriptor("icons/zoomout.gif"));	
		}
		else {
			setText("Reset");
			setImageDescriptor(PictoPlugin.getDefault().getImageDescriptor("icons/zoomactual.gif"));		
		}
	}
	
	@Override
	public void run() {
		viewRenderer.zoom(type);
	}
}