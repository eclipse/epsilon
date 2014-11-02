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
import java.util.Collection;

import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.etl.dom.TransformationRule;

public class TransformationList extends ArrayList<Transformation>{
	
	public Collection<Object> getTargets(){
		return getTargets(null);
	}
	
	public Collection<Object> getTargets(String rule){
		Collection<Object> targets = CollectionUtil.createDefaultList();
		for (Transformation transformation : this) {
			if (rule == null || rule.equals(transformation.getRule().getName())) {
				targets.addAll(transformation.getTargets());
			}
		}
		return targets;
	}
	
	public boolean containsTransformedBy(TransformationRule rule) {
		for (Transformation t : this) {
			if (t.getRule() == rule) {
				return true;
			}
		}
		return false;
	}
}
