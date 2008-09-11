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
package org.eclipse.epsilon.hutn.util;

import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.IEtlModule;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.IEvlFixer;
import org.eclipse.epsilon.evl.IEvlModule;

public abstract class EpsilonUtil {

	private EpsilonUtil() {}
	
	public static IEtlModule initialiseEtlModule(IModel source, IModel target, IModel... extraModels) throws EolModelLoadingException {
		final IEtlModule transformer = new EtlModule();
		
		source.setStoredOnDisposal(false);
		target.setStoredOnDisposal(false);
		target.setReadOnLoad(false);
		
		transformer.getContext().getModelRepository().addModel(source);
		transformer.getContext().getModelRepository().addModel(target);
		
		for (IModel extraModel : extraModels) {
			extraModel.setStoredOnDisposal(false);
			transformer.getContext().getModelRepository().addModel(extraModel);
			extraModel.load();
		}
		
		return transformer;
	}
	
	public static IEvlModule initialseEvlModule(IEvlFixer fixer, IModel model, IModel... extraModels) throws EolModelLoadingException  {
		final IEvlModule validator = new EvlModule();
		
		validator.setUnsatisfiedConstraintFixer(fixer);
		
		model.setReadOnLoad(true);
		model.setStoredOnDisposal(false);
		
		validator.getContext().getModelRepository().addModel(model);
		
		for (IModel extraModel : extraModels) {
			extraModel.setStoredOnDisposal(false);
			validator.getContext().getModelRepository().addModel(extraModel);
			extraModel.load();
		}
		
		return validator;
	}
}
