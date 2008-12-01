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
package org.eclipse.epsilon.hutn.validation;

import java.net.URL;
import java.util.List;

import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.hutn.exceptions.HutnValidationException;
import org.eclipse.epsilon.hutn.util.EpsilonUtil;

public abstract class AbstractValidator {

	private final AbstractFixer fixer;
	private final URL evlSource;
	
	protected AbstractValidator(AbstractFixer fixer, URL url) {
		this.fixer = fixer;
		this.evlSource = url;
	}
	
	protected List<ParseProblem> validate(IModel model, List<IModel> extraModels) throws HutnValidationException {
		return validate(model, extraModels.toArray(new IModel[]{}));
	}
	
	protected List<ParseProblem> validate(IModel model, IModel... extraModels) throws HutnValidationException {
		do {
			doValidate(model, extraModels);
		} while (fixer.hasAppliedFixes());
		
		return fixer.getParseProblems();
	}
	
	private void doValidate(IModel model, IModel... extraModels) throws HutnValidationException {
		try {		
			final IEvlModule validator = EpsilonUtil.initialseEvlModule(fixer, model, extraModels);
		
			validator.parse(evlSource.toURI());
			validator.execute();
		} catch (Exception e) {
			throw new HutnValidationException(e);
		}
	}

}
