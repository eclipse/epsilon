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

import org.eclipse.epsilon.commons.util.CollectionUtil;

public class Merges extends ArrayList{
	
	public Collection getTargets(){
		ListIterator li = listIterator();
		Collection targets = CollectionUtil.createDefaultList();
		while (li.hasNext()){
			Merge merge = (Merge) li.next();
			targets.addAll(merge.getTargets());
		}
		return targets;
	}

	
}
