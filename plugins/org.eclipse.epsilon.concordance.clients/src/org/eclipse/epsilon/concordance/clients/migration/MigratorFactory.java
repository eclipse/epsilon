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
package org.eclipse.epsilon.concordance.clients.migration;

import java.net.URI;

import org.eclipse.emf.ecore.EPackage;


public interface MigratorFactory {

	public Migrator migratorFor(URI strategy, EPackage originalMetamodel, EPackage evolvedMetamodel);

}
