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
package org.eclipse.epsilon.hutn.generate.metamodel;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.emc.emf.EmfMetaModel;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.etl.IEtlModule;
import org.eclipse.epsilon.hutn.exceptions.HutnGenerationException;
import org.eclipse.epsilon.hutn.generate.AbstractGenerator;
import org.eclipse.epsilon.hutn.model.hutn.HutnPackage;
import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.hutn.util.EpsilonUtil;

public class MetaModelGenerator extends AbstractGenerator {

	private final IModel source;
	
	public MetaModelGenerator(Spec spec) {
		source = new InMemoryEmfModel("Intermediate", spec.eResource(), HutnPackage.eINSTANCE);
	}
	
	protected EmfModel generate(Resource resource) throws HutnGenerationException {
		try {
			final EmfModel target = new InMemoryEmfModel("MetaModel", resource, EcorePackage.eINSTANCE);
			
			final IEtlModule transformer = EpsilonUtil.initialiseEtlModule(source, target, new EmfMetaModel("Ecore", EcorePackage.eNS_URI));

			transformer.parse(MetaModelGenerator.class.getResource("Intermediate2MetaModel.etl").toURI());
			transformer.execute();
			
			return target;
		
		} catch (Exception e) {
			throw new HutnGenerationException(e);
		}
	}
}
