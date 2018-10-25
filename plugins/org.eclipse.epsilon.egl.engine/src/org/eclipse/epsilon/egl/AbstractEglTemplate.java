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
package org.eclipse.epsilon.egl;

import java.util.List;
import java.util.Set;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.egl.internal.IEglModule;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.dom.ModelDeclaration;
import org.eclipse.epsilon.eol.dom.OperationList;

/**
 * An EGL template that uses an instance of {@link IEglModule}
 * to parse, preprocess and execute EGL source.
 */
public abstract class AbstractEglTemplate {

	protected final IEglModule module;
	
	public AbstractEglTemplate(IEglModule module) {
		this.module = module;
	}
	
	public IEglModule getModule() {
		return module;
	}
	
	public List<ParseProblem> getParseProblems() {
		return module.getParseProblems();
	}

	public List<ModelDeclaration> getDeclaredModelDefinitions() {
		return module.getDeclaredModelDeclarations();
	}

	public OperationList getDeclaredOperations() {
		return module.getDeclaredOperations();
	}

	public List<Import> getImports() {
		return module.getImports();
	}

	public Set<ModelDeclaration> getModelDefinitions() {
		return module.getModelDelcarations();
	}

	public OperationList getOperations() {
		return module.getOperations();
	}

	protected void printWarning(String message) {
		module.getContext().getWarningStream().println(message);
	}
	
	public abstract void reset();
}
