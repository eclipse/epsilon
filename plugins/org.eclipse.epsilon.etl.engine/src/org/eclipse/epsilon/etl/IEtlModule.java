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

import java.util.List;

import org.eclipse.epsilon.erl.IErlModule;
import org.eclipse.epsilon.etl.dom.TransformationRule;
import org.eclipse.epsilon.etl.execute.context.IEtlContext;

public interface IEtlModule extends IErlModule {
	
	public List<TransformationRule> getDeclaredTransformationRules();
	
	public List<TransformationRule> getTransformationRules();
	
	public IEtlContext getContext();
	
	public void setContext(IEtlContext context);
}
