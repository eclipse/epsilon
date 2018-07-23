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

import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.etl.IEtlModule;
import org.eclipse.epsilon.etl.execute.operations.EtlOperationFactory;
import org.eclipse.epsilon.etl.strategy.DefaultTransformationStrategy;
import org.eclipse.epsilon.etl.strategy.ITransformationStrategy;
import org.eclipse.epsilon.etl.trace.TransformationTrace;

public class EtlContext extends EolContext implements IEtlContext{
	
	protected TransformationTrace transformationTrace = new TransformationTrace();
	protected ITransformationStrategy transformationStrategy = null;
	
	public EtlContext() {
		this.operationFactory = new EtlOperationFactory();
	}
	
	public TransformationTrace getTransformationTrace() {
		return transformationTrace;
	}
	
	public void setTransformationStrategy(ITransformationStrategy transformationStrategy){
		this.transformationStrategy = transformationStrategy;
	}
	
	public ITransformationStrategy getTransformationStrategy() {
		return transformationStrategy;
	}
	
	@Override
	public IEtlModule getModule(){
		return (IEtlModule) module;
	}
	
	public void setModule(IEtlModule module){
		this.module = module;
	}
	
}
