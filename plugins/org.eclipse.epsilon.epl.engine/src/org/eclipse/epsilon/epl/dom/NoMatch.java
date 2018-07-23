/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.epl.dom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.eol.execute.introspection.IUndefined;

public class NoMatch implements IUndefined {
	
	private NoMatch(){}
	
	public static NoMatch INSTANCE = new NoMatch();
	protected static ArrayList<Object> list = null; 
	
	public static List<Object> asList() {
		if (list == null) {
			list = new ArrayList<Object>();
			list.add(INSTANCE);
		}
		return list;
	}
}
