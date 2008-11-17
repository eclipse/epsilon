/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol;

import java.io.File;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.exceptions.EolEvaluatorException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;

public class EolEvaluator {

	private final IEolModule module = new EolModule();
	
	private boolean statementsEvaluated = false;
	
	public EolEvaluator(IModel... models) {
		for (IModel model : models)
			module.getContext().getModelRepository().addModel(model);
	}
	
	private static String asEolStatement(Object o) {
		return "return " + o.toString() + ";";
	}
	
	public Object evaluate(Object o) {
		statementsEvaluated = true;
		
		final String statement = asEolStatement(o);
		
		try {
			if (module.parse(statement)) {
				return module.execute();
			} else {
				throw new EolEvaluatorException(module.getParseProblems());
			}

		} catch (Exception e) {
			throw new EolEvaluatorException("Could not evaluate '" + o.toString() + "'", e);
		}
	}
	
	public void setVariable(String name, String eolStatement) {
		final Object value = evaluate(eolStatement);
		module.getContext().getFrameStack().put(Variable.createReadOnlyVariable(name, value));
	}
	
	public void importFile(File file) {
		if (statementsEvaluated) {
			throw new IllegalStateException("Cannot import files after calls to evaluate or setVariable have occurred");
		}
		
		try {
			if (module.parse("import '" + file.getAbsolutePath() + "';")) {
				return;
			}
		} catch (Exception e) {}
		
		throw new EolEvaluatorException("Could not import: " + file.getAbsolutePath());
	}
}
