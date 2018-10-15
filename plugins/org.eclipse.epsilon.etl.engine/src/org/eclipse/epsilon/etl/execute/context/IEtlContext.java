/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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
	
	public ITransformationStrategy getTransformationStrategy();
	
	public void setTransformationStrategy(ITransformationStrategy transformationStrategy);
	
	@Override
	public default IEtlModule getModule() {
		return (IEtlModule) ((IEolContext)this).getModule();
	}
	
	public void setModule(IEtlModule module);
	
}
