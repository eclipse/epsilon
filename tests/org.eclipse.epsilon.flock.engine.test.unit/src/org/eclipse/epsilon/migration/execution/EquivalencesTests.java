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
package org.eclipse.epsilon.migration.execution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.expect;
import static org.easymock.classextension.EasyMock.replay;


import org.eclipse.epsilon.migration.emc.wrappers.ModelElement;
import org.junit.Test;

public class EquivalencesTests {

	@Test
	public void getEquivalentShouldReturnEquivalentOfMatchingEquivalence() {
		final Equivalences equivalences = new Equivalences();
		
		final ModelElement original   = createDummyModelElement();
		final ModelElement equivalent = createDummyModelElement();
		
		final Equivalence anEquivalence = createEquivalence();
		final Equivalence matchingEquivalence = createEquivalence(original, equivalent);
		final Equivalence otherEquivalence = createEquivalence();
		
		equivalences.add(anEquivalence);
		equivalences.add(matchingEquivalence);
		equivalences.add(otherEquivalence);
		
		replay(anEquivalence, matchingEquivalence, otherEquivalence);
		
		assertEquals(equivalent, equivalences.getEquivalent(original));
	}
	
	@Test
	public void getEquivalentShouldReturnNullWhenNoEquivalenceMatches() {
		final Equivalences equivalences = new Equivalences();
		
		final Equivalence anEquivalence = createEquivalence();
		final Equivalence otherEquivalence = createEquivalence();
		
		equivalences.add(anEquivalence);
		equivalences.add(otherEquivalence);
		
		replay(anEquivalence, otherEquivalence);
		
		assertNull(equivalences.getEquivalent(createDummyModelElement()));
	}
	
	@Test
	public void getEquivalentShouldReturnNullWhenContainingNoEquivalence() {
		final Equivalences equivalences = new Equivalences();
		
		final ModelElement original   = createDummyModelElement();
		final ModelElement equivalent = createDummyModelElement();
		
		final Equivalence equivalence = createEquivalence(original, equivalent);
		
		replay(equivalence);
		
		assertNull(equivalences.getEquivalent(original));
	}

	private ModelElement createDummyModelElement() {
		return createMock(ModelElement.class);
	}
	
	private Equivalence createEquivalence() {
		return createEquivalence(createDummyModelElement(), createDummyModelElement());
	}
	
	private Equivalence createEquivalence(ModelElement original, ModelElement equivalent) {
		final Equivalence eq = createMock(RuleBasedEquivalence.class);
		expect(eq.getOriginal()).andReturn(original).anyTimes();
		expect(eq.getEquivalent()).andReturn(equivalent).anyTimes();
		return eq;
	}	
}
