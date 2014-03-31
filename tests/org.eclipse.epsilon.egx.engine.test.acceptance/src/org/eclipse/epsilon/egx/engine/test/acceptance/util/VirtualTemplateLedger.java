/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egx.engine.test.acceptance.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualTemplateLedger {

	private final Map<String, String> output = new HashMap<String, String>();
	
	public void add(String path, String contents) {
		output.put(path, contents);
	}
	
	public Collection<String> getOutputFiles() {
		return output.keySet();
	}

	public Object getContentFor(String path) {
		return output.get(path);
	}
}
