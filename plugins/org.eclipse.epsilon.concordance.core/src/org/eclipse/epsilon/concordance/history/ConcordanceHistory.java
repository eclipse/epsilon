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
package org.eclipse.epsilon.concordance.history;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.epsilon.concordance.model.IConcordanceModel;

public class ConcordanceHistory {
	
	private final LinkedList<Event> events = new LinkedList<>();
		
	public void log(Event event) {
		events.addFirst(event);
	}
	
	public boolean matchesInAnyOrder(Event... matchees) {
		return matchesInAnyOrder(Arrays.asList(matchees));
	}
	
	public boolean matchesInAnyOrder(Collection<Event> matchees) {
		final Collection<Event> recentEvents = recent(matchees.size());
		
		for (Event matchee : matchees) {
			if (!recentEvents.contains(matchee)) {
				return false;
			}
		}
		
		return true;
	}

	private List<Event> recent(int numberOfEvents) {
		List<Event> sublist = events.size() < numberOfEvents ? 
	                          events :
	                          events.subList(0, numberOfEvents);
		
		return new LinkedList<>(sublist);
	}
	
	
	public static class Event {
		public final EventType type;
		public final IConcordanceModel model;
		
		public Event(EventType type, IConcordanceModel model) {
			this.type  = type;
			this.model = model;
		}
		
		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Event))
				return false;
			
			final Event other = (Event)o;
			
			return this.type.equals(other.type) &&
			       this.model.equals(other.model);
		}
	}
	
	public enum EventType {
		DELETE, ADD, MOVE, CHANGE;
	}
}
