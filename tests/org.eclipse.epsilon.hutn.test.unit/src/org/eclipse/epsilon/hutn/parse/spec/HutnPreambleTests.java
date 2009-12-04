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
package org.eclipse.epsilon.hutn.parse.spec;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.eclipse.epsilon.hutn.model.hutn.NsUri;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

public class HutnPreambleTests {

	@Test
	public void metamodel() {	
		assertThat(preambleNsUris("@Spec { metamodel { nsUri: \"families\" } }"), contains(NsUriMatcher.nsUri("families")));
	}
	
	@Test
	public void metamodelWithConfigFile() {	
		assertThat(preambleNsUris("@Spec { metamodel { nsUri: \"families\" configFile: \"families.config\" } }"), contains(NsUriMatcher.nsUri("families")));
	}
	
	@Test
	public void twoMetamodels() {	
		assertThat(preambleNsUris("@Spec { metamodel { nsUri: \"families\" configFile: \"families.config\" } metamodel2 { nsUri: \"pets\" configFile: \"pets.config\" } }"), contains(NsUriMatcher.nsUri("families"), NsUriMatcher.nsUri("pets")));
	}
	
	@Test
	public void modelFile() {	
		assertThat(preambleNsUris("@Spec { metamodel { nsUri: \"families\" configFile: \"families.config\" } { model { file: \"output.model\" } }"), contains(NsUriMatcher.nsUri("families")));
	}
	
	
	
	@Test
	public void noMetamodels() {
		assertEquals(0, preambleNsUris("@Spec {}").size());
	}
	
	@Test
	public void emptyPreamble() {
		assertEquals(0, preambleNsUris("").size());
	}
	
	@Test
	public void notAPreamble() {
		assertEquals(0, preambleNsUris("families { Family \"The Smiths\" { } }").size());
	}

	
	
	private static Collection<NsUri> preambleNsUris(String hutn) {
		return new HutnPreamble().process(hutn).getNsUris();
	}
	
	
	private static class NsUriMatcher extends TypeSafeMatcher<NsUri> {

		private final String value;
		
		public NsUriMatcher(String value) {
			this.value = value;
		}

		@Override
		protected boolean matchesSafely(NsUri nsUri) {
			return value.equals(nsUri.getValue());
		}

		public void describeTo(Description description) {
			description.appendText("nsUri: ");
			description.appendText(value);
		}
		
		public static Matcher<NsUri> nsUri(String value) {
			return new NsUriMatcher(value);
		}
	}
}
