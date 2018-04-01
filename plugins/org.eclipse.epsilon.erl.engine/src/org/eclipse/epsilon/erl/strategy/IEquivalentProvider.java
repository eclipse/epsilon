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
package org.eclipse.epsilon.erl.strategy;

import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public interface IEquivalentProvider {
	
	Object getEquivalent(Collection<?> collection, IEolContext context, List<String> rules) throws EolRuntimeException;
	
	Object getEquivalent(Object source, IEolContext context, List<String> rules) throws EolRuntimeException;
	
	Collection<?> getEquivalents(Collection<?> source, IEolContext context, List<String> rules) throws EolRuntimeException;
	
	Collection<?> getEquivalents(Object source, IEolContext context, List<String> rules) throws EolRuntimeException;
	
}
