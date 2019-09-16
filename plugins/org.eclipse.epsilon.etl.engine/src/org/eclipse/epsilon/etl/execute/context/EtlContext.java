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

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.erl.execute.context.ErlContext;
import org.eclipse.epsilon.etl.IEtlModule;
import org.eclipse.epsilon.etl.execute.operations.EtlOperationFactory;
import org.eclipse.epsilon.etl.strategy.ITransformationStrategy;
import org.eclipse.epsilon.etl.trace.TransformationTrace;

public class EtlContext extends ErlContext implements IEtlContext {
	
	protected TransformationTrace transformationTrace = new TransformationTrace();
	protected ITransformationStrategy transformationStrategy;
	
	public EtlContext() {
		this.operationFactory = new EtlOperationFactory();
	}
	
	@Override
	public TransformationTrace getTransformationTrace() {
		return transformationTrace;
	}
	
	@Override
	public void setTransformationStrategy(ITransformationStrategy transformationStrategy){
		this.transformationStrategy = transformationStrategy;
	}
	
	@Override
	public ITransformationStrategy getTransformationStrategy() {
		return transformationStrategy;
	}
	
	@Override
	public IEtlModule getModule() {
		return (IEtlModule) super.getModule();
	}
	
	@Override
	public void setModule(IModule module) {
		if (module instanceof IEtlModule) {
			super.setModule(module);
		}
	}
}
