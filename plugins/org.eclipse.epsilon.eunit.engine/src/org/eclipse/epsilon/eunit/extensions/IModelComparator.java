/*******************************************************************************
 * Copyright (c) 2011 Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio García-Domínguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eunit.extensions;

import org.eclipse.epsilon.eol.models.IModel;

/**
 * Interface for a model comparator. They compare entire models and return a set
 * of relevant differences, if any exist. Comparators may only be able to compare
 * certain models, based on various criteria.
 */
public interface IModelComparator {

	String EXTENSION_POINT_ID = "org.eclipse.epsilon.eunit.engine.comparator";

	/**
	 * Checks if the comparator can compare these two models.
	 * 
	 * @return <code>true</code> if {@link #compare(IModel, IModel)} should
	 *         finish successfully, and <tt>false</tt> otherwise.
	 */
	boolean canCompare(IModel m1, IModel m2);

	/**
	 * Returns an object with the differences between this model and
	 * <code>otherModel</code>. If there are no differences, returns
	 * <code>null</code>.
	 *
	 * The exact configuration of the comparison depends on the model. For
	 * instance, unique identifiers (such as XMI IDs) may be ignored if the main
	 * object of these comparisons is to test model transformations. These tend
	 * to produce different unique identifiers each time they are run.
	 * 
	 * @throws IllegalArgumentException
	 *             The models cannot be compared: for instance, they use
	 *             incompatible drivers.
	 * @throws Exception
	 *             There was some other kind of problem when performing the
	 *             comparison.
	 */
	Object compare(IModel m1, IModel m2) throws Exception;

}
