package org.eclipse.epsilon.common.dt;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public abstract class AbstractEpsilonUIPlugin extends AbstractUIPlugin implements EpsilonPlugin {
	
	protected static HashMap<Class<?>, AbstractEpsilonUIPlugin> plugins = new HashMap<Class<?>, AbstractEpsilonUIPlugin>();
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugins.put(this.getClass(), this);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugins.remove(this.getClass());
	}
	
	public ImageDescriptor getImageDescriptor(String path) {
		try {
			URL BASE_URL = getBundle().getEntry("/");
			URL url = new URL(BASE_URL, path);
			return ImageDescriptor.createFromURL(url);
		}
		catch (MalformedURLException e) {
			return null;
		}
	}
	
	public Image createImage(String path) {
		
		Image image = getImageRegistry().get(path);
		
		if (image == null) {
			try {
				image = getImageDescriptor(path).createImage();
				if (image != null) { getImageRegistry().put(path, image); }
				
			}
			catch(Exception e) { LogUtil.log(e); }
		}
		
		return image;
	}
	
}
