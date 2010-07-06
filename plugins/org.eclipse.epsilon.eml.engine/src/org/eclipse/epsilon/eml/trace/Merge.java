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

import java.util.Collection;

import org.eclipse.epsilon.ecl.trace.Match;
import org.eclipse.epsilon.eml.MergeRule;

public class Merge {
	
	//protected Object left;
	//protected Object right;
	protected Match match;
	protected Collection targets;
	protected MergeRule rule;
	

	public Merge(){
		
	}
	
	public Merge(Match match, Collection merged) {
		super();
		//this.left = left;
		this.match = match;
		this.targets = merged;
		//this.right = right;
	}
	
	//public Object getLeft() {
	///	return left;
	//}
	
	//public void setLeft(Object left) {
	//	this.left = left;
	//}
	
	public Collection getTargets() {
		return targets;
	}
	
	public void setTargets(Collection merged) {
		this.targets = merged;
	}
	
	//public Object getRight() {
	//	return right;
	//}

	//public void setRight(Object right) {
	//	this.right = right;
	//}
	
	public MergeRule getRule() {
		return rule;
	}

	public void setRule(MergeRule rule) {
		this.rule = rule;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	//public boolean contains(Object left, Object right){
	//	return (this.left == left && this.right == right) || (this.left == right && this.right == left);
	//}
}
