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
package org.eclipse.epsilon.commons.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Properties;

public class StringProperties extends Properties{
	
	public void load(String properties){
		try {
			super.load(new ByteArrayInputStream(properties.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString(){
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			super.store(os,"");
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return os.toString();
	}
	
	@Override
	public String getProperty(String name) {
		String zuper = super.getProperty(name);
		if (zuper == null) return "";
		else return zuper;
	}
	
	@Override
	public synchronized Object put(Object key, Object value) {
		return super.put(key, StringUtil.toString(value));
	}
	
	public static void main(String[] args){
		
		StringProperties sp = new StringProperties();
		sp.put("Hello", "World");
		sp.put("Name", "World");
		sp.put("Mitsos", "World");
		
		StringProperties sp2 = new StringProperties();
		sp2.load(sp.toString());
		System.out.println(sp2.get("Name"));
		
	}
	
	public boolean getBooleanProperty(String name, boolean def) {
		String property = getProperty(name);
		if (property.equalsIgnoreCase("true")) return true;
		else if (property.equalsIgnoreCase("false")) return false;
		else return def;
	}
	
	public StringProperties clone() {
		StringProperties clone = new StringProperties();
		clone.load(this.toString());
		return clone;
	}
	
}
