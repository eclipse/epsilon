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
	
	public static void main(String[] args) {
		
	}
	
	public double random() {
		return Math.random();
	}
	
	public double sqrt(double d) {
		return Math.sqrt(d);
	}
	
	public double log(double d) {
		return Math.log(d);
	}

	public double asin(double d) {
		return Math.asin(d);
	}
	
	public double atan(double d) {
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
	
	public int bitStringToInt(String s) {
		return Integer.parseInt(s, 2);
	}
	
	public int round(double d) {
		return (int) Math.round(d);
	}
	
	public double pow(double base, double exp) {
		return Math.pow(base, exp);
	}
	
}
