/*******************************************************************************
 * Copyright (c) 2008-2012 The University of York, Antonio Garc��a-Dom��nguez
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio Garc��a-Dom��nguez - clean up and improve error reporting
 ******************************************************************************/
package org.eclipse.epsilon.dt.exeed;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.jface.resource.ImageDescriptor;

public class ExeedImageTextProvider {
	
	protected EObjectImageTextProvider imageTextProvider = null;
	protected ExeedPlugin plugin = null;
	protected ExeedEditor editor = null;
	
	public ExeedImageTextProvider(InMemoryEmfModel model, ExeedPlugin plugin, ExeedEditor editor) {
		this.plugin = plugin;
		this.editor = editor;
		
		this.imageTextProvider = new EObjectImageTextProvider(model, 
				EpsilonConsole.getInstance().getDebugStream(), 
				EpsilonConsole.getInstance().getErrorStream(), 
				plugin.getPreferenceStore().getBoolean(ExeedPreferencePage.SHOW_STRUCTURAL_INFO)) {
			
			@Override
			protected void logException(Exception ex) {
				LogUtil.log(ex);
			}
		};
		
	}

	public String getEStructuralFeatureLabel(EStructuralFeature feature, String def) {
		return imageTextProvider.getEStructuralFeatureLabel(feature, def);
	}

	public String getEObjectLabel(Object object, String def, boolean forReference) {
		return imageTextProvider.getEObjectLabel(object, def, forReference);
	}

	public String getEObjectReferenceLabel(Object object, String def) {
		return imageTextProvider.getEObjectReferenceLabel(object, def);
	}	
	
	public ImageDescriptor getEObjectImageDescriptor(Object object, ImageDescriptor def) {
		if (!(object instanceof EObject)) return def;

		String icon = imageTextProvider.getEObjectImage(object, null);
		ImageDescriptor imageDescriptor = getImageDescriptor(icon);
		if (imageDescriptor != null) {
			return imageDescriptor;
		}
		return def;
	}

	public ImageDescriptor getEClassImageDescriptor(EClass eClass, ImageDescriptor def) {
		String icon = imageTextProvider.getEClassImage(eClass, null);
		ImageDescriptor imageDescriptor = getImageDescriptor(icon);
		if (imageDescriptor != null) {
			return imageDescriptor;
		}
		return def;
	}

	public boolean isShowStructuralInfo() {
		return imageTextProvider.isShowStructuralInfo();
	}

	public void setShowStructuralInfo(boolean showStructuralInfo) {
		imageTextProvider.setShowStructuralInfo(showStructuralInfo);
	}

	private ImageDescriptor getImageDescriptor(String icon) {
		ImageDescriptor imageDescriptor = null;
		
		imageDescriptor = plugin.getImageDescriptor(editor.getPluginId(), "icons/" + icon + ".gif");
		if (imageDescriptor == null) {
			imageDescriptor = plugin.getImageDescriptor(editor.getPluginId(), "icons/" + icon + ".png");
		}
		
		return imageDescriptor;
	}

}
