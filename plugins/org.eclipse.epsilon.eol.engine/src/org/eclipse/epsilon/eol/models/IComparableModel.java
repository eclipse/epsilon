/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.models;

public interface IComparableModel extends IModel {

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
	public abstract Object computeDifferencesWith(IComparableModel otherModel) throws Exception;

}