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
package org.eclipse.epsilon.dt.exeed;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class ExeedPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.epsilon.dt.exeed";

	// The shared instance
	private static ExeedPlugin plugin;
	
	/**
	 * The constructor
	 */
	public ExeedPlugin() {
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ExeedPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	
	ImageRegistry imageRegistry = null; //new ImageRegistry();
	
	public ImageDescriptor getImageDescriptor(String path) {
		
		if (imageRegistry == null) imageRegistry = new ImageRegistry();
		
		ImageDescriptor descriptor = null;
		if (imageRegistry.getDescriptor(path) != null) {
			descriptor = imageRegistry.getDescriptor(path);
		}
		else {
			descriptor = imageDescriptorFromPlugin(getPluginId(), path);
			if (descriptor == null) {
				if (getSecondaryPluginId() != null) {
					descriptor = imageDescriptorFromPlugin(getSecondaryPluginId(), path);
				}
			}
			imageRegistry.put(path, descriptor);
		}
		return descriptor;
	}

	protected String getPluginId() {
		return PLUGIN_ID;
	}
	
	protected String getSecondaryPluginId() {
		return null;
	}

}
