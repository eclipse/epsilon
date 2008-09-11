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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;

public class ExeedItemProviderAdapterFactory extends
		ReflectiveItemProviderAdapterFactory {
	
	protected ImageTextProvider imageTextProvider = null;
	
	public ExeedItemProviderAdapterFactory(ExeedPlugin plugin) {
		super();
		reflectiveItemProviderAdapter = new ExeedItemProvider(this, plugin);
	}

	public void setImageTextProvider(ImageTextProvider imageTextProvider) {
		this.imageTextProvider = imageTextProvider;
		((ExeedItemProvider) reflectiveItemProviderAdapter)
				.setImageTextProvider(imageTextProvider);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the
	 * adapter.
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		//Thread.dumpStack();
		//return reflectiveItemProviderAdapter;
		return super.adapt(notifier, type);
	}
	
	public ExeedItemProvider getItemProvider() {
		return (ExeedItemProvider) reflectiveItemProviderAdapter;
	}
	
}
