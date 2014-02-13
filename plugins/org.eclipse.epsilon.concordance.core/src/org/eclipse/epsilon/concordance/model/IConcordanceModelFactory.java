/*******************************************************************************
 * Copyright (c) 2014 University of Twente.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Maarten Bezemer - initial API
 ******************************************************************************/
package org.eclipse.epsilon.concordance.model;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;

/**
 * <p>
 * Interface for the model creation factory, it provides multiple methods to
 * create {@link IModel} instances, using different ways of defining the actual
 * model.
 * </p>
 * 
 * <p>
 * Register the factory using the
 * <code>org.eclipse.epsilon.concordance.modeltype</code> extension point.
 * </p>
 */
public interface IConcordanceModelFactory {
	/** Create an {@link IModel} instance for the given resource */
	public IConcordanceModel createModel(IResource resource);

	/** Create an {@link IModel} instance for the given path */
	public IConcordanceModel createModel(IPath path);

	/** Create an {@link IModel} instance for the given uri */
	public IConcordanceModel createModel(URI uri);
}
