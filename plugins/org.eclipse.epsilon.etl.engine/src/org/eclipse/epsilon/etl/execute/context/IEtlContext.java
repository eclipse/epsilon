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
package org.eclipse.epsilon.etl.execute.context;

import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.etl.IEtlModule;
import org.eclipse.epsilon.etl.strategy.ITransformationStrategy;
import org.eclipse.epsilon.etl.trace.TransformationTrace;

public interface IEtlContext extends IEolContext {
	
	public TransformationTrace getTransformationTrace();
	
	public ITransformationStrategy getTransformationStrategy(Object source);
	
	public ITransformationStrategy getTransformationStrategy();
	
	public void setTransformationStrategy(ITransformationStrategy transformationStrategy);
	
	public IEtlModule getModule();
	
	public void setModule(IEtlModule module);
	
}
