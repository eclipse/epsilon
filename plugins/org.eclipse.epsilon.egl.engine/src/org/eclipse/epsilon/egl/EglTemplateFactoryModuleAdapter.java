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

public class EglTemplateFactoryModuleAdapter implements IEglModule {
		
	private EglTemplateFactory templateFactory;
	private EglTemplate current;
	
	public EglTemplateFactoryModuleAdapter() {
		this(new EglTemplateFactory());
	}
	
	public EglTemplateFactoryModuleAdapter(EglTemplateFactory factory) {
		this.templateFactory = factory;
	}
	
	@Override
	public EglTemplateFactory getTemplateFactory() {
		return templateFactory;
	}
	
	@Override
	public void setTemplateFactory(EglTemplateFactory templateFactory) {
		this.templateFactory = templateFactory;
	}
	
	/**
	 * @deprecated Use {@link #getTemplateFactory()}
	 */
	@Deprecated
	public EglTemplateFactory getFactory() {
		return getTemplateFactory();
	}
	/**
	 * @deprecated Use {@link #setTemplateFactory()}
	 */
	@Deprecated
	public void setFactory(EglTemplateFactory factory) {
		setTemplateFactory(factory);
	}

	@Override
	public EglTemplate getCurrentTemplate() {
		return current;
	}
	
	@Override
	public boolean parse(File file) throws Exception {
		current = templateFactory.load(file);
		return getParseProblems().isEmpty();
	}
	
	@Override
	public boolean parse(URI uri) throws Exception {
		current = templateFactory.load(uri);
		return getParseProblems().isEmpty();
	}
	
	@Override
	public boolean parse(String code) throws Exception {
		current = templateFactory.prepare(code);
		return getParseProblems().isEmpty();
	}
	
	@Override
	public boolean parse(String code, File file) throws Exception {
		current = templateFactory.load(code, file);
		return current.getParseProblems().isEmpty();
	}
	
	@Override
	public boolean parse(String code, URI uri) throws Exception {
		current = templateFactory.load(code, uri);
		return current.getParseProblems().isEmpty();
	}
	
	@Override
	public List<ParseProblem> getParseProblems() {
		return current == null ? new LinkedList<>() : current.getParseProblems();
	}

	@Override
	public Object execute() throws EolRuntimeException {
		return current == null ? null : current.process();
	}
	
	@Override
	public List<ModuleMarker> compile() {
		return Collections.emptyList();
	}
	
	@Override
	public void reset() {
		current = null;
	}

	@Override
	public IEglContext getContext() {
		return templateFactory.getContext();
	}

	@Override
	public List<ModelDeclaration> getDeclaredModelDeclarations() {
		return current.module.getDeclaredModelDeclarations();
	}

	@Override
	public OperationList getDeclaredOperations() {
		return current.module.getDeclaredOperations();
	}

	@Override
	public List<Import> getImports() {
		return current.module.getImports();
	}

	@Override
	public Set<ModelDeclaration> getModelDelcarations() {
		return current.module.getModelDelcarations();
	}

	@Override
	public OperationList getOperations() {
		return current.module.getOperations();
	}

	@Override
	public void setDefaultFormatters(Collection<Formatter> defaultFormatters) {
		templateFactory.setDefaultFormatters(defaultFormatters);
	}

	@Override
	public IEolModule getParentModule() {
		return current.module.getParentModule();
	}

	@Override
	public void setParentModule(IEolModule parent) {
		current.module.setParentModule(parent);
	}

	@Override
	public URI getSourceUri() {
		return current.module.getSourceUri();
	}

	@Override
	public void setContext(IEolContext context) {
		if (context instanceof IEglContext) {
			templateFactory.setContext((IEglContext) context);
			current.module.setContext(context);
		}
	}

	@Override
	public EolCompilationContext getCompilationContext() {
		return current.module.getCompilationContext();
	}

	@Override
	public ModuleElement createAst(AST cst, ModuleElement parentAst) {
		return current.module.createAst(cst, parentAst);
	}

	@Override
	public File getFile() {
		return current.module.getFile();
	}

	@Override
	public URI getUri() {
		return current.module.getUri();
	}

	@Override
	public void setUri(URI uri) {
		current.module.setUri(uri);
	}

	@Override
	public void setModule(IModule module) {
		current.module.setModule(module);
	}
	
	@Override
	public void build(AST cst, IModule module) {
		current.module.build(cst, module);
	}

	@Override
	public Region getRegion() {
		return current.module.getRegion();
	}

	@Override
	public void setRegion(Region region) {
		current.module.setRegion(region);
	}

	@Override
	public ModuleElement getParent() {
		return current.module.getParent();
	}

	@Override
	public void setParent(ModuleElement moduleElement) {
		current.module.setParent(moduleElement);
	}

	@Override
	public List<ModuleElement> getChildren() {
		return current.module.getChildren();
	}

	@Override
	public IModule getModule() {
		return current.module;
	}

	@Override
	public StatementBlock getMain() {
		return current.module.getMain();
	}

	@Override
	public List<Statement> getPostOperationStatements() {
		return current.module.getPostOperationStatements();
	}

}
