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

public class EolInteger extends EolReal{
	
	public EolInteger(){
		this.value = 0;
		this.doublePrecision = false;
	}
	
	public EolInteger(int value){
		this.value = value;
		this.doublePrecision = false;
	}
	
	public EolInteger(String value){
		this.doublePrecision = false;
		try {
			this.value = Integer.parseInt(value);
		}
		catch (Exception ex){
			try {
				this.value = new Float(Float.parseFloat(value)).intValue();
			}
			catch (Exception ex1) {
				this.value = 0;
			}
			
		}
	} 
	 
	@Override
	public double getValue(){
		return new Double(value).intValue();
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	@Override
	public String toString(){
		return intValue() + "";
	}
	
	public int intValue(){
		return (int) Math.round(value);
	}

	public EolInteger add(EolInteger i) {
		return new EolInteger(this.intValue() + i.intValue());
	}

	public EolInteger multiply(EolInteger i) {
		return new EolInteger(this.intValue() * i.intValue());
	}

	public EolInteger subtract(EolInteger i) {
		return new EolInteger(this.intValue() - i.intValue());
	}
	
	@Override
	public EolInteger negative() {
		return new EolInteger(0-this.intValue());
	}
	
}
