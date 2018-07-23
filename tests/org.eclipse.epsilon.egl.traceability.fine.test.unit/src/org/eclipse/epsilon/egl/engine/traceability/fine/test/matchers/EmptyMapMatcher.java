/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.engine.traceability.fine.test.matchers;

import java.util.Map;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class EmptyMapMatcher extends TypeSafeMatcher<Map<?,?>> {

	@Override
	public void describeTo(Description description) {
		description.appendText("an empty map");
	}

	@Override
	protected boolean matchesSafely(Map<?, ?> item) {
		return item.isEmpty();
	}
	
	public static EmptyMapMatcher hasNoEntries() {
		return new EmptyMapMatcher();
	}
}
