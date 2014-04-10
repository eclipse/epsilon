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
package org.eclipse.epsilon.eml.trace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;

import org.eclipse.epsilon.common.util.CollectionUtil;

public class Merges extends ArrayList<Merge> {
	
	public Collection<Object> getTargets(){
		ListIterator<Merge> li = listIterator();
		Collection<Object> targets = CollectionUtil.createDefaultList();
		while (li.hasNext()){
			Merge merge = li.next();
			targets.addAll(merge.getTargets());
		}
		return targets;
	}

	
}
