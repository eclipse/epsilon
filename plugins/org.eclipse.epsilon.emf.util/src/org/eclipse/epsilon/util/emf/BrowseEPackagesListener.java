/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.util.emf;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

public abstract class BrowseEPackagesListener implements Listener {

	public void handleEvent(Event event) {
		ElementListSelectionDialog dialog = new ElementListSelectionDialog( 
				Display.getDefault().getActiveShell(), 
				new LabelProvider() {

					@Override
					public String getText(Object element) {
						return (String) element;
					}
					
					Image image = null;
					
					@Override
					public Image getImage(Object element) {
						if (image == null) {
							image = EmfUtilPlugin.getImageDescriptor("icons/epackage.png").createImage();
						}
						return image;
					}
					
				});
		
		dialog.setMessage("Select an EPackage");
		dialog.setTitle("Registered EPackages");
		
		List<String> ePackages = new ArrayList<String>();
		ePackages.addAll(EPackage.Registry.INSTANCE.keySet());
		
		dialog.setElements(ePackages.toArray());
		
		if (dialog.open() == Window.OK) {
			if (dialog.getResult().length > 0) {
				selectionChanged((String) dialog.getResult()[0]);
			}
		}
	}
	
	public abstract void selectionChanged(String ePackageUri);
		
}