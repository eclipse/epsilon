/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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
