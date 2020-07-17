package org.eclipse.epsilon.picto.transformers.elements;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.epsilon.common.dt.extensions.ExtensionPointManager;

public class HtmlElementTransformerExtensionPointManager extends ExtensionPointManager<HtmlElementTransformer>{

	@Override
	protected HtmlElementTransformer parse(IConfigurationElement element) throws Exception {
		return (HtmlElementTransformer) element.createExecutableExtension("class");
	}

	@Override
	protected String getExtensionPointId() {
		return "org.eclipse.epsilon.picto.htmlElementTransformer";
	}

}
