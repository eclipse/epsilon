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

import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EPackage;

public class CacheDelta {

	public final Set<Entry<String, EPackage>>   freshEntries;
	public final Set<Entry<String, EPackage>>   expiredEntries;
	public final Set<Entry<EPackage, EPackage>> changedEntries;
	
	public CacheDelta(Set<Entry<String, EPackage>> freshEntries, Set<Entry<String, EPackage>> expiredEntries, Set<Entry<EPackage, EPackage>> changedEntries) {
		this.freshEntries   = freshEntries;
		this.expiredEntries = expiredEntries;
		this.changedEntries = changedEntries;
	}
	
	
}
