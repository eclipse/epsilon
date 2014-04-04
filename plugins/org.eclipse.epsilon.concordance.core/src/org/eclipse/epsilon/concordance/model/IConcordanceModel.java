/*******************************************************************************
 * Copyright (c) 2014 University of Twente
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Maarten Bezemer - initial API
 ******************************************************************************/
package org.eclipse.epsilon.concordance.model;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Interface is used by Concordance to specify the model and its operations
 * 
 * Clients can implement this interface to provide a (client) specific way how a
 * model is being implemented.
 */
public interface IConcordanceModel {
	/**
	 * @return the workspace resource/location of the model or null if the model
	 *         is not a platform resource
	 */
	IResource getResource();

	/** @return the URI/location of the model */
	URI getUri();

	/** @return the namespace uri of the model */
	String getNsUri();

	boolean contains(String modelElementFragment);

	/** @return true if the model namespace is the same as the given nsUri */
	boolean isInstance(String nsUri);

	/**
	 * Gets the EMF resource belonging to the model. The resource may need to
	 * get loaded each time this method is called, or obtained from memory
	 * (cache).
	 * 
	 * @param resolve
	 *            when true all model proxies are resolved
	 * @return the EMF resource belonging to the model
	 * @throws IOException
	 *             when the model could not get loaded
	 */
	Resource getEmfResource(boolean resolve) throws IOException;

	/**
	 * Get all contents of the model. Note this method might call
	 * {@link #getEmfResource(boolean)}
	 * 
	 * @param resolve
	 *            when true all model proxies are resolved
	 * @return an iterator that will iterate over all model contents
	 * @throws IOException
	 *             when the model could not get loaded
	 * @see #getAllContents(boolean)
	 */
	public Iterator<EObject> getAllContentsIterator(boolean resolve) throws IOException;

	/**
	 * <p>
	 * Get all contents of the model. Note this method might call
	 * {@link #getEmfResource(boolean)}
	 * </p>
	 *
	 * <p>
	 * As this method creates a new list containing all contents, it might be
	 * better to use {@link #getAllContentsIterator(boolean)}, if result is just
	 * used to find some element for example.
	 * </p>
	 *
	 * @param resolve
	 *            when true all model proxies are resolved
	 * @return a <b>copied</b> list of all contents belonging to the model
	 * @throws IOException
	 *             when the model could not get loaded
	 * @see #getAllContentsIterator(boolean)
	 */
	Collection<EObject> getAllContents(boolean resolve) throws IOException;

	Set<CrossReference> getAllCrossReferences();

	Set<IConcordanceModel> getAllReferencedModels();

	void reconcileCrossReferences(IConcordanceModel original, IConcordanceModel moved);
}
