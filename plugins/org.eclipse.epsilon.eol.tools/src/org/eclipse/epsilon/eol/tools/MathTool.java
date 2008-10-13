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
package org.eclipse.epsilon.eol.tools;

public class MathTool {
	
	public double random() {
		return Math.random();
	}
	
	public double sqrt(float d) {
		return Math.sqrt(d);
	}
	
	public double log(float d) {
		return Math.log(d);
	}

	public double asin(float d) {
		return Math.asin(d);
	}
	
	public double atan(float d) {
		return Math.atan(d);
	}
	
	public int bitwiseAnd(int i1, int i2) {
		return i1 & i2;
	}
	
	public int bitwiseOr(int i1, int i2) {
		return i1 | i2;
	}
	
	public int bitwiseNot(int i1) {
		return ~i1;
	}
	
	public String toBitString(int i) {
		return Integer.toBinaryString(i);
	}
}
