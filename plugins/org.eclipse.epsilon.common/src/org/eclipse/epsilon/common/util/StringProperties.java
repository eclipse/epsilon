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
package org.eclipse.epsilon.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Properties;

@SuppressWarnings("serial")
public class StringProperties extends Properties{
	
	public StringProperties() {
		
	}
	
	public StringProperties(String properties) {
		load(properties);
	}
	
	public void load(String properties){
		try {
			super.load(new ByteArrayInputStream(properties.getBytes()));
		} catch (IOException e) {
			throw new RuntimeException(e);
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

		// Get rid of the first two lines (comment + date)
		String str = os.toString();
		try {
			return str.replaceAll("^#.*(\n|\r)", "").replaceAll("^#.*(\n|\r)", "").trim();
		}
		catch (Exception ex) {
			return str;
		}
	}
	
	public boolean hasProperty(String key) {
		return containsKey(key) && !getProperty(key).isEmpty();
	}
	
	@Override
	public String getProperty(String key) {
		String zuper = super.getProperty(key);
		if (zuper == null) return "";
		else return zuper;
	}
	
	
	@Override
	public String getProperty(String key, String defaultValue) {
		String value = getProperty(key);
		return value.isEmpty() ? defaultValue : value;
	}

	public int getIntegerProperty(String key, int default_) {
		if (containsKey(key)) {
			return Integer.parseInt(getProperty(key));
		}
		else {
			return default_;
		}
	}
	
	@Override
	public synchronized Object put(Object key, Object value) {
		return super.put(key, StringUtil.toString(value));
	}
	
	public boolean getBooleanProperty(String key, boolean def) {
		String property = getProperty(key);
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
