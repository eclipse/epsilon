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
package org.eclipse.epsilon.concordance.history;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.concordance.history.ConcordanceHistory;
import org.eclipse.epsilon.concordance.history.ConcordanceHistory.Event;
import org.eclipse.epsilon.concordance.history.ConcordanceHistory.EventType;
import org.eclipse.epsilon.concordance.model.Model;
import org.junit.Before;
import org.junit.Test;

public class ConcordanceHistoryTests {

	private static final Event ADD_EVENT    = new Event(EventType.ADD,    new Model(URI.createFileURI("foo")));
	private static final Event MOVE_EVENT   = new Event(EventType.MOVE, new Model(URI.createFileURI("foo")));
	private static final Event DELETE_EVENT = new Event(EventType.DELETE, new Model(URI.createFileURI("foo")));

	
	private ConcordanceHistory history;
	
	@Before
	public void setup() {
		history = new ConcordanceHistory();
	}
	
	
	// Matches Single
	
	@Test
	public void matchesOnlyLoggedEvent() {
		log(ADD_EVENT);
		
		assertTrue(matchesInAnyOrder(ADD_EVENT));
	}
	
	@Test
	public void matchesLatestLoggedEvent() {
		log(DELETE_EVENT, ADD_EVENT);
		
		assertTrue(matchesInAnyOrder(ADD_EVENT));
	}
	
	@Test
	public void doesNotMatchSecondLatestLoggedEvent() {
		log(DELETE_EVENT, ADD_EVENT);
		
		assertFalse(matchesInAnyOrder(DELETE_EVENT));
	}
	
	@Test
	public void doesNotMatchEventThatWasNeverLogged() {
		log(ADD_EVENT);
		
		assertFalse(matchesInAnyOrder(DELETE_EVENT));
	}
	
	@Test
	public void doesNotMatchWhenNoEventsWereLogged() {
		assertFalse(matchesInAnyOrder(ADD_EVENT));
	}
	
	
	
	// Matches Many
	
	@Test
	public void matchesLoggedEventsInReverseOrder() {
		log(DELETE_EVENT, ADD_EVENT);
		
		assertTrue(matchesInAnyOrder(ADD_EVENT, DELETE_EVENT));
	}
	
	@Test
	public void matchesLoggedEventsInLoggingOrder() {
		log(DELETE_EVENT, ADD_EVENT);
		
		assertTrue(matchesInAnyOrder(DELETE_EVENT, ADD_EVENT));
	}
	
	@Test
	public void matchesLoggedEventsInAnotherOrder() {
		log(DELETE_EVENT, ADD_EVENT, MOVE_EVENT);
		
		assertTrue(matchesInAnyOrder(ADD_EVENT, MOVE_EVENT, DELETE_EVENT));
	}
	
	@Test
	public void doesNotMatchesIfLoggedEventsDoNotIncludeAllMatchees() {
		log(ADD_EVENT, MOVE_EVENT);
		
		assertFalse(matchesInAnyOrder(ADD_EVENT, DELETE_EVENT));
	}
	
	@Test
	public void doesNotMatchForMoreEventsThanLogged() {
		log(DELETE_EVENT);
		
		assertFalse(matchesInAnyOrder(DELETE_EVENT, ADD_EVENT));
	}
	
	
	
	private void log(Event... events) {
		for (Event event : events) {
			history.log(event);
		}
	}
	
	private boolean matchesInAnyOrder(Event... matchees) {
		return history.matchesInAnyOrder(matchees);
	}
}
