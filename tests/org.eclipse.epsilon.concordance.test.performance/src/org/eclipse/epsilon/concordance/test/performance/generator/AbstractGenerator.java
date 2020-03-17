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
package org.eclipse.epsilon.concordance.test.performance.generator;

import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfModelFactory;
import org.eclipse.epsilon.emc.emf.EmfModelFactory.AccessMode;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

public abstract class AbstractGenerator {
	
	private final String modelName;
	private final String metamodelNsUri;
	private final URL    eolGenerator;
	
	public AbstractGenerator(String modelName, String metamodelNsUri, URL eolGenerator) {
		this.modelName      = modelName;
		this.metamodelNsUri = metamodelNsUri;
		this.eolGenerator   = eolGenerator;
	}
	
	public Collection<File> generate(File directory, String prefix, int number) {
		final Collection<File> generated = new LinkedList<>();
		
		System.out.println("Generating models.");
		for (int index = 1; index <= number; index++) {
			generated.add(generate(new File(directory, prefix + index + ".model")));
		}
		
		return generated;
	}
	
	public File generate(File target) {
		try {
			final IEolModule module = new EolModule();
												
			module.getContext().getModelRepository().addModel(initialiseEmptyModel(target));			
			module.parse(eolGenerator.toURI());
			module.execute();
			
			module.getContext().getModelRepository().dispose();
			
		} catch (Exception e) {
			LogUtil.log("Error encountered whilst generating model to " + target, e);
		}
		
		return target;
	}

	private EmfModel initialiseEmptyModel(File target) throws EolModelLoadingException {
		return EmfModelFactory.getInstance().loadEmfModel("Model", target, metamodelNsUri, AccessMode.WRITE_ONLY);
	}

	public String getModelName() {
		return modelName;
	}
}
