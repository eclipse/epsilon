/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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

    @Override
	public boolean matches(Object actual) {
        return allowed.contains(actual);
    }

    @Override
	public void appendTo(StringBuffer buffer) {
        buffer.append("oneOf(");
        buffer.append(allowed);
        buffer.append("\")");

    }
}
