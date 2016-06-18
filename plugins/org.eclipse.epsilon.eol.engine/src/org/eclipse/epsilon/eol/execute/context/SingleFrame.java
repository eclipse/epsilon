/*******************************************************************************
 * Copyright (c) 2008-2012 The University of York, Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - split into interface + implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.context;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.util.StringUtil;

/**
 * An individual stack frame for the EOL frame stack.
 */
public class SingleFrame implements Frame {

	private HashMap<String, Variable> storage = new LinkedHashMap<String, Variable>();
	private FrameType type;
	private ModuleElement entryPoint;
	private String label;
	private ModuleElement currentStatement;

	public SingleFrame(FrameType type, ModuleElement entryPoint){
		this.type = type;
		this.entryPoint = entryPoint;
	}
	
	public SingleFrame(FrameType type, ModuleElement entryPoint, String label){
		this.type = type;
		this.entryPoint = entryPoint;
		this.label = label;
	}

	@Override
	public void dispose() {
		for (Variable v : storage.values()) {
			v.dispose();
		}
		this.entryPoint = null;
		//this.storage = null;
	}
	
	@Override
	public void clear() {
		storage.clear();
		currentStatement = null;
	}
	
	public SingleFrame clone() {
		SingleFrame clone = new SingleFrame(type, entryPoint);
		clone.label = label;
		clone.currentStatement = currentStatement;
		for (Variable v : storage.values()) {
			clone.storage.put(v.name, v.clone());
		}
		return clone;
	}

	@Override
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	@Override
	public void put(String name, Object value) {
		put(Variable.createReadOnlyVariable(name, value));
	}
	
	@Override
	public void remove(String name) {
		storage.remove(name);
	}
	
	@Override
	public void put(Variable variable){
		storage.put(variable.getName(), variable);
	}
	
	@Override
	public void putAll(Map<String, Variable> variables) {
		storage.putAll(variables);
	}
	
	@Override
	public Variable get(String key){
		return storage.get(key);
	}

	@Override
	public Map<String, Variable> getAll() {
		return storage;
	}

	@Override
	public boolean contains(String key){
		return storage.containsKey(key);
	}

	@Override
	public FrameType getType() {
		return type;
	}

	@Override
	public void setType(FrameType type) {
		this.type = type;
	}
	
	@Override
	public ModuleElement getEntryPoint() {
		return entryPoint;
	}

	@Override
	public void setEntryPoint(ModuleElement entryPoint) {
		this.entryPoint = entryPoint;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("------------"+ type +"-------------\r\n");
		Iterator<String> keyIterator = storage.keySet().iterator();
		while (keyIterator.hasNext()){
			Object key = keyIterator.next();
			buffer.append(key + "     " + StringUtil.toString(storage.get(key), "null") + "\r\n");
		}
		return buffer.toString();
	}

	@Override
	public void setCurrentStatement(ModuleElement ast) {
		this.currentStatement = ast;
	}

	@Override
	public ModuleElement getCurrentStatement() {
		return currentStatement;
	}
}
