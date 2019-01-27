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
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
import org.eclipse.epsilon.ecl.dom.MatchRule;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class MatchTrace {
	
	/**
	 * All matches tried during the  execution of an ECL module
	 */
	protected final Collection<Match> matches;
	
	protected String toStringCached;
	
	public MatchTrace() {
		this(false);
	}
	
	public MatchTrace(boolean concurrent) {
		matches = concurrent ? ConcurrencyUtils.concurrentSet() : new ArrayList<>();
	}
	
	public MatchTrace(MatchTrace copy) {
		this(copy.matches.getClass().getSimpleName().contains("Concurrent"));
		this.getMatches().addAll(copy.getMatches());
	}
	
	/**
	 * Returns only successful matches
	 */
	public MatchTrace getReduced() { 
		MatchTrace reduced = new MatchTrace();
		for (Match match : matches) {
			if (match.isMatching()) {
				reduced.getMatches().add(match);
			}
		}
		return reduced;
	}
	
	public Match add(Object left, Object right, boolean matching, MatchRule rule) {
		Match match = new Match(left, right, matching, rule);
		getMatches().add(match);
		return match;
	}
	
	public Match getMatch(Object left, Object right) {
		for (Match match : this.getMatches()) {
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
		return getMatches()
				.stream()
				.filter(match -> match.isMatching() && match.contains(object))
				.collect(Collectors.toList());
	}
	
	/**
	 * Returns the first match for the object
	 * @param object
	 * @return
	 */
	public Match getMatch(Object object) {
		for (Match match : this.getMatches()) {
			if (match.contains(object) && match.isMatching()) {
				return match;
			}
		}
		return null;
	}
	
	public Match getMatch(Object left, MatchRule rule) {
		for (Match match : this.getMatches()) {
			if (match.isMatching() && match.left == left && match.getRule() == rule) {
				return match;
			}
		}
		return null;
	}
	
	public boolean hasBeenMatched(Object object) {
		for (Match match : this.getMatches()) {
			if (match.contains(object)) {
				return true;
			}
		}
		return false;
	}
	
	public String toString(IEolContext context) {
		String str = "";
		
		for (Match match : this.getMatches()) {
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
		return matches;
	}
	
	/**
	 * 
	 * @return
	 * @since 1.6
	 */
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
}
