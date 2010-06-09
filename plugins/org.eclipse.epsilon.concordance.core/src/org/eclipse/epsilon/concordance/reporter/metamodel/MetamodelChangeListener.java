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
package org.eclipse.epsilon.concordance.reporter.metamodel;

import org.eclipse.emf.ecore.EPackage;

// TODO would clients benefit from receiving nsUri as well as package?

/**
 * Clients must implement a no-argument constructor, which will be instantiated by Concordance.
 */
public interface MetamodelChangeListener {
	
	public void ePackageAdded(EPackage ePackage);

	public void ePackageRemoved(EPackage ePackage);

	public void ePackageChanged(EPackage oldEPackage, EPackage newEPackage);
}
