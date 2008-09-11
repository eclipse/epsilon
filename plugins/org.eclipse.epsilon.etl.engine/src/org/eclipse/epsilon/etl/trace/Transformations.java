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
package org.eclipse.epsilon.etl.trace;

import java.util.ArrayList;
import java.util.ListIterator;

import org.eclipse.epsilon.eol.types.EolBag;
import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.etl.TransformRule;

public class Transformations extends ArrayList<Transformation>{
	
	public EolCollection getTargets(){
		return getTargets(null);
	}
	
	public EolCollection getTargets(String rule){
		ListIterator li = listIterator();
		EolCollection targets = new EolBag();
		for (Transformation transformation : this) {
			if (rule == null || rule == transformation.getRule().getName()) {
				targets.addAll(transformation.getTargets());
			}
		}
		return targets;
	}
	
	public boolean containsTransformedBy(TransformRule rule) {
		for (Transformation t : this) {
			if (t.getRule() == rule) {
				return true;
			}
		}
		return false;
	}
}
