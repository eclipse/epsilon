/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.ecl.trace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
import org.eclipse.epsilon.ecl.dom.MatchRule;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

/**
 * 
 *
 * @since 1.6 Can be accessed through Collection API rather than getMatches for convenience
 */
public class MatchTrace implements Collection<Match> {
	
	/**
	 * All matches tried during the  execution of an ECL module
	 */
	protected Collection<Match> matches;
	
	protected boolean concurrent;
	
	protected String toStringCached;
	
	public MatchTrace() {
		this(false);
	}
	
	public MatchTrace(boolean concurrent) {
		matches = (this.concurrent = concurrent) ? ConcurrencyUtils.concurrentOrderedCollection() : new ArrayList<>();
	}
	
	public MatchTrace(MatchTrace copy) {
		this(Objects.requireNonNull(copy).concurrent);
		this.matches.addAll(copy.matches);
	}
	
	/**
	 * Returns only successful matches
	 */
	public MatchTrace getReduced() { 
		MatchTrace reduced = new MatchTrace(concurrent);
		for (Match match : matches) {
			if (match.isMatching()) {
				reduced.add(match);
			}
		}
		return reduced;
	}
	
	public Match add(Object left, Object right, boolean matching, MatchRule rule) {
		Match match = new Match(left, right, matching, rule);
		add(match);
		return match;
	}
	
	public Match getMatch(Object left, Object right) {
		for (Match match : matches) {
			if (match.contains(left, right)) {
				return match;
			}
		}
		return null;
	}
	
	/**
	 * Returns all the matches for a given object
	 * @param object
	 * @return
	 */
	public Collection<Match> getMatches(Object object) {
		return matches.stream()
			.filter(match -> match.isMatching() && match.contains(object))
			.collect(Collectors.toList());
	}
	
	/**
	 * Returns the first match for the object
	 * @param object
	 * @return
	 */
	public Match getMatch(Object object) {
		for (Match match : matches) {
			if (match.contains(object) && match.isMatching()) {
				return match;
			}
		}
		return null;
	}
	
	public Match getMatch(Object left, MatchRule rule) {
		for (Match match : matches) {
			if (match.isMatching() && match.left == left && match.getRule() == rule) {
				return match;
			}
		}
		return null;
	}
	
	public boolean hasBeenMatched(Object object) {
		for (Match match : matches) {
			if (match.contains(object)) {
				return true;
			}
		}
		return false;
	}
	
	public String toString(IEolContext context) {
		String str = "";
		
		for (Match match : matches) {
			str += "[" + match.isMatching() + "]\n";
			str += context.getPrettyPrinterManager().toString(match.getLeft());
			str += "\n ->" + context.getPrettyPrinterManager().toString(match.getRight());
		}
		str += "\n-------------------------------------------";
		
		return toStringCached = str;
	}

	/**
	 * Returns all matches, both successful and 
	 * pairs that have been compared but do not match
	 * @return
	 */
	public Collection<Match> getMatches() {
		return Collections.unmodifiableCollection(matches);
	}

	
	/**
	 * 
	 * @return
	 * @since 1.6
	 */
	@Override
	public Stream<Match> stream() {
		return matches.stream();
	}
	
	/**
	 * @since 1.6
	 */
	@Override
	public String toString() {
		return toStringCached != null ? toStringCached : super.toString();
	}
	
	/**
	 * @since 1.6
	 */
	@Override
	public int hashCode() {
		return matches.hashCode();
	}
	
	/**
	 * @since 1.6
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof MatchTrace)) return false;
		MatchTrace other = (MatchTrace) obj;
		
		return
			this.matches.size() == other.matches.size() &&
			this.matches.containsAll(other.matches);
	}
	
	/**
	 * @since 1.6
	 */
	@Override
	public boolean add(Match match) {
		return matches.add(match);
	}
	
	/**
	 * @since 1.6
	 */
	@Override
	public boolean remove(Object o) {
		return matches.remove(o);
	}
	
	/**
	 * @since 1.6
	 */
	@Override
	public int size() {
		return matches.size();
	}

	/**
	 * @since 1.6
	 */
	@Override
	public boolean isEmpty() {
		return matches.isEmpty();
	}

	/**
	 * @since 1.6
	 */
	@Override
	public boolean contains(Object o) {
		return matches.contains(o);
	}

	/**
	 * @since 1.6
	 */
	@Override
	public Iterator<Match> iterator() {
		return matches.iterator();
	}

	/**
	 * @since 1.6
	 */
	@Override
	public Object[] toArray() {
		return matches.toArray();
	}

	/**
	 * @since 1.6
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		return matches.toArray(a);
	}

	/**
	 * @since 1.6
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		return matches.containsAll(c);
	}

	/**
	 * @since 1.6
	 */
	@Override
	public boolean addAll(Collection<? extends Match> c) {
		return matches.addAll(c);
	}

	/**
	 * @since 1.6
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		return matches.removeAll(c);
	}

	/**
	 * @since 1.6
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		return matches.retainAll(c);
	}

	/**
	 * @since 1.6
	 */
	@Override
	public void clear() {
		matches.clear();
	}

	/**
	 * @since 1.6
	 */
	@Override
	public Stream<Match> parallelStream() {
		return matches.parallelStream();
	}
}
