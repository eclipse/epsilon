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

import java.util.Map;

import org.eclipse.epsilon.common.module.ModuleElement;

public interface Frame {

	void dispose();
	
	void clear();
	
	String getLabel();

	void setLabel(String label);
	
	void put(String name, Object value);
	
	void remove(String name);
	
	void put(Variable variable);

	void putAll(Map<String, Variable> variables);
	
	Variable get(String key);
	
	Map<String, Variable> getAll();
	
	boolean contains(String key);

	FrameType getType();
	
	void setType(FrameType type);
	
	ModuleElement getEntryPoint();
	
	void setEntryPoint(ModuleElement entryPoint);

	void setCurrentStatement(ModuleElement ast);

	ModuleElement getCurrentStatement();
}
