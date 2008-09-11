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
package org.eclipse.epsilon.etl;

import org.eclipse.epsilon.erl.IErlModule;
import org.eclipse.epsilon.etl.execute.context.IEtlContext;

public interface IEtlModule extends IErlModule {
	
	public TransformRules getDeclaredTransformRules();
	
	public TransformRules getTransformRules();
	
	//public void setSourceModel(IEolModel sourceModel);
	
	//public IEolModel getSourceModel();
	
	//public void setTargetModel(IEolModel targetModel);
	
	//public IEolModel getTargetModel();
	
	public IEtlContext getContext();
	
	public void setContext(IEtlContext context);
}
