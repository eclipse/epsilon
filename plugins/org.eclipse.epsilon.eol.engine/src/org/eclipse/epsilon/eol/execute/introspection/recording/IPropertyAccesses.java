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
package org.eclipse.epsilon.eol.execute.introspection.recording;

import java.util.Collection;
import java.util.Set;

public interface IPropertyAccesses {

	public Collection<? extends IPropertyAccess> all();

	public Set<? extends IPropertyAccess> unique();

	public boolean isEmpty();

}
