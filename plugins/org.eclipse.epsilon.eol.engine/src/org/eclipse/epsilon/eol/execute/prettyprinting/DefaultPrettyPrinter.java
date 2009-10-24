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
package org.eclipse.epsilon.eol.execute.prettyprinting;

import java.util.Iterator;

import org.eclipse.epsilon.commons.util.StringUtil;
import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.eol.types.EolMap;

public class DefaultPrettyPrinter implements PrettyPrinter{
	
	PrettyPrinterManager manager = null;
	
	public DefaultPrettyPrinter(PrettyPrinterManager manager){
		this.manager = manager;
	}
	
	public boolean appliesTo(Object o) {
		return true;
	}

	public String print(Object o) {
		
		if (o instanceof EolCollection){
			String simpleClassName = o.getClass().getSimpleName();
			String result = simpleClassName.substring(3, simpleClassName.length()) + " {";
			Iterator li = ((EolCollection) o).iterator();
			
			PrettyPrinter prettyPrinter = null;
			while (li.hasNext()){
				Object next = li.next();
				prettyPrinter = manager.getPrettyPrinterFor(next);
				result = result + prettyPrinter.print(next);
				if (li.hasNext()){
					result = result + ", ";
				}
			}
			result = result + "}";
			
			return result;
		}
		else if (o instanceof EolMap) {
			String simpleClassName = o.getClass().getSimpleName();
			String result = simpleClassName.substring(3, simpleClassName.length()) + " {";
			Iterator li = ((EolMap) o).keySet().iterator();
			
			PrettyPrinter keyPrettyPrinter = null;
			PrettyPrinter valuePrettyPrinter = null;
			while (li.hasNext()){
				Object key = li.next();
				Object value = ((EolMap) o).get(key);
				keyPrettyPrinter = manager.getPrettyPrinterFor(key);
				valuePrettyPrinter = manager.getPrettyPrinterFor(value);
				result = result + keyPrettyPrinter.print(key) + "->" + valuePrettyPrinter.print(value);
				if (li.hasNext()){
					result = result + ", ";
				}
			}
			result = result + "}";
			
			return result;
		}
		
		return StringUtil.toString(o);
	}

}
