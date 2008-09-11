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

import java.util.Collection;

public class EolBag extends EolCollection{

	public EolBag() {
		super();
	}
	
	public EolBag(Collection storage){
		super(storage);
	}
	
	@Override
	public EolCollection createCollection() {
		return new EolBag();
	}

	@Override
	public EolCollection createCollection(Collection storage) {
		return new EolBag(storage);
	}
	
	public static EolBag asBag(Object obj){
		if (obj instanceof EolCollection)
			return new EolBag(((EolCollection)obj).getStorage());
		else{
			EolBag result = new EolBag();
			result.add(obj);
			return result;
		}
	}
	
}
