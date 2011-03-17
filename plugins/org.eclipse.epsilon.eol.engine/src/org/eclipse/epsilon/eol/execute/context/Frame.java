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
package org.eclipse.epsilon.eol.execute.context;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.StringUtil;


public class Frame {
	
	private HashMap<String, Variable> storage = new HashMap<String, Variable>();
	private FrameType type;
	private AST entryPoint;
	private String label;
	private AST currentStatement;
	
	public void dispose() {

		for (Variable v : storage.values()) {
			v.dispose();
		}
		this.entryPoint = null;
		//this.storage = null;
	}
	
	public Frame clone() {
		Frame clone = new Frame(type, entryPoint);
		clone.label = label;
		clone.currentStatement = currentStatement;
		for (Variable v : storage.values()) {
			clone.storage.put(v.name, v.clone());
		}
		return clone;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Frame(FrameType type, AST entryPoint){
		this.type = type;
		this.entryPoint = entryPoint;
	}
	
	public Frame(FrameType type, AST entryPoint, String label){
		this.type = type;
		this.entryPoint = entryPoint;
		this.label = label;
	}
	
	public void put(String name, Object value) {
		put(Variable.createReadOnlyVariable(name, value));
	}
	
	public void put(Variable variable){
		storage.put(variable.getName(), variable);
	}
	
	public Variable get(String key){
		return (Variable) storage.get(key);
	}

	public Map<String, Variable> getAll() {
		return storage;
	}

	public boolean contains(String key){
		return storage.containsKey(key);
	}

	public FrameType getType() {
		return type;
	}

	public void setType(FrameType type) {
		this.type = type;
	}
	
	public AST getEntryPoint() {
		return entryPoint;
	}

	public void setEntryPoint(AST entryPoint) {
		this.entryPoint = entryPoint;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("------------"+ type +"-------------\r\n");
		Iterator keyIterator = storage.keySet().iterator();
		while (keyIterator.hasNext()){
			Object key = keyIterator.next();
			buffer.append(key + "     " + StringUtil.toString(storage.get(key), "null") + "\r\n");
		}
		return buffer.toString();
	}

	public void setCurrentStatement(AST ast) {
		this.currentStatement = ast;
	}

	public AST getCurrentStatement() {
		return currentStatement;
	}
}
