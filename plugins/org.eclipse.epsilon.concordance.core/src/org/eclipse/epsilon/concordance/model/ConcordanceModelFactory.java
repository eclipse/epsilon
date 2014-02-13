/*******************************************************************************
 * Copyright (c) 2014 University of Twente.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Maarten Bezemer - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.concordance.model;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.common.dt.util.LogUtil;

/**
 * Factory that is able to produce basic {@link IModel} instances. The actual
 * instance implementation can be configured using the
 * <code>org.eclipse.epsilon.concordance.modelfactory</code> extension point
 */
public class ConcordanceModelFactory {
	public static final String MODEL_FACTORY_EXT_ID = "org.eclipse.epsilon.concordance.core.ConcordanceModelFactory";

	private static IConcordanceModelFactory factory = null;

	public static IConcordanceModelFactory getFactory() {
		if (factory == null) {
			IConfigurationElement[] elements = Platform.getExtensionRegistry()
					.getConfigurationElementsFor(MODEL_FACTORY_EXT_ID);
			if (elements.length >= 2) {
				LogUtil.log(IStatus.WARNING, 0,
						"Multiple ModelTypes are defined.", null);
			}

			if (elements.length != 0) {
				try {
					factory = (IConcordanceModelFactory) elements[0]
							.createExecutableExtension("factory");
				} catch (CoreException e) {
					// Failed... use default
					factory = new DefaultModelCreateFactory();
				}
			} else {
				// No specific factory is configured, so use default
				factory = new DefaultModelCreateFactory();
			}
		}
		return factory;
	}

	public static IConcordanceModel createModel(IResource resource) {
		return getFactory().createModel(resource);
	}

	public static IConcordanceModel createModel(IPath path) {
		return getFactory().createModel(path);
	}

	public static IConcordanceModel createModel(URI uri) {
		return getFactory().createModel(uri);
	}

	/**
	 * Default {@link IConcordanceModelFactory} implementation that creates {@link ConcordanceModel}
	 * instances.
	 */
	private static class DefaultModelCreateFactory implements IConcordanceModelFactory {

		@Override
		public IConcordanceModel createModel(IResource resource) {
			return new ConcordanceModel(resource);
		}

		@Override
		public IConcordanceModel createModel(IPath path) {
			return new ConcordanceModel(path);
		}

		@Override
		public IConcordanceModel createModel(URI uri) {
			return new ConcordanceModel(uri);
		}
	}
}
