/*******************************************************************************
 * Copyright (c) 2010 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.commons.util;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.epsilon.common.util.Multimap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({MultimapTests.PutAndGetTests.class,
                     MultimapTests.PutAllTests.class,
                     MultimapTests.RemoveTests.class,
                     MultimapTests.ClearTests.class,
                     MultimapTests.ContainsKeyTests.class,
                     MultimapTests.ReplaceValuesTests.class})
public class MultimapTests {
	
	public static class PutAndGetTests {
		private static Multimap<String, String> multimap;
		
		@Before
		public void setup() {
			multimap = new Multimap<String, String>();
		}
		
		@Test
		public void shouldHaveNoValuesForAKey() throws Exception {
			assertThat(multimap.get("students"), hasSize(0));
		}
		
		@Test
		public void shouldRecallPutValues() throws Exception {
			multimap.put("students", "Louis");
			
			assertThat(multimap.get("students"), contains("Louis"));
			assertThat(multimap.get("students"), hasSize(1));
		}
		
		@Test
		public void shouldRecallAllPutValues() throws Exception {
			multimap.put("students", "Louis");
			multimap.put("students", "James");
			
			assertThat(multimap.get("students"), contains("Louis", "James"));
			assertThat(multimap.get("students"), hasSize(2));
		}
		
		@Test
		public void shouldRecallOnlyThoseValuesForSpecifiedKey() throws Exception {
			multimap.put("students", "Louis");
			multimap.put("lecturers", "Dimitris");
			
			assertThat(multimap.get("students"), contains("Louis"));
			assertThat(multimap.get("students"), hasSize(1));
		}
		
		public void shouldNotAllowClientsToAffectInteralState() throws Exception {
			multimap.put("students", "Louis");
			multimap.get("students").add("James");
			
			assertThat(multimap.get("students"), contains("Louis"));
			assertThat(multimap.get("students"), not(hasItem("James")));
		}
	}

	public static class PutAllTests {
		@Test
		public void shouldPutValuesInCollection() {
			final Multimap<String, String> multimap = new Multimap<String, String>();
			multimap.putAll("students", Arrays.asList("Louis", "James", "Frank"));
			
			assertThat(multimap.get("students"), contains("Louis", "James", "Frank"));
			assertThat(multimap.get("students"), hasSize(3));
		}
	}
	
	public static class RemoveTests {
		private static Multimap<String, String> multimap;
		
		@Before
		public void setup() {
			multimap = new Multimap<String, String>();
		}
		
		@Test
		public void shouldRemoveTheGivenKeyValuePair() throws Exception {
			multimap.putAll("students", Arrays.asList("Louis", "James", "Frank"));
			multimap.remove("students", "James");
			
			assertThat(multimap.get("students"), contains("Louis", "Frank"));
			assertThat(multimap.get("students"), hasSize(2));
		}
		
		@Test
		public void shouldDoNothingWhenAKeyHasNoValue() throws Exception {
			multimap.remove("students", "Anyone");
			
			assertThat(multimap.get("students"), hasSize(0));
		}
	}
	
	public static class ClearTests {
		private static Multimap<String, String> multimap;
		
		@Before
		public void setup() {
			multimap = new Multimap<String, String>();
		}
		
		@Test
		public void clearShouldRemoveAllValues() throws Exception {
			multimap.putAll("students", Arrays.asList("Louis", "James", "Frank"));
			multimap.put("lecturers", "Dimitris");
			
			multimap.clear();
			
			assertThat(multimap.get("students"),  hasSize(0));
			assertThat(multimap.get("lecturers"), hasSize(0));
		}
	}
	
	public static class ContainsKeyTests {
		private static Multimap<String, String> multimap;
		
		@Before
		public void setup() {
			multimap = new Multimap<String, String>();
		}
		
		@Test
		public void shouldBeTrueForKeyWithValues() throws Exception {
			multimap.putAll("students", Arrays.asList("Louis", "James", "Frank"));
			
			assertTrue(multimap.containsKey("students"));
		}
		
		@Test
		public void shouldBeFalseForKeyForWhichNoValuesHaveBeenPut() throws Exception {
			assertFalse(multimap.containsKey("students"));
		}
		
		@Test
		public void shouldBeFalseForKeyWhenAllValuesAreRemoved() throws Exception {
			multimap.put("students", "Louis");
			multimap.remove("students", "Louis");
			
			assertFalse(multimap.containsKey("students"));
		}
		
		@Test
		public void shouldBeFalseForKeyWhenEmptyCollectionIsPut() throws Exception {
			multimap.putAll("students", new ArrayList<String>());
			
			assertFalse(multimap.containsKey("students"));
		}
	}
	
	public static class ReplaceValuesTests {
		private static Multimap<String, String> multimap;
		
		@Before
		public void setup() {
			multimap = new Multimap<String, String>();
		}
		
		@Test
		public void shouldReplaceExistingValues() throws Exception {
			multimap.putAll("students", Arrays.asList("Louis", "Nikos"));
			multimap.replaceValues("students", Arrays.asList("James", "Frank"));
			
			assertThat(multimap.get("students"), contains("James", "Frank"));
		}
		
		@Test
		public void shouldReplaceExistingValuesWhenThereAreNoValues() throws Exception {
			multimap.putAll("students", new ArrayList<String>());
			multimap.replaceValues("students", Arrays.asList("James", "Frank"));
			
			assertThat(multimap.get("students"), contains("James", "Frank"));
		}
		
		@Test
		public void shouldReplaceExistingValuesWhenKeyHasNotBeenUsedYet() throws Exception {
			multimap.replaceValues("students", Arrays.asList("James", "Frank"));
			
			assertThat(multimap.get("students"), contains("James", "Frank"));
		}
	}
}
