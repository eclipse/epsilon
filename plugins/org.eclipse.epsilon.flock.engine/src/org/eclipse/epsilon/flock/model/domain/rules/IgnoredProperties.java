/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.flock.model.domain.rules;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.epsilon.flock.context.MigrationStrategyCheckingContext;
import org.eclipse.epsilon.flock.model.checker.IgnoredPropertyChecker;

public class IgnoredProperties {

	private final Collection<String> ignoredProperties = new LinkedList<String>();
	
	public IgnoredProperties(String... ignoredProperties) {
		this(Arrays.asList(ignoredProperties));
	}
	
	public IgnoredProperties(Collection<String> ignoredProperties) {
		if (ignoredProperties != null) {
			this.ignoredProperties.addAll(ignoredProperties);
		}
	}

	
	public void addAll(IgnoredProperties other) {
		this.ignoredProperties.addAll(other.ignoredProperties);
	}

	public boolean isNotIgnored(String propertyName) {
		return !isIgnored(propertyName);
	}

	private boolean isIgnored(String propertyName) {
		return ignoredProperties.contains(propertyName);
	}
	
	public boolean isEmpty() {
		return ignoredProperties.isEmpty();
	}
	
	public void check(String originalType, MigrationStrategyCheckingContext context) {
		final IgnoredPropertyChecker checker = new IgnoredPropertyChecker(originalType, context);
		
		for (String ignoredProperty : ignoredProperties) {
			checker.check(ignoredProperty);
		}
	}
	
	
	@Override
	public String toString() {
		return ignoredProperties.toString();
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof IgnoredProperties))
			return false;
		
		final IgnoredProperties other = (IgnoredProperties)object;
		
		return ignoredProperties.equals(other.ignoredProperties);
	}
	
	@Override
	public int hashCode() {
		return ignoredProperties.hashCode();
	}
}
