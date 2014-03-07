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
package org.eclipse.epsilon.egl;

import java.util.List;
import java.util.Set;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.egl.internal.IEglModule;
import org.eclipse.epsilon.eol.EolImport;
import org.eclipse.epsilon.eol.EolModelDefinition;
import org.eclipse.epsilon.eol.EolModelGroupDefinition;
import org.eclipse.epsilon.eol.EolOperationFactory;
import org.eclipse.epsilon.eol.EolOperations;

/**
 * An EGL template that uses an instance of {@link IEglModule}
 * to parse, preprocess and execute EGL source.
 */
public abstract class AbstractEglTemplate {

	protected final IEglModule module;
	
	public AbstractEglTemplate(IEglModule module) {
		this.module = module;
	}
	
	public List<ParseProblem> getParseProblems() {
		return module.getParseProblems();
	}
	
	public AST getAst() {
		return module.getAst();
	}
	
	public List<?> getChildren() {
		return module.getChildren();
	}

	public List<EolModelDefinition> getDeclaredModelDefinitions() {
		return module.getDeclaredModelDefinitions();
	}

	public List<EolModelGroupDefinition> getDeclaredModelGroupDefinitions() {
		return module.getDeclaredModelGroupDefinitions();
	}

	public EolOperations getDeclaredOperations() {
		return module.getDeclaredOperations();
	}

	public List<EolImport> getImports() {
		return module.getImports();
	}

	public Set<EolModelDefinition> getModelDefinitions() {
		return module.getModelDefinitions();
	}

	public Set<EolModelGroupDefinition> getModelGroupDefinitions() {
		return module.getModelGroupDefinitions();
	}

	public EolOperationFactory getOperationFactory() {
		return module.getOperationFactory();
	}

	public EolOperations getOperations() {
		return module.getOperations();
	}

	public void setOperationFactory(EolOperationFactory operationFactory) {
		module.setOperationFactory(operationFactory);
	}

	protected void printWarning(String message) {
		module.getContext().getWarningStream().println(message);
	}
}
