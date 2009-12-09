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
package org.eclipse.epsilon.hutn.dt.editor.contentAssist;

import static org.eclipse.epsilon.hutn.dt.editor.contentAssist.CompletionProposalMatcher.completionProposal;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.junit.Assert.assertThat;

import org.junit.Test;


@SuppressWarnings("unchecked")
public class ProposalsFactoryTests {

	@Test
	public void allProposalsAcceptedWhenNoContext() {
		final ProposalsFactory fac = new ProposalsFactory(0, "");
		
		fac.propose("cat");
		fac.propose("dog");
		
		assertThat(fac.proposals(), is(arrayContaining(completionProposal("cat"), completionProposal("dog"))));
	}
	
	@Test
	public void proposalsAreFilteredToFitContext() {
		final ProposalsFactory fac = new ProposalsFactory(1, "d");
		
		fac.propose("cat");
		fac.propose("dog");
		
		assertThat(fac.proposals(), is(arrayContaining(completionProposal("dog"))));

	}
	
	@Test
	public void proposalsAreSortedAlphabetically() {
		final ProposalsFactory fac = new ProposalsFactory(0, "");
		
		fac.propose("dog");
		fac.propose("cat");
		fac.propose("emu");
		
		assertThat(fac.proposals(), is(arrayContaining(completionProposal("cat"), completionProposal("dog"), completionProposal("emu"))));

	}
}
