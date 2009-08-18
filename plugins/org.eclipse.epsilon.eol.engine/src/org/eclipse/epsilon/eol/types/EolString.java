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

import java.io.FileOutputStream;

public class EolString extends EolPrimitive{
	
	protected String value = "";
	
	public EolString(){
		this.value = "";
	}
	
	public EolString(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
	
	public void setValue(String value){
		this.value = value;
	}
	
	@Override
	public String toString(){
		return value;
	}
	
	public EolString concat(EolString right){
		return new EolString(this.value.concat(right.value));
	}
	
	public EolSequence split(EolString delimiter){
		return new EolSequence(this.value.split(delimiter.value));
	}
	
	public EolBoolean isSubstringOf(EolString str) {
		return new EolBoolean(str == null ? false : str.value.indexOf(this.value) > -1);
	}
	
	public EolBoolean matches(EolString expression){
		return new EolBoolean(this.value.matches(expression.value));
	}
	
	public EolBoolean equalsValue(EolString s){
		return new EolBoolean(this.value.compareTo(s.value) == 0);
	}
	
	public String stringValue(){
		return value;
	}
	
	public EolString firstToUpperCase(){
		if (value.length() > 0) {
			return new EolString(value.substring(0,1).toUpperCase() + value.substring(1, value.length()));
		}
		else {
			return new EolString("");
		}
	}
	
	public EolString substring(EolInteger startIndex) {
		return new EolString(value.substring(startIndex.intValue()));
	}
	
	public EolString substring(EolInteger startIndex, EolInteger endIndex) {
		return new EolString(value.substring(startIndex.intValue(), endIndex.intValue()));
	}
	
	public EolString firstToLowerCase(){
		if (value.length() > 0) {
			return new EolString(value.substring(0,1).toLowerCase() + value.substring(1, value.length()));
		}
		else {
			return new EolString("");
		}
	}
	
	public EolString ftuc(){
		return firstToUpperCase();
	}
	
	public EolString ftlc(){
		return firstToLowerCase();
	}
	
	public EolBoolean startsWith(EolString str){
		if (value.startsWith(str.getValue())) return EolBoolean.TRUE;
		else return EolBoolean.FALSE;
	}

	public EolBoolean endsWith(EolString str){
		if (value.endsWith(str.getValue())) return EolBoolean.TRUE;
		else return EolBoolean.FALSE;
	}
	
	public EolString toUpperCase(){
		return new EolString(value.toUpperCase());
	}
	
	public EolString toLowerCase(){
		return new EolString(value.toLowerCase());
	}
	
	public EolSequence toCharSequence(){
		EolSequence charSeq = new EolSequence();
		for (int i=0;i<value.length();i++){
			charSeq.add(new EolString(value.charAt(i)+""));
		}
		return charSeq;
	}
	
	public EolString charAt(EolInteger index){
		return new EolString(value.charAt(index.intValue()) + "");
	}
	
	public EolString replace(EolString what, EolString repl){
		return new EolString(value.replaceAll(what.stringValue().replaceAll("\\\\", "\\\\\\\\"), repl.stringValue().replaceAll("\\\\", "\\\\\\\\")));
	}
	
	public EolString trim(){
		return new EolString(value.trim());
	}
	
	public void store(EolString where) throws Exception {
		FileOutputStream fos = new FileOutputStream(where.getValue());
		fos.write(this.getValue().getBytes());
		fos.flush();
		fos.close();
	}
	
	public EolInteger length() {
		return new EolInteger(value.length());
	}
	
	public EolInteger asInteger() {
		return new EolInteger(value);
	}
	
	public EolBoolean isInteger() {
		try {
			Integer.parseInt(value);
			return EolBoolean.TRUE;
		}
		catch (Exception ex) {
			return EolBoolean.FALSE;
		}
	}
	
	public EolBoolean isReal() {
		try {
			Double.parseDouble(value);
			return EolBoolean.TRUE;
		}
		catch (Exception ex) {
			return EolBoolean.FALSE;
		}
	}
	
	public EolReal asReal() {
		return new EolReal(value, true);
	}
	
	public EolReal asFloat() {
		return new EolReal(value, false);
	}
}
