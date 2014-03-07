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

class PropertyAccessWithPosition {
	public final IPropertyAccess propertyAccess;
	public final Region region;
	
	public PropertyAccessWithPosition(IPropertyAccess propertyAccess, Region region) {
		this.propertyAccess = propertyAccess;
		this.region = region;
	}
}