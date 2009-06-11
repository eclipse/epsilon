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

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class EolReal extends EolPrimitive implements Comparable {
	
	protected double value = 0.0d;
	
	protected boolean doublePrecision;
	
	public void setDoublePrecision(boolean doublePrecision) {
		this.doublePrecision = doublePrecision;
	}
	
	public boolean isDoublePrecision() {
		return doublePrecision;
	}
	
	public EolReal(){
		this.value = 0.0d;
		this.doublePrecision = false;
	}
	
	public EolReal(double value, boolean doublePrecision){
		this.value = value;
		this.doublePrecision = doublePrecision;
	}
	
	public EolReal(String value, boolean doublePrecision){
		try {
			this.value = Double.parseDouble(value);
			this.doublePrecision = doublePrecision;
		}
		catch (Exception ex){
			this.value = 0.0d;
		}
	}
	
	public float floatValue() {
		return Float.parseFloat(value + "");
	}
	
	public double getValue(){
		return value;
	}
	
	public void setValue(double value){
		this.value = value;
	}
	
	@Override
	public String toString(){
		return value + "";
	}
	
	public EolReal add(EolReal i){
		return new EolReal(this.value + i.getValue(), this.isDoublePrecision() || i.isDoublePrecision());
	}
	
	public EolReal subtract(EolReal i){
		return new EolReal(this.value - i.getValue(), this.isDoublePrecision() || i.isDoublePrecision());
	}
	
	public EolReal multiply(EolReal i){
		return new EolReal(this.value * i.getValue(), this.isDoublePrecision() || i.isDoublePrecision());
	}
	
	public EolReal abs(){
		return new EolReal(Math.abs(this.value), this.isDoublePrecision());
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
	
	public double doubleValue(){
		return value;
	}

	public EolReal divide(EolReal i) throws EolRuntimeException {
		if (i.getValue() == 0) throw new EolRuntimeException("Divide by zero");
		return new EolReal(this.doubleValue() / i.doubleValue(), this.isDoublePrecision() || i.isDoublePrecision()); 
	}

	public EolReal negative() {
		return new EolReal(0-this.doubleValue(), this.isDoublePrecision());
	}
	
	public EolReal max(EolReal compareTo){
		if (this.doubleValue() > compareTo.doubleValue()) return this;
		else return compareTo;
	}

	public EolReal min(EolReal compareTo){
		if (this.doubleValue() > compareTo.doubleValue()) return compareTo;
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
			return Double.compare(this.value, ((EolReal)opposite).value);
		}
		
		return -1;
	}
}
