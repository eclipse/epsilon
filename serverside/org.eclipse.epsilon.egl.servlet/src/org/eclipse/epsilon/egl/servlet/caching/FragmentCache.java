/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.servlet.caching;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;

public class FragmentCache {

	private final Map<String, String> fragmentCache = new HashMap<String, String>();
	
	public String cache(EglTemplate template) throws EglRuntimeException {
		if (fragmentCache.containsKey(template.getName())) {
			return fragmentCache.get(template.getName());
		} else {
			final String fragment = template.process();
			fragmentCache.put(template.getName(), fragment);
			return fragment;
		}
	}
	
	public void expire(EglTemplate template) {
		fragmentCache.remove(template.getName());
	}
}
