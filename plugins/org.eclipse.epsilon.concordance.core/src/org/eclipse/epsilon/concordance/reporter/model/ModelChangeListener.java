/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.concordance.reporter.model;

import org.eclipse.epsilon.concordance.model.Model;

/**
 * Clients must implement a no-argument constructor, which will be instantiated by Concordance.
 */
public interface ModelChangeListener {

	public void modelAdded(Model model);

	public void modelRemoved(Model model);

	public void modelChanged(Model model);
	
	public void modelMoved(Model original, Model moved);
}
