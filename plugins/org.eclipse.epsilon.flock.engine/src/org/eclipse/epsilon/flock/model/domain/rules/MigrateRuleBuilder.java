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
import java.util.Collections;

import org.eclipse.epsilon.common.parse.AST;

public class MigrateRuleBuilder {

	public static MigrateRuleBuilder aMigrateRule(AST ast, String originalType) {
		return new MigrateRuleBuilder(ast, originalType);
	}
	
	public static MigrateRuleBuilder anUntraceableMigrateRule(String originalType) {
		return aMigrateRule(null, originalType);
	}
	
	
	private final AST ast;
	private final String originalType;
	
	private AST body;
	private AST guard;
	private Collection<String> ignoredProperties = Collections.emptyList();
	private Collection<String> annotations = Collections.emptyList();
	
	private MigrateRuleBuilder(AST ast, String originalType) {
		this.ast          = ast;
		this.originalType = originalType;
	}
	
	public MigrateRuleBuilder withGuard(AST guard) {
		this.guard = guard;
		return this;
	}
	
	public MigrateRuleBuilder withBody(AST body) {
		this.body = body;
		return this;
	}
	
	public MigrateRuleBuilder withIgnoredProperties(String... properties) {
		return withIgnoredProperties(Arrays.asList(properties));
	}
	
	public MigrateRuleBuilder withIgnoredProperties(Collection<String> properties) {
		this.ignoredProperties = properties;
		return this;
	}

	public MigrateRuleBuilder withAnnotations(String... annotations) {
		return withAnnotations(Arrays.asList(annotations)); 
	}
	
	public MigrateRuleBuilder withAnnotations(Collection<String> annotations) {
		this.annotations = annotations; 
		return this;
	}
	
	public MigrateRule build() {
		return new MigrateRule(ast, annotations, originalType, ignoredProperties, guard, body);
	}

}
