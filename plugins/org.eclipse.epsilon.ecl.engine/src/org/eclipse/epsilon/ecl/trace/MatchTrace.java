/*******************************************************************************
 * Copyright (c) 2008-2023 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio Garcia-Dominguez - change to use bidi maps
 ******************************************************************************/
package org.eclipse.epsilon.ecl.trace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.epsilon.ecl.dom.MatchRule;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

/**
 * 
 *
 * @since 1.6 Can be accessed through Collection API rather than getMatches for convenience
 */
public class MatchTrace implements Collection<Match> {
	
	private class MatchIterator implements Iterator<Match> {
		Iterator<Map<Object, Set<Match>>> itMaps = leftToRight.values().iterator();
		Iterator<Set<Match>> itMatches = null;
		Iterator<Match> itMatch = null;

		Match prev = null, next = null;

		@Override
		public boolean hasNext() {
			if (next == null) {
				while (itMatch == null || !itMatch.hasNext()) {
					while (itMatches == null || !itMatches.hasNext()) {
						if (itMaps.hasNext()) {
							itMatches = itMaps.next().values().iterator();
						} else {
							return false;
						}
					}

					if (itMatches.hasNext()) {
						itMatch = itMatches.next().iterator();
					} else {
						return false;
					}
				}

				next = itMatch.next();
			}
			return next != null;
		}
	
		@Override
		public Match next() {
			if (!hasNext()) throw new NoSuchElementException();
			
			prev = next;
			next = null;
			return prev;
		}
	
		@Override
		public void remove() {
			if (prev == null) {
				throw new IllegalStateException();
			}

			// Remove the left-to-right side
			itMatch.remove();

			Map<Object, Set<Match>> leftMap = leftToRight.get(prev.getLeft());
			Set<Match> leftSet = leftMap.get(prev.getRight());
			if (leftSet.isEmpty()) {
				itMatches.remove();
			}
			if (leftMap.isEmpty()) {
				leftToRight.remove(prev.getLeft());
			}

			/*
			 * Remove the right-to-left side (note that both left->right and right->left
			 * mappings use the same Set)
			 */
			Map<Object, Set<Match>> rightMap = rightToLeft.get(prev.getRight());
			if (leftSet.isEmpty()) {
				rightMap.remove(prev.getLeft());
			}
			if (rightMap.isEmpty()) {
				rightToLeft.remove(prev.getRight());
			}

			// Invalidate the cached toString()
			MatchTrace.this.toStringCached = null;

			// Detect the case when remove() is called multiple times
			prev = null;
		}
	}

	/**
	 * Spliterator over the entries of a map of maps of matches.
	 */
	private class MatchSpliterator implements Spliterator<Match> {
		private final Spliterator<Entry<Object, Map<Object, Set<Match>>>> rawSpliterator;
		private Iterator<Set<Match>> currentKeyIterator;
		private Iterator<Match> currentPairIterator;
	
		public MatchSpliterator(Spliterator<Entry<Object, Map<Object, Set<Match>>>> rawSpliterator) {
			this.rawSpliterator = rawSpliterator;
		}
	
		@Override
		public boolean tryAdvance(Consumer<? super Match> action) {
			while (currentPairIterator == null || !currentPairIterator.hasNext()) {
				while (currentKeyIterator == null || !currentKeyIterator.hasNext()) {
					boolean hasIterator = rawSpliterator.tryAdvance((nextEntry) -> {
						currentKeyIterator = nextEntry.getValue().values().iterator();
					});
					if (!hasIterator) {
						// No keys left
						return false;
					}
				}
				currentPairIterator = currentKeyIterator.next().iterator();
			}

			// We're here, so we have a match iterator with at least one entry left
			action.accept(currentPairIterator.next());
			return true;
		}
	
		@Override
		public Spliterator<Match> trySplit() {
			Spliterator<Entry<Object, Map<Object, Set<Match>>>> rawSplit = rawSpliterator.trySplit();
			if (rawSplit != null) {
				return new MatchSpliterator(rawSplit);
			}
			return null;
		}
	
		@Override
		public long estimateSize() {
			return rawSpliterator.estimateSize();
		}
	
		@Override
		public int characteristics() {
			return rawSpliterator.characteristics();
		}
	}

	/**
	 * All matches tried during the execution of an ECL module.
	 * This map contains both left-to-right and right-to-left mappings.
	 */
	protected final Map<Object, Map<Object, Set<Match>>> leftToRight;
	protected final Map<Object, Map<Object, Set<Match>>> rightToLeft;

	protected final boolean concurrent;
	protected String toStringCached;

	public MatchTrace() {
		this(false);
	}
	
	public MatchTrace(boolean concurrent) {
		this.concurrent = concurrent;
		this.leftToRight = createMap();
		this.rightToLeft = createMap();
	}

	public MatchTrace(MatchTrace copy) {
		this.concurrent = Objects.requireNonNull(copy).concurrent;
		this.leftToRight = copyMap(copy.leftToRight);
		this.rightToLeft = copyMap(copy.rightToLeft);
	}

	/**
	 * Returns a trace with only the successful matches.
	 */
	public MatchTrace getReduced() { 
		MatchTrace reduced = new MatchTrace(concurrent);

		for (Map<Object, Set<Match>> valMap : leftToRight.values()) {
			for (Set<Match> matches : valMap.values()) {
				for (Match match : matches) {
					if (match.isMatching()) {
						reduced.add(match);
					}
				}
			}
		}

		return reduced;
	}
	
	public Match add(Object left, Object right, boolean matching, MatchRule rule) {
		Match match = new Match(left, right, matching, rule);
		add(match);
		return match;
	}
	
	/**
	 * Returns the first match with a certain {@code left} and {@code right} object.
	 */
	public Match getMatch(Object left, Object right) {
		Map<Object, Set<Match>> leftMap = leftToRight.get(left);
		if (leftMap != null) {
			Set<Match> matches = leftMap.get(right);
			if (matches != null && !matches.isEmpty()) {
				return matches.iterator().next();
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
		// The object may be on the left or the right side of the matches
		final List<Match> matches = new ArrayList<>();

		for (Map<Object, Set<Match>> sideMap : Arrays.asList(leftToRight.get(object), rightToLeft.get(object))) {
			if (sideMap != null) {
				for (Set<Match> sideMatches : sideMap.values()) {
					matches.addAll(sideMatches);
				}
			}
		}
		return matches;
	}

	/**
	 * Returns the first match for the object
	 * @param object
	 * @return
	 */
	public Match getMatch(Object object) {
		for (Map<Object, Set<Match>> map : Arrays.asList(leftToRight.get(object), rightToLeft.get(object))) {
			if (map != null) {
				for (Set<Match> matches : map.values()) {
					for (Match match : matches) {
						if (match.isMatching()) {
							return match;
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Returns the first match which has a certain object on its left side and relates to a certain rule.
	 */
	public Match getMatch(Object left, MatchRule rule) {
		Map<Object, Set<Match>> map = leftToRight.get(left);
		if (map != null) {
			for (Set<Match> matches : map.values()) {
				for (Match match : matches) {
					if (match.isMatching() && match.getRule() == rule) {
						return match;
					}
				}
			}
		}

		return null;
	}

	public boolean hasBeenMatched(Object object) {
		return leftToRight.containsKey(object) || rightToLeft.containsKey(object);
	}

	public String toString(IEolContext context) {
		StringBuilder sb = new StringBuilder();

		for (Map<Object, Set<Match>> valMap : leftToRight.values()) {
			for (Set<Match> matches : valMap.values()) {
				for (Match match : matches) {
					sb.append("[");
					sb.append(match.isMatching());
					sb.append("]\n");

					sb.append(context.getPrettyPrinterManager().toString(match.getLeft()));
					sb.append("\n ->");
					sb.append(context.getPrettyPrinterManager().toString(match.getRight()));
				}
			}
		}

		sb.append("\n-------------------------------------------");
		return toStringCached = sb.toString();
	}

	/**
	 * Returns all matches, both successful and 
	 * pairs that have been compared but do not match
	 * @return
	 */
	public Collection<Match> getMatches() {
		final List<Match> matches = new ArrayList<>();
		for (Map<Object, Set<Match>> valMap : leftToRight.values()) {
			for (Set<Match> leftMatches : valMap.values()) {
				matches.addAll(leftMatches);
			}
		}
		return matches;
	}

	/**
	 * 
	 * @return
	 * @since 1.6
	 */
	@Override
	public Stream<Match> stream() {
		final Spliterator<Entry<Object, Map<Object, Set<Match>>>> keySpliterator
			= leftToRight.entrySet().spliterator();

		return StreamSupport.stream(new MatchSpliterator(keySpliterator), false);
	}
	
	/**
	 * @since 1.6
	 */
	@Override
	public String toString() {
		return toStringCached != null ? toStringCached : super.toString();
	}
	
	@Override
	public int hashCode() {
		// We cannot use the hashCode of the maps as they are identity-based
		return stream().collect(Collectors.toSet()).hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		// We cannot directly use equals() across maps as they are identity-based
		MatchTrace other = (MatchTrace) obj;
		return stream().collect(Collectors.toSet()).equals(other.stream().collect(Collectors.toSet()));
	}
	
	/**
	 * @since 1.6
	 */
	@Override
	public boolean add(Match match) {
		Set<Match> leftSet = leftToRight
			.computeIfAbsent(match.getLeft(), (k) -> createMap())
			.computeIfAbsent(match.getRight(), (k) -> createSet());

		boolean result = leftSet.add(match);
		if (result) {
			// Change in left-to-right must be propagated
			toStringCached = null;

			// Both left and right sides use the same Set object, to save memory
			rightToLeft
				.computeIfAbsent(match.getRight(), (k) -> createMap())
				.computeIfAbsent(match.getLeft(), (k) -> leftSet);
		}

		return result;
	}
	
	/**
	 * @since 1.6
	 */
	@Override
	public boolean remove(Object o) {
		if (!(o instanceof Match)) {
			return false;
		}
		Match m = (Match) o;
		
		Map<Object, Set<Match>> leftMap = leftToRight.get(m.getLeft());
		if (leftMap == null) {
			return false;
		}
		Set<Match> leftMatches = leftMap.get(m.getRight());
		if (leftMatches == null) {
			return false;
		}

		boolean result = leftMatches.remove(m);
		if (result) {
			if (leftMatches.isEmpty()) {
				leftMap.remove(m.getRight());
			}
			if (leftMap.isEmpty()) {
				leftToRight.remove(m.getLeft());
			}

			toStringCached = null;

			Map<Object, Set<Match>> rightMap = rightToLeft.get(m.getRight());
			Set<Match> rightMatches = rightMap.get(m.getLeft());
			// Note: no need to remove here as left and right sides use same Set
			if (rightMatches.isEmpty()) {
				rightMap.remove(m.getLeft());
			}
			if (rightMap.isEmpty()) {
				rightToLeft.remove(m.getRight());
			}
		}
		return result;
	}

	/**
	 * @since 1.6
	 */
	@Override
	public int size() {
		int total = 0;
		for (Map<Object, Set<Match>> valMap : leftToRight.values()) {
			for (Set<Match> matches : valMap.values()) {
				total += matches.size();
			}
		}
		return total;
	}

	/**
	 * @since 1.6
	 */
	@Override
	public boolean isEmpty() {
		return leftToRight.isEmpty();
	}

	/**
	 * @since 1.6
	 */
	@Override
	public boolean contains(Object o) {
		if (!(o instanceof Match)) {
			return false;
		}

		Match m = (Match) o;
		Map<Object, Set<Match>> leftMap = leftToRight.get(m.getLeft());
		if (leftMap != null) {
			Set<Match> leftMatches = leftMap.get(m.getRight());
			if (leftMatches != null) {
				return leftMatches.contains(m);
			}
		}
		return false;
	}

	/**
	 * @since 1.6
	 */
	@Override
	public Iterator<Match> iterator() {
		return new MatchIterator();
	}

	/**
	 * @since 1.6
	 */
	@Override
	public Object[] toArray() {
		return getMatches().toArray();
	}

	/**
	 * @since 1.6
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		return getMatches().toArray(a);
	}

	/**
	 * @since 1.6
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object o : c) {
			if (!contains(o)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @since 1.6
	 */
	@Override
	public boolean addAll(Collection<? extends Match> c) {
		boolean ret = false;
		for (Match m : c) {
			ret = add(m) || ret;
		}
		return ret;
	}

	/**
	 * @since 1.6
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		boolean ret = false;
		for (Object o : c) {
			ret = remove(o) || ret;
		}
		return ret;
	}

	/**
	 * @since 1.6
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		Set<Match> matchesToRetain = new HashSet<>();
		for (Object o : c) {
			if (o instanceof Match) {
				matchesToRetain.add((Match) o);
			}
		}

		boolean changed = false;
		Iterator<Match> itMatches = iterator();
		while (itMatches.hasNext()) {
			Match m = itMatches.next();
			if (!matchesToRetain.contains(m)) {
				itMatches.remove();
				changed = true;
			}
		}

		return changed;
	}

	/**
	 * @since 1.6
	 */
	@Override
	public void clear() {
		leftToRight.clear();
		rightToLeft.clear();
	}

	/**
	 * @since 1.6
	 */
	@Override
	public Stream<Match> parallelStream() {
		final Spliterator<Entry<Object, Map<Object, Set<Match>>>> keySpliterator
			= leftToRight.entrySet().spliterator();

		return StreamSupport.stream(new MatchSpliterator(keySpliterator), true);
	}

	private <K, V> Map<K, V> createMap() {
		Map<K, V> rawMap = new IdentityHashMap<>();
		if (this.concurrent) {
			return Collections.synchronizedMap(rawMap);
		}
		return rawMap;
	}

	private <E> Set<E> createSet() {
		Set<E> rawSet = new LinkedHashSet<>();
		if (this.concurrent) {
			return Collections.synchronizedSet(rawSet);
		}
		return rawSet;
	}

	private <K, V> Map<K, Map<K, V>> copyMap(Map<K, Map<K, V>> original) {
		Map<K, Map<K, V>> copy = createMap();
		for (Entry<K, Map<K, V>> otherEntry : original.entrySet()) {
			Map<K, V> identitySubmap = createMap();
			identitySubmap.putAll(otherEntry.getValue());
			copy.put(otherEntry.getKey(), identitySubmap);
		}
		return copy;
	}
}
