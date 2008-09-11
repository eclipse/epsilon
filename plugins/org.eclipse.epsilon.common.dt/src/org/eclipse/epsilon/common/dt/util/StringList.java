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
package org.eclipse.epsilon.common.dt.util;

import java.util.ArrayList;
import java.util.Collection;

public class StringList extends ArrayList{
	
	public StringList(Collection c){
		super(c);
	}
	
	public StringList() {
		super();
	}
	
	@Override
	public boolean equals(Object other){

		if (other instanceof StringList){
			StringList otherList = (StringList) other;
			if (this.size() != otherList.size()) return false;
			for (int i=0;i<this.size();i++){
				if (!this.get(i).equals(otherList.get(i))){
					return false;
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	
}
