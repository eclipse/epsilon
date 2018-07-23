/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.common.dt.util;

import java.util.ArrayList;
import java.util.Collection;

public class StringList extends ArrayList<String> {
	
	public StringList(Collection<String> c){
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
