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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EolOrderedSet extends EolSet{
	
	public EolOrderedSet(){
		//super();
		storage = new ArrayList();
	}
	
	public EolOrderedSet(Collection col) {
		super(col);
	}
	
	public EolOrderedSet prepend(Object o){
		EolOrderedSet appended = new EolOrderedSet(this.storage);
		appended.add(new EolInteger(0),o);
		return appended;		
	}
	
	public void add(EolInteger i, Object o){
		//if (i.lessThan(this.size().add(new EolInteger(1))).booleanValue()){
		((List) storage).add(i.intValue(), o);
		//}
	}
	public static EolOrderedSet asOrderedSet(Object obj){
		if (obj instanceof EolOrderedSet){
			return (EolOrderedSet)obj;
		}
		else if (obj instanceof EolCollection) {
			EolOrderedSet result = new EolOrderedSet(((EolCollection)obj).clone().getStorage());
			result.removeDuplicates();
			return result;
		}
		else{
			EolOrderedSet result = new EolOrderedSet();
			result.add(obj);
			return result;
		}
	}
	
	@Override
	public EolCollection createCollection() {
		return new EolOrderedSet();
	}

	@Override
	public EolCollection createCollection(Collection storage) {
		return new EolOrderedSet(storage);
	}
	
	/**
	 * Returns a new subset that contains
	 * the elements of this ordered set starting 
	 * from <code>lower</code> and ending at
	 * <code>upper</code>
	 * @param lower
	 * @param upper
	 * @return EolOrderedSet
	 */
	public EolOrderedSet subset(EolInteger lower, EolInteger upper){
		return new EolOrderedSet(((List)storage).subList(lower.intValue(), upper.intValue()));
	}
}
