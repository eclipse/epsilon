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
package org.eclipse.epsilon.egl.engine.traceability.fine.internal;

import java.util.Collection;

import org.eclipse.epsilon.common.util.Multimap;
import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region;
import org.eclipse.epsilon.eol.execute.introspection.recording.IPropertyAccess;

public class TracedPropertyAccessLedger {
	
	private final Multimap<EglTemplate, TracedPropertyAccess> accessesByTemplate = new Multimap<EglTemplate, TracedPropertyAccess>();
	
	void associate(IPropertyAccess access, Region region, EglTemplate template) {
		accessesByTemplate.put(template, new TracedPropertyAccess(access, region));
	}

	Collection<TracedPropertyAccess> retrieve(EglTemplate template) {
		return accessesByTemplate.get(template);
	}
}