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
	
	@Override
	public String toString() {
		return "CacheDelta(fresh=" + freshEntries + ", expired=" + expiredEntries + ", changed=" + changedEntries + ")";
	}
}
