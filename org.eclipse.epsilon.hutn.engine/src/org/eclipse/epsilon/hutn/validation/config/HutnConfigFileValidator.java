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
package org.eclipse.epsilon.hutn.validation.config;

import java.util.List;

import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.emc.emf.EmfMetaModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.hutn.exceptions.HutnMetaModelRegistrationException;
import org.eclipse.epsilon.hutn.exceptions.HutnValidationException;
import org.eclipse.epsilon.hutn.model.config.HutnConfigMetamodel;
import org.eclipse.epsilon.hutn.model.config.hutnConfig.HutnConfigPackage;
import org.eclipse.epsilon.hutn.util.EmfUtil;
import org.eclipse.epsilon.hutn.validation.AbstractValidator;

public class HutnConfigFileValidator extends AbstractValidator {

	// For unit tests
	HutnConfigFileValidator() {
		this(1,1);
	}
	
	public HutnConfigFileValidator(int line, int column) {
		super(new HutnConfigFileFixer(line, column), HutnConfigFileValidator.class.getResource("ValidateConfigurationModel.evl"));
	}
	
	private static void registerMetaModels() throws HutnMetaModelRegistrationException {
		EmfUtil.registerMetaModel(HutnConfigPackage.eNS_URI, HutnConfigMetamodel.getMetaModelUri());;
	}
	
	public List<ParseProblem> getProblemsForConfigurationModel(IModel configModel, String metaModelNsUri) throws HutnValidationException {
		try {
			registerMetaModels();
			
			configModel.load();
			
			return validate(configModel, new EmfMetaModel("MetaModel", metaModelNsUri));
		
		} catch (EolModelLoadingException e) {
			throw new HutnValidationException(e);
			
		} catch (HutnMetaModelRegistrationException e) {
			throw new HutnValidationException(e);
		
		} finally {
			configModel.dispose();
		}
	}
}
