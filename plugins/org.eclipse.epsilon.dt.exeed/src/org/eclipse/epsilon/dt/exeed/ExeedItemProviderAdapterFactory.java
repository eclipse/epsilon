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

import java.util.Map;

import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.epsilon.dt.exeed.extensions.IViewerCustomizer;

public class ExeedItemProviderAdapterFactory extends ReflectiveItemProviderAdapterFactory {
	protected ExeedImageTextProvider imageTextProvider = null;

	public ExeedItemProviderAdapterFactory(ExeedPlugin plugin, Map<Class<?>, IViewerCustomizer> resourceClassToCustomizerMap) {
		super();
		reflectiveItemProviderAdapter = new ExeedItemProvider(this, plugin, resourceClassToCustomizerMap);
	}

	public void setImageTextProvider(ExeedImageTextProvider imageTextProvider) {
		this.imageTextProvider = imageTextProvider;
		((ExeedItemProvider) reflectiveItemProviderAdapter)
				.setImageTextProvider(imageTextProvider);
	}

	public ExeedItemProvider getItemProvider() {
		return (ExeedItemProvider) reflectiveItemProviderAdapter;
	}
}
