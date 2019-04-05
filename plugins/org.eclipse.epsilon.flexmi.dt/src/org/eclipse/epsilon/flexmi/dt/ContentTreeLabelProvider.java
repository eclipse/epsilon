package org.eclipse.epsilon.flexmi.dt;

import java.util.HashMap;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class ContentTreeLabelProvider extends LabelProvider {
	
	protected Image diagramImage = Activator.getDefault().getImageDescriptor("icons/diagram.gif").createImage();
	protected Image folderImage = Activator.getDefault().getImageDescriptor("icons/folder.gif").createImage();
	protected HashMap<String, Image> iconImages = new HashMap<String, Image>();
	
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
			Image icon = iconImages.get(contentTree.getIcon());
			if (icon == null) {
				icon = Activator.getDefault().getImageDescriptor("icons/" + contentTree.getIcon() + ".gif").createImage();
				iconImages.put(contentTree.getIcon(), icon);
			}
			return icon;
		}
		else {
			return folderImage;
		}
	}
}
