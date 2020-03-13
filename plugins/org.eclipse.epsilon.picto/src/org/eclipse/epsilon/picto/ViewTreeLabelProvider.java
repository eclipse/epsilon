/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.picto;

import java.util.HashMap;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;

public class ViewTreeLabelProvider extends LabelProvider {
	
	protected Image diagramImage = PictoPlugin.getDefault().getImageDescriptor("icons/diagram.gif").createImage();
	protected Image folderImage = PictoPlugin.getDefault().getImageDescriptor("icons/folder.gif").createImage();
	protected HashMap<String, Image> iconImages = new HashMap<>();
	
	@Override
	public String getText(Object element) {
		ViewTree contentTree = (ViewTree) element;
		if (contentTree.getName() == null || contentTree.getName().trim().length() == 0) {
			return "<empty>";
		}
		else return contentTree.getName();
	}
	
	@Override
	public Image getImage(Object element) {
		
		ViewTree contentTree = (ViewTree) element;
		String iconName = contentTree.getIcon();
		Image icon = iconImages.get(iconName);
		
		if (icon == null) {
			if (iconName.matches("diagram-.*")) {
				icon = getColoredDiagramIcon(iconName.replace("diagram-", ""));
			}
			else {
				icon = PictoPlugin.getDefault().getImageDescriptor("icons/" + iconName + ".gif").createImage();
			}
			iconImages.put(contentTree.getIcon(), icon);
		}
		
		return icon;
	}
	
	protected Image getColoredDiagramIcon(String color) {
		Image icon = PictoPlugin.getDefault().getImageDescriptor("icons/diagram.gif").createImage();
		ImageData imageData = icon.getImageData();
		int hex = Integer.decode("0x" + color);
		for (int i=2;i<7;i++) {
			imageData.setPixel(i, 2, hex);
		}
		for (int i=10;i<15;i++) {
			imageData.setPixel(i, 8, hex);
		}
		return new Image(Display.getCurrent(), imageData);
	}
	
}
