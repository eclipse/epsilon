package org.eclipse.epsilon.flexmi.dt;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class ContentTreeLabelProvider extends LabelProvider {
	
	Image diagramImage = Activator.getDefault().getImageDescriptor("icons/diagram.gif").createImage();
	Image folderImage = Activator.getDefault().getImageDescriptor("icons/folder.gif").createImage();
	
	@Override
	public String getText(Object element) {
		ContentTree contentTree = (ContentTree) element;
		if (contentTree.getName() == null || contentTree.getName().trim().length() == 0) {
			return "<empty>";
		}
		else return contentTree.getName();
	}
	
	@Override
	public Image getImage(Object element) {
		ContentTree contentTree = (ContentTree) element;
		if (contentTree.getContent() != null) {
			return diagramImage;
		}
		else {
			return folderImage;
		}
	}
}
