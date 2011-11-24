package org.eclipse.epsilon.emc.bibtex;
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


import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.epsilon.emc.bibtex.domain.Bibliography;
import org.eclipse.epsilon.emc.bibtex.domain.Publication;
import org.eclipse.epsilon.emc.bibtex.parser.BibtexUnparser;
import org.junit.Test;

@SuppressWarnings("unchecked")
public class BibtextUnparserTests {

	@Test
	public void singleProperty() throws Throwable {
		final String bibtex = unparse(bibliography(publication("article", property("author", "Joe Bloggs"))));

		assertThat(bibtex, startsWith("@article{"));
		assertThat(bibtex, containsString("author = {Joe Bloggs},"));
		assertThat(bibtex, endsWith("}"));
	}
	
	@Test
	public void identifier() throws Throwable {
		final String bibtex = unparse(bibliography(publication("article", "doe10theories", property("author", "Joe Bloggs"))));

		assertThat(bibtex, startsWith("@article{doe10theories"));
		assertThat(bibtex, containsString("author = {Joe Bloggs},"));
		assertThat(bibtex, endsWith("}"));
	}
	
	@Test
	public void severalProperties() throws Throwable {
		final String bibtex = unparse(bibliography(publication("article",
		                                                       property("author", "Joe Bloggs"),
		                                                       property("year",   "2010"),
		                                                       property("issue",  "1"))));

		assertThat(bibtex, startsWith("@article{"));
		assertThat(bibtex, containsString("author = {Joe Bloggs},"));
		assertThat(bibtex, containsString("year = {2010},"));
		assertThat(bibtex, containsString("issue = {1},"));
		assertThat(bibtex, endsWith("}"));
	}
	
	@Test
	public void severalPublications() throws Throwable {
		final String bibtex = unparse(bibliography(publication("article", property("author", "Joe Bloggs")),
		                                           publication("journal", property("author", "John Doe")),
		                                           publication("book",    property("author", "A.N. Other"))));

		final String[] entries = Pattern.compile("^" + "\\}" + "\\s" + "*", Pattern.MULTILINE).split(bibtex);
		
		assertEquals(3, entries.length);
		
		assertThat(entries[0], startsWith("@article{"));
		assertThat(entries[0], containsString("author = {Joe Bloggs},"));
		
		assertThat(entries[1], startsWith("@journal{"));
		assertThat(entries[1], containsString("author = {John Doe},"));
		
		assertThat(entries[2], startsWith("@book{"));
		assertThat(entries[2], containsString("author = {A.N. Other},"));
	}
	
	private static String unparse(Bibliography bibliography) {
		return new BibtexUnparser(bibliography).unparse().trim();
	}

	private static Bibliography bibliography(Publication... publications) {
		final Bibliography bibliography = new Bibliography();
		
		for (Publication publication : publications) {
			bibliography.add(publication);
		}
		
		return bibliography;
	}
	
	private static Publication publication(String type, Pair<String,String>... properties) {
		return new Publication(type, map(properties));
	}
	
	private static Publication publication(String type, String id, Pair<String,String>... properties) {
		return new Publication(type, id, map(properties));
	}
	
	private static <K,V> Map<K,V> map(Pair<K,V>... entries) {
		final Map<K,V> map = new HashMap<K, V>();

		for (Pair<K, V> entry : entries) {
			map.put(entry.first, entry.second);
		}

		return map;
	}

	private static <K,V> Pair<K,V> property(K key, V value) {
		return new Pair<K,V>(key, value);
	}

	private static class Pair<A,B> {
		public final A first;
		public final B second;

		public Pair(A first, B second) {
			this.first = first;
			this.second = second;
		}
	}

}