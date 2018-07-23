/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.etl.strategy;

import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.erl.strategy.IEquivalentProvider;
import org.eclipse.epsilon.etl.execute.context.IEtlContext;

public interface ITransformationStrategy extends IEquivalentProvider {
	
	//public void load(StringProperties properties);
	
	//public void autoTransform (Object source, Object target, IEtlContext context) throws EolRuntimeException;
	
	//public Object autoTransform (Object source, IEtlContext context) throws EolRuntimeException;
	
	public Collection<?> transform(Object source, IEtlContext context, List<String> rules) throws EolRuntimeException;
		
	public void transformModels(IEtlContext context) throws EolRuntimeException;

	public void setEquivalentProvider(IEquivalentProvider equivalentProvider);
	
	public IEquivalentProvider getEquivalentProvider();

	public boolean canTransform(Object source);
	
	//public IModel getSourceModel();
	
	//public void setSourceModel(IModel sourceModel);
	
	//public IModel getTargetModel();
	
	//public void setTargetModel(IModel sourceModel);
	
}
