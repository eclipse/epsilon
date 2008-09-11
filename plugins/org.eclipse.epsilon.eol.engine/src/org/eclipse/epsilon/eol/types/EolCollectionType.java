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

public class EolCollectionType extends EolType{

	private Class clazz;
	private String name;
	
	public static EolCollectionType Collection = new EolCollectionType(EolCollection.class, "Collection");
	public static EolCollectionType Bag = new EolCollectionType(EolBag.class, "Bag");
	public static EolCollectionType Sequence = new EolCollectionType(EolSequence.class, "Sequence");
	public static EolCollectionType Set = new EolCollectionType(EolSet.class, "Set");
	public static EolCollectionType OrderedSet = new EolCollectionType(EolOrderedSet.class, "OrderedSet");
	
	private EolCollectionType(Class clazz, String name){
		this.clazz = clazz;
		this.name = name;
	}
	
	@Override
	public boolean isType(Object o) {
		if (o == null) return true;
		return o.getClass() == clazz;
	}

	@Override
	public boolean isKind(Object o) {
		return clazz.isInstance(o);
	}
	
	@Override
	public Object createInstance() {
		try {
			return clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getName() {
		return name;
	}
}
