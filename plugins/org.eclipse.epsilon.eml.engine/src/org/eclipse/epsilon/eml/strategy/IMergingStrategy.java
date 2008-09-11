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
package org.eclipse.epsilon.eml.strategy;

import org.eclipse.epsilon.eml.execute.context.IEmlContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.etl.strategy.ITransformationStrategy;

public interface IMergingStrategy extends ITransformationStrategy { // extends TransformationStrategy{

	//public Object autoMerge(Object left, Object right, EmlContext context) throws EolRuntimeException;
	
	//public void autoMerge (Object left, Object right, Object merged, EmlContext context) throws EolRuntimeException;

	//public ITransformationStrategy getLeftTransformationStrategy();
	
	//public void setLeftTransformationStrategy(ITransformationStrategy leftTransformationStrategy);
	
	//public ITransformationStrategy getRightTransformationStrategy();
	
	//public void setRightTransformationStrategy(ITransformationStrategy leftTransformationStrategy);
	
	public void mergeModels(IEmlContext context) throws EolRuntimeException;
	
	//public IModel getLeftModel();
	
	//public void setLeftModel(IModel model);
	
	//public IModel getRightModel();
	
	//public void setRightModel(IModel model);

	//public IModel getTargetModel();
	
	//public void setTargetModel(IModel model);	
}
