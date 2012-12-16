/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations.contributors;

import java.io.FileOutputStream;
import java.util.List;

import org.eclipse.epsilon.common.util.CollectionUtil;

public class StringOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return (target instanceof String || target instanceof Character);
	}
	
	public Object toEnum() throws Exception {
		return context.getModelRepository().getEnumerationValue(target + "");
	}
	
	@Override
	public void setTarget(Object target) {
		if (target instanceof Character) {
			this.target = target + "";
		}
		else {
			super.setTarget(target);			
		}
	}
	
	public String firstToUpperCase() {
		String value = (String) target;
		return value.substring(0,1).toUpperCase() + value.substring(1, value.length());
	}
	
	public String firstToLowerCase() {
		String value = (String) target;
		return value.substring(0,1).toLowerCase() + value.substring(1, value.length());
	}
	
	public String ftuc() {
		return firstToUpperCase();
	}
	
	public String ftlc() {
		return firstToLowerCase();
	}
	
	public void store(String where) throws Exception {
		String value = (String) target;
		FileOutputStream fos = new FileOutputStream(where);
		fos.write(value.getBytes());
		fos.flush();
		fos.close();
	}
	
	public boolean isSubstringOf(String str) {
		String value = (String) target;
		return (str == null ? false : str.indexOf(value) > -1);
	}
	
	public List toCharSequence(){
		String value = (String) target;
		List charSeq = CollectionUtil.createDefaultList();
		for (int i=0;i<value.length();i++){
			charSeq.add(value.charAt(i)+"");
		}
		return charSeq;
	}
	
	public String pad(int width, String padding, boolean right) {
		String result = (String) target;
		int pad = width - result.length();
		while (pad > 0) {
			if (right) {
				result = result + padding;
			}
			else {
				result = padding + result;
			}
			pad = pad - 1;
		}
		return result;
	}
}
