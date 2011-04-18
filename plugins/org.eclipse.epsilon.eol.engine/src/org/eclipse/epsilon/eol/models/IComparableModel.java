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
	 * Returns <code>true</code> if the other model has the same contents as
	 * this one. Unique identifiers may be ignored: the main object of this
	 * comparison is to test model transformations, which tend to produce
	 * different unique identifiers each time they are run.
	 * 
	 * @throws IllegalArgumentException
	 *             The models cannot be compared: for instance, they use
	 *             incompatible drivers.
	 */
	public abstract boolean hasSameContentsAs(IComparableModel otherModel);

}