package org.eclipse.epsilon.common.dt;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public abstract class AbstractEpsilonUIPlugin extends AbstractUIPlugin implements EpsilonPlugin {
	
	protected static HashMap<Class<?>, AbstractEpsilonUIPlugin> plugins = new HashMap<Class<?>, AbstractEpsilonUIPlugin>();
	protected ImageRegistry imageDescriptorRegistry;
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugins.put(this.getClass(), this);
		imageDescriptorRegistry = createImageRegistry();
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugins.remove(this.getClass());
		imageDescriptorRegistry.dispose();
	}
	
	public ImageDescriptor getImageDescriptor(String path) {
		
		ImageDescriptor imageDescriptor = imageDescriptorRegistry.getDescriptor(path);
		
		if (imageDescriptor == null) {
			URL url = FileLocator.find(getBundle(), new Path(path), Collections.emptyMap());
			if (url != null) {
				imageDescriptor = ImageDescriptor.createFromURL(url);
				if (imageDescriptor != null) imageDescriptorRegistry.put(path, imageDescriptor);
			}
		}
		
		return imageDescriptor;
	}
	
	public Image createImage(String path) {
		
		Image image = getImageRegistry().get(path);
		
		if (image == null) {
			try {
				ImageDescriptor imageDescriptor = getImageDescriptor(path);
				if (imageDescriptor != null) {
					image = getImageDescriptor(path).createImage();
					if (image != null) { getImageRegistry().put(path, image); }
				}
			}
			catch(Exception e) { LogUtil.log(e); }
		}
		
		return image;
	}
	
}
