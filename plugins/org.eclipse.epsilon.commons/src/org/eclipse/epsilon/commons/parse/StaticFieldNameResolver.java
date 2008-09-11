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
package org.eclipse.epsilon.commons.parse;

import java.lang.reflect.Field;
import java.util.HashMap;

public class StaticFieldNameResolver {
	
	HashMap<Integer, String> map = new HashMap();
	
	public StaticFieldNameResolver(Class clazz) {
		
		for (Field f : clazz.getFields()) {
			if (f.getType() == int.class) {
				try {
					map.put((Integer) f.get(null), f.getName());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public String getField(Integer value) {
		return map.get(value);
	}
	
	class Demo {
		
		public static final int a = 1;
		public static final int b = 2;
		public static final int c = 3;
		public static final int d = 4;
		
	}
	
}
