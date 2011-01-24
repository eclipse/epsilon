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
package org.eclipse.epsilon.flock.model.loader;

import static org.eclipse.epsilon.flock.model.domain.rules.MigrateRuleBuilder.aMigrateRule;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.flock.model.domain.rules.MigrateRule;
import org.eclipse.epsilon.flock.parse.FlockParser;

public class MigrateRuleLoader extends Loader {

	public MigrateRuleLoader(AST ast) {
		super(ast);
	}
	
	public MigrateRule run() {
		return aMigrateRule(ast, getOriginalType())
		       	.withBody(getBody())
		       	.withGuard(getGuard())
		       	.withIgnoredProperties(getIgnoredProperties())
		       	.build();
	}

	private String getOriginalType() {
		return getFirstChild().getText();
	}
	
	private Collection<String> getIgnoredProperties() {
		final Collection<String> ignoredProperties = new LinkedList<String>();
		
		if (hasChildOfType(FlockParser.IGNORING)) {
			final AST ignoring = getFirstChildOfType(FlockParser.IGNORING);
			
			for (AST ignoredProperty : ignoring.getChildren()) {
				ignoredProperties.add(ignoredProperty.getText());
			}
		}
		
		return ignoredProperties;
	}

	private AST getBody() {
		return getFirstChildOfType(FlockParser.BLOCK);
	}
}
