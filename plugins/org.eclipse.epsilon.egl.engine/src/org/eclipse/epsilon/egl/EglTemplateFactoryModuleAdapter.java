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

import java.io.File;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.parse.Region;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.formatter.Formatter;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.dom.ModelDeclaration;
import org.eclipse.epsilon.eol.dom.OperationList;
import org.eclipse.epsilon.eol.dom.Statement;
import org.eclipse.epsilon.eol.dom.StatementBlock;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class EglTemplateFactoryModuleAdapter implements IEolModule {
		
	private final EglTemplateFactory factory;
	private EglTemplate current;
	
	public EglTemplateFactoryModuleAdapter(EglTemplateFactory factory) {
		this.factory = factory;
	}
	
	public EglTemplate getCurrentTemplate() {
		return current;
	}
	
	public boolean parse(File file) throws Exception {
		current = factory.load(file);
		return getParseProblems().isEmpty();
	}
	
	public boolean parse(URI uri) throws Exception {
		current = factory.load(uri);
		return getParseProblems().isEmpty();
	}
	
	public boolean parse(String code) throws Exception {
		current = factory.prepare(code);
		return getParseProblems().isEmpty();
	}
	
	public boolean parse(String code, File file) throws Exception {
		current = factory.load(code, file);
		return current.getParseProblems().isEmpty();
	}
	
	public List<ParseProblem> getParseProblems() {
		return current == null ? new LinkedList<ParseProblem>() : current.getParseProblems();
	}

	public Object execute() throws EolRuntimeException {
		return current == null ? null : current.process();
	}
	
	@Override
	public List<ModuleMarker> compile() {
		return Collections.emptyList();
	}
	
	public void reset() {
		current = null;
	}

	public void buildModel() throws Exception {}

	public IEglContext getContext() {
		return factory.getContext();
	}

	public List<ModelDeclaration> getDeclaredModelDeclarations() {
		return current.getModule().getPreprocessorModule().getDeclaredModelDeclarations();
	}

	public OperationList getDeclaredOperations() {
		return current.getModule().getPreprocessorModule().getDeclaredOperations();
	}

	public List<Import> getImports() {
		return current.getModule().getPreprocessorModule().getImports();
	}

	public Set<ModelDeclaration> getModelDelcarations() {
		return current.getModule().getPreprocessorModule().getModelDelcarations();
	}

	public OperationList getOperations() {
		
		return current.getModule().getPreprocessorModule().getOperations();
	}

	public void setDefaultFormatters(Collection<Formatter> defaultFormatters) {
		factory.setDefaultFormatters(defaultFormatters);
	}

	@Override
	public IEolModule getParentModule() {
		return null;
	}

	@Override
	public void setParentModule(IEolModule parent) {}

	@Override
	public URI getSourceUri() {
		return null;
	}

	@Override
	public void setContext(IEolContext context) {
		if (context instanceof IEglContext) {
			factory.setContext((IEglContext) context);
		}
	}

	@Override
	public EolCompilationContext getCompilationContext() {
		return current.getModule().getPreprocessorModule().getCompilationContext();
	}

	@Override
	public ModuleElement createAst(AST cst, ModuleElement parentAst) {
		return null;
	}

	@Override
	public File getFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URI getUri() {
		return null;
	}

	@Override
	public void setUri(URI uri) {}

	@Override
	public void setModule(IModule module) {}
	
	@Override
	public void build(AST cst, IModule module) {}

	@Override
	public Region getRegion() {
		return current.module.getRegion();
	}

	@Override
	public void setRegion(Region region) {}

	@Override
	public ModuleElement getParent() {
		return null;
	}

	@Override
	public void setParent(ModuleElement moduleElement) {}

	@Override
	public List<ModuleElement> getChildren() {
		return current.module.getChildren();
	}

	@Override
	public IModule getModule() {
		return null;
	}

	@Override
	public StatementBlock getMain() {
		return null;
	}

	@Override
	public List<Statement> getPostOperationStatements() {
		return Collections.emptyList();
	}

}
