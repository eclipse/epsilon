/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
/**
 * 
 */
package org.eclipse.epsilon.flock.test.unit.easymock.matchers;

import java.util.Collection;

import org.easymock.EasyMock;
import org.easymock.IArgumentMatcher;

public class OneOfCollection implements IArgumentMatcher {

	public static Object oneOf(Collection<?> allowed) {
	    EasyMock.reportMatcher(new OneOfCollection(allowed));
	    return null;
	}
	
	private final Collection<?> allowed;

    private OneOfCollection(Collection<?> allowed) {
        this.allowed = allowed;
    }

    public boolean matches(Object actual) {
        return allowed.contains(actual);
    }

    public void appendTo(StringBuffer buffer) {
        buffer.append("oneOf(");
        buffer.append(allowed);
        buffer.append("\")");

    }
}