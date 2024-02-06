/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.types;

import java.util.List;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.types.concurrent.EolConcurrentMap;

public class EolMapType extends EolParametricType {
	
	public static final EolMapType
		Map = new EolMapType("Map"),
		ConcurrentMap = new EolMapType("ConcurrentMap");
	
	private final String name;
	
	/**
	 * 
	 * @param name
	 * @since 1.6
	 */
	public EolMapType(String name) {
		this(EolAnyType.Instance, EolAnyType.Instance, "ConcurrentMap".equals(name));
	}
	
	public EolMapType() {
		this("Map");
	}
	
	public EolMapType(EolType keyType, EolType valueType) {
		this(keyType, valueType, false);
	}
	
	/**
	 * 
	 * @param keyType
	 * @param valueType
	 * @param concurrent
	 * @since 1.6
	 */
	public EolMapType(EolType keyType, EolType valueType, boolean concurrent) {
		this.parameterTypes.add(keyType);
		this.parameterTypes.add(valueType);
		this.name = concurrent ? "ConcurrentMap" : "Map";
	}

	/**
	 * 
	 * @return
	 * @since 1.6
	 */
	public boolean isConcurrent() {
		return name.contains("Concurrent");
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isType(Object o) {
		return o != null && o.getClass() == (isConcurrent() ? EolConcurrentMap.class : EolMap.class);
	}

	@Override
	public boolean isKind(Object o) {
		return o instanceof EolMap;
	}
	
	@Override
	public EolMap<Object, Object> createInstance() throws EolRuntimeException {
		return isConcurrent() ? new EolConcurrentMap<>() :  new EolMap<>();
	}

	@Override
	public EolMap<Object, Object> createInstance(List<Object> parameters) throws EolRuntimeException {
		return createInstance();
	}
	
	public void setKeyType(EolType keyType) {
		this.parameterTypes.set(0, keyType);
	}
	
	public EolType getKeyType() {
		return this.parameterTypes.get(0);	
	}
	
	public void setValueType(EolType valueType) {
		this.parameterTypes.set(1, valueType);
	}
	
	public EolType getValueType() {
		return this.parameterTypes.get(1);
	}
	
	@Override
	public String toString() {
		return getName()+"<" + getKeyType().getName() + ", " + getValueType().getName() + ">";
	}
}
