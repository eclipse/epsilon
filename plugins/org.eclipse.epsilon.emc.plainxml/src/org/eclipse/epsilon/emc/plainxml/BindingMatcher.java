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
package org.eclipse.epsilon.emc.plainxml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.w3c.dom.Element;

public class BindingMatcher {
	
	public static Collection<Binding> getMatchingBindings(PlainXmlModel model, Element e, String property) {
		List<Binding> bindings = new ArrayList<Binding>();
		for (Binding binding : model.getBindings()) {
			if (TagMatcher.matches(e, binding.getSourceTag())
					&& property.equals(binding.getSourceAttribute())) {
				bindings.add(binding);
			}
		}
		return bindings;
	}
	
}
