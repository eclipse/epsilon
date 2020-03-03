package org.eclipse.epsilon.picto.source;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.epsilon.common.dt.extensions.ExtensionPointManager;

public class PictoSourceExtensionPointManager extends ExtensionPointManager<PictoSource>{
	
	@Override
	protected PictoSource parse(IConfigurationElement element) throws Exception {
		return (PictoSource) element.createExecutableExtension("class");
	}

	@Override
	protected String getExtensionPointId() {
		return "org.eclipse.epsilon.picto.pictoSource";
	}

}
