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

import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region;
import org.eclipse.epsilon.eol.execute.introspection.recording.IPropertyAccess;
import org.eclipse.epsilon.eol.execute.introspection.recording.PropertyAccess;

/**
 * A {@link PropertyAccess} with additional information ({@link #getRegion()) that
 * indicates the portion of the output that was generated from this property access. 
 */
class TracedPropertyAccess extends PropertyAccess {
	
	private final Region region;
	
	public TracedPropertyAccess(Object modelElement, String propertyName, Region region) {
		super(modelElement, propertyName);
		this.region = region;
	}
	
	public TracedPropertyAccess(IPropertyAccess propertyAccess, Region region) {
		this(propertyAccess.getModelElement(), propertyAccess.getPropertyName(), region);
	}
	
	public Region getRegion() {
		return region;
	}
}