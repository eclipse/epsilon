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
package org.eclipse.epsilon.test.util.hamcrest;

import java.util.Collection;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/*
 * A workaround for issue 97 until it is fixed in Hamcrest
 * See: http://code.google.com/p/hamcrest/issues/detail?id=97
 */ 
public class EmptyCollection extends TypeSafeMatcher<Collection<?>> {

	@Override
	protected boolean matchesSafely(Collection<?> item) {
		return item.isEmpty();
	}

	public void describeTo(Description description) {
		description.appendText("empty collection");
	}
	
	public static Matcher<Collection<?>> empty() {
		return new EmptyCollection();
	}
}
