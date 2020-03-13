package org.eclipse.epsilon.picto.actions;

import org.eclipse.epsilon.picto.PictoPlugin;
import org.eclipse.epsilon.picto.PictoView;
import org.eclipse.jface.action.Action;

public class LockAction extends Action {
	
	protected PictoView pictoView;
	
	public LockAction(PictoView pictoView) {
		super("Lock", AS_CHECK_BOX);
		setImageDescriptor(PictoPlugin.getDefault().getImageDescriptor("icons/lock.gif"));
		this.pictoView = pictoView;
	}
	
	@Override
	public void run() {
		pictoView.setLocked(!pictoView.isLocked());
	}
}