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

public class EolBoolean extends EolPrimitive{
	
	boolean value = false;
	
	public static EolBoolean TRUE = new EolBoolean(true);
	public static EolBoolean FALSE = new EolBoolean(false);
	
	public EolBoolean(){
		
	}
	
	public EolBoolean(boolean value){
		this.value = value;
	}
	
	public EolBoolean(String value){
		try {
			this.value = new Boolean(value).booleanValue();
		}
		catch (Exception ex){
			this.value = false;
		}
	}
	
	public boolean getValue(){
		return value;
	}
	
	public void setValue(boolean value){
		this.value = value;
	}
	
	public EolBoolean or(EolBoolean operand){
		return new EolBoolean(this.value || operand.getValue());
	}
	
	public EolBoolean and(EolBoolean operand){
		return new EolBoolean(this.value && operand.getValue());
	}
	
	/*
	public EolBoolean equals(EolBoolean operand){
		return new EolBoolean(this.value == operand.getValue());
	}
	*/
	
	public EolBoolean not(){
		return new EolBoolean(!this.value);
	}
	
	public EolBoolean xor(EolBoolean operand){
		return new EolBoolean(!(value == operand.value));
	}
	
	/*
	public EolBoolean equalsValue(Object o){
		return (o instanceof EolBoolean && ((EolBoolean) o).getValue() == value);
	}
	*/
	
	@Override
	public String toString(){
		return this.value + "";
	}
	
	public boolean booleanValue(){
		return this.value;	
	}
	
}

