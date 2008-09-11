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
package org.eclipse.epsilon.hutn.generate.model;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.egl.EglModule;
import org.eclipse.epsilon.egl.IEglModule;
import org.eclipse.epsilon.emc.emf.EmfMetaModel;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.etl.IEtlModule;
import org.eclipse.epsilon.hutn.exceptions.HutnGenerationException;
import org.eclipse.epsilon.hutn.generate.AbstractGenerator;
import org.eclipse.epsilon.hutn.model.hutn.HutnPackage;
import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.hutn.util.EpsilonUtil;

public class ModelGenerator extends AbstractGenerator {

	private final IModel source;
	private final IModel metaModel;
	
	private boolean metaModelIsFileBased;
	private File metaModelFile;
	private String metaModelUri;
	
	public ModelGenerator(Spec spec) throws HutnGenerationException {
		if (spec.getNsUris().isEmpty())
			throw new IllegalArgumentException("Spec does not contain any nsUris: " + spec);
		
		try {
			this.metaModelIsFileBased = false;
			this.metaModelUri = spec.getNsUris().get(0).getValue();
			
			source = new InMemoryEmfModel("Intermediate", spec.eResource(), HutnPackage.eINSTANCE);
			metaModel = new EmfMetaModel("MetaModel", this.metaModelUri);
			metaModel.load();
		
		} catch (EolModelLoadingException e) {
			throw new HutnGenerationException(e);
		}
	}
	
	public ModelGenerator(Spec spec, File metaModelFile) throws HutnGenerationException {
		try {
			this.metaModelIsFileBased = true;
			this.metaModelFile = metaModelFile;
			
			EmfUtil.register(URI.createFileURI(metaModelFile.getAbsolutePath()), EPackage.Registry.INSTANCE);
			
			source = new InMemoryEmfModel("Intermediate", spec.eResource(), HutnPackage.eINSTANCE);
			metaModel = org.eclipse.epsilon.hutn.util.EmfUtil.loadMetaModel("MetaModel", metaModelFile);
		
		} catch (Exception e) {
			throw new HutnGenerationException(e);
		}
	}
	
	protected String[] getNsUrisForTargetModel() throws EolModelElementTypeNotFoundException {
		final List<String> nsUris = new LinkedList<String>();
		
		for (Object o : metaModel.getAllOfType("EPackage")) {
			if (o instanceof EPackage) {
				nsUris.add(((EPackage)o).getNsURI());
			}
		}
		
		return nsUris.toArray(new String[]{});
	}
	
	protected EmfModel generate(Resource resource) throws HutnGenerationException {
		try {
			final EmfModel target = new InMemoryEmfModel("Model", resource, getNsUrisForTargetModel());
			final IEtlModule transformer = EpsilonUtil.initialiseEtlModule(source, target, metaModel);
							
			target.setMetamodelFileBased(metaModelIsFileBased);
			
			if (metaModelIsFileBased) {
				target.setMetamodelFile(metaModelFile.getAbsolutePath());
			} else {
				target.setMetamodelUri(metaModelUri);
			}
			
			/*  modelFile needs to be set for load() to work
			 *  but as we set readOnLoad to false, the value of
			 *  modelFile isn't important
			 */
			target.setModelFile("foo.model");
			target.load();
			
			transformer.parse(generateTransformation());
			
			if (transformer.getParseProblems().isEmpty()) {
				transformer.execute();
			} else {
				throw new HutnGenerationException("Could not parse transformation: " + transformer.getParseProblems());
			}
			
			return target;
			
		} catch (Exception e) {
			if (e instanceof HutnGenerationException)
				throw (HutnGenerationException)e;
			else
				throw new HutnGenerationException(e);
		}
	}
	
	public String generateTransformation() throws HutnGenerationException {
		try {
			final IEglModule generator = new EglModule();
			generator.getContext().getModelRepository().addModel(metaModel);
			generator.parse(ModelGenerator.class.getResource("GenerateIntermediate2ModelTransformation.egl").toURI());
			
			final String transformation = generator.execute();
//			System.err.println(transformation);
			return transformation;
	
		} catch (Exception e) {
			throw new HutnGenerationException(e);
		}
	}
}
