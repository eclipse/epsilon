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
package org.eclipse.epsilon.epl.dt;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class EplPlugin extends AbstractUIPlugin implements EpsilonPlugin{

	//The shared instance.
	private static EplPlugin plugin;
	
	/**
	 * The constructor.
	 */
	public EplPlugin() {
		plugin = this;
	}

	/**
	 * This method is called upon plug-in activation
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
	}

	/**
	 * Returns the shared instance.
	 */
	public static EplPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns an image transformationStrategyExtension for the image file at the given
	 * plug-in relative path.
	 *
	 * @param path the path
	 * @return the image transformationStrategyExtension
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.epsilon.epl.dt", path);
	}
	
	/**
	 * This method returns an image from the path
	 * @param path
	 * @return
	 */
	public Image createImage(String path) {
		try {
			URL BASE_URL = EplPlugin.getDefault().getBundle().getEntry("/");
			URL url = new URL(BASE_URL, path);
			return ImageDescriptor.createFromURL(url).createImage();
		}
		catch(MalformedURLException e) {}
		return null;
	}
}
