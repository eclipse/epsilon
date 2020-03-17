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
package org.eclipse.epsilon.concordance.test.performance.generator.xrefs;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.concordance.test.performance.generator.graph.GraphGenerator;
import org.eclipse.epsilon.emc.composite.CompositeModel;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfModelFactory;
import org.eclipse.epsilon.emc.emf.EmfModelFactory.AccessMode;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;

public class CrossReferencingGraphsGenerator {

	private final GraphGenerator generator = new GraphGenerator();
	
	public Iterable<File> generate(File directory, String prefix, int number) {
		final Collection<File> generated = generator.generate(directory, prefix, number);
		
		System.out.println("Generating cross references.");
		return generateCrossReferences(generated);
	}

	private Iterable<File> generateCrossReferences(Collection<File> generatedModels) {
		try {
			final IEolModule module = new EolModule();
			
			module.getContext().getModelRepository().addModel(loadGraphModels(generatedModels));		
			module.parse(CrossReferencingGraphsGenerator.class.getResource("GenerateCrossReferences.eol").toURI());
			module.execute();
			
			module.getContext().getModelRepository().dispose();
			
		} catch (Exception e) {
			LogUtil.log("Error encountered whilst generating cross references for " + generatedModels, e);
		}
		
		return generatedModels;
	}

	private CompositeModel loadGraphModels(Collection<File> generatedModels) throws EolModelLoadingException, EolModelElementTypeNotFoundException {
		final Collection<IModel> models = new LinkedList<>();
		
		for (File generatedModel : generatedModels) {
			models.add(loadGraphModel(generatedModel));
		}
		
		return new CompositeModel("Graphs", models);
	}
	
	private EmfModel loadGraphModel(File model) throws EolModelLoadingException {
		return EmfModelFactory.getInstance().loadEmfModel("Model", model, "graph", AccessMode.READ_WRITE);
	}
}
