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
import org.eclipse.epsilon.eol.types.EolCollection;

public interface IEquivalentProvider {
	
	public Object getEquivalent(Collection collection, IEolContext context, List<String> rules) throws EolRuntimeException;
	
	public Object getEquivalent(Object source, IEolContext context, List<String> rules) throws EolRuntimeException;
	
	public EolCollection getEquivalents(Collection source, IEolContext context, List<String> rules) throws EolRuntimeException;
	
	public EolCollection getEquivalents(Object source, IEolContext context, List<String> rules) throws EolRuntimeException;
	
}
