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

public class EolReal extends EolPrimitive implements Comparable {
	
	protected float value = 0.0f;
	
	public EolReal(){
		this.value = 0.0f;
	}
	
	public EolReal(float value){
		this.value = value;
	}
	
	public EolReal(String value){
		try {
			this.value = Float.parseFloat(value);
		}
		catch (Exception ex){
			this.value = 0.0f;
		}
	}
	
	public float getValue(){
		return value;
	}
	
	public void setValue(float value){
		this.value = value;
	}
	
	@Override
	public String toString(){
		return value + "";
	}
	
	public EolReal add(EolReal i){
		return new EolReal(this.value + i.getValue());
	}
	
	public EolReal subtract(EolReal i){
		return new EolReal(this.value - i.getValue());
	}
	
	public EolReal multiply(EolReal i){
		return new EolReal(this.value * i.getValue());
	}
	
	public EolReal abs(){
		return new EolReal(Math.abs(this.value));
	}
	
	public EolBoolean greaterThan(EolReal i){
		return new EolBoolean(this.value > i.value);
	}
	
	public EolBoolean lessThan(EolReal i){
		return new EolBoolean(this.value < i.value);
	}
	
	
	public EolBoolean equalsValue(EolReal i){
		return new EolBoolean(this.value == i.value);
	}
	
	public float floatValue(){
		return value;
	}

	public EolReal divide(EolReal i) {
		return new EolReal(this.floatValue() / i.floatValue()); 
	}

	public EolReal negative() {
		return new EolReal(0-this.floatValue());
	}
	
	public EolReal max(EolReal compareTo){
		if (this.floatValue() > compareTo.floatValue()) return this;
		else return compareTo;
	}

	public EolReal min(EolReal compareTo){
		if (this.floatValue() > compareTo.floatValue()) return compareTo;
		else return this;
	}
	
	public EolInteger floor() {
		return new EolInteger((int)Math.floor(value));
	}
	
	public EolInteger ceiling() {
		return new EolInteger((int)Math.ceil(value));
	}
	
	@Override
	public int compareTo(Object opposite){
		if (opposite == null) return -1;
		
		if (opposite.getClass().equals(this.getClass())){
			return Float.compare(this.value, ((EolReal)opposite).value);
		}
		
		return -1;
	}
}
