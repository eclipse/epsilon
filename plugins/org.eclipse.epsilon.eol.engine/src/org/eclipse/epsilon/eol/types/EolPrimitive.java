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
package org.eclipse.epsilon.eol.types;

public abstract class EolPrimitive extends EolAny implements Comparable{
	
	@Override
	public boolean equals(Object opposite){
		
		if (opposite == null) return false;
		if (opposite.getClass() == this.getClass()){
			return this.toString().equals(opposite.toString());
		}
		return false;
	}
	
	public int compareTo(Object opposite){
		
		if (opposite == null) return -1;
		if (opposite.getClass() == this.getClass()){
			return this.toString().compareTo(opposite.toString());
		}
		return -1;
	}
	
	/*
	@Override
	public int hashCode() {
		return getValue().hashCode();
	}
	*/
}
