package org.eclipse.epsilon.picto.transformers;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.epsilon.common.dt.extensions.ExtensionPointManager;

public class ViewContentTransformerExtensionPointManager extends ExtensionPointManager<ViewContentTransformer>{
	
	@Override
	protected ViewContentTransformer parse(IConfigurationElement element) throws Exception {
		return (ViewContentTransformer) element.createExecutableExtension("class");
	}

	@Override
	protected String getExtensionPointId() {
		return "org.eclipse.epsilon.picto.viewContentTransformer";
	}

}
