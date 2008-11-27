/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.hutn;

import java.io.File;
import java.util.List;

import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.eol.IEolLibraryModule;
import org.eclipse.epsilon.hutn.exceptions.HutnGenerationException;
import org.eclipse.epsilon.hutn.model.hutn.Spec;

public interface IHutnModule extends IEolLibraryModule {

	public void generateEmfMetaModel(File destination) throws HutnGenerationException;
	
	public void generateEmfModel(File destination) throws HutnGenerationException;
	
	public void generateEmfModel(File destination, File metamodel) throws HutnGenerationException;
	
	public AbstractEmfModel generateEmfModel() throws HutnGenerationException;

	public boolean hasInferredMetaModel();
	
	public boolean hasValidMetaModel();
	
	public List<String> getNsUris();
	
	public void setConfigFileDirectory(File configFileDirectory);
	
	public Spec getIntermediateModel();
	
	public void storeIntermediateModel(File destination);
	
	public void storeIntermediateModelTransformation(File destination) throws HutnGenerationException;

	/**
	 * Returns false only if the HUTN source passed to parse is not valid HUTN.
	 * True is returned when the HUTN is valid, regardless of whether it conforms
	 * to the metamodel specified in the preamble.
	 */
	public boolean hasValidHutn();
}
