/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.epl.dom;

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;

public class Cardinality extends AbstractModuleElement {
	
	protected int lowerBound;
	protected int upperBound;
	
	public static final int UNBOUNDED = -1;
	
	public Cardinality() {}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		if (cst.getChildCount() == 1) {
			int bound = getBound(cst.getFirstChild().getText());
			this.lowerBound = 1;
			this.upperBound = bound;
		}
		else {
			this.lowerBound = getBound(cst.getFirstChild().getText());
			this.upperBound = getBound(cst.getFirstChild().getNextSibling().getText());
		}
	}
	
	protected int getBound(String text) {
		if ("*".equals(text)) {
			return UNBOUNDED;
		}
		else {
			return Integer.parseInt(text);
		}
	}
	
	public Cardinality(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
	
	public int getUpperBound() {
		return upperBound;
	}
	
	public int getLowerBound() {
		return lowerBound;
	}
	
	public boolean isUnbounded() {
		return upperBound == UNBOUNDED;
	}
	
	public boolean isMany() {
		return !isOne();
	}
	
	public boolean isOne() {
		return upperBound == 1 && lowerBound == 1;
	}
	
	public boolean isInBounds(int n) {
		return n>=lowerBound && (upperBound == UNBOUNDED || n<=upperBound);
	}
	
}
