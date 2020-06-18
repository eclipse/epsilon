/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 ******************************************************************************/
package org.eclipse.epsilon.eol.compile.context;

import java.util.List;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.eol.dom.ModelDeclaration;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;
import org.eclipse.epsilon.eol.types.EolModelElementType;

public interface IEolCompilationContext {

	List<ModuleMarker> getMarkers();

	void setRuntimeContext(IEolContext context);

	void addWarningMarker(AbstractModuleElement element, String message);

	void addErrorMarker(AbstractModuleElement element, String message);

	FrameStack getFrameStack();

	IModelFactory getModelFactory();

	void setModelFactory(IModelFactory modelFactory);

	IRelativePathResolver getRelativePathResolver();

	void setRelativePathResolver(IRelativePathResolver relativePathResolver);

	void setModelDeclarations(List<ModelDeclaration> modelDeclarations);

	List<ModelDeclaration> getModelDeclarations();

	EolModelElementType getModelElementType(String modelAndType);

}