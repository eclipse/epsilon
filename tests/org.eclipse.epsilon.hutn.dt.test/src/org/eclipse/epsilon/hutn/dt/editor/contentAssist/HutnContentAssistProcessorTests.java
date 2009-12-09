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

import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.hutn.test.model.HutnTestWithFamiliesMetaModel;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.junit.Test;

@SuppressWarnings("unchecked")
public class HutnContentAssistProcessorTests extends HutnTestWithFamiliesMetaModel {

	@Test
	public void shouldSuggestConcreteClassNamesWhenAtPackageLevel() throws EolModelLoadingException {
		final String text = "@Spec {"                    +
		                    "	Metamodel {"             +
		                    "		nsUri: \"families\"" + 
		                    "	}"                       +
		                    "}"                          +
		                    "families { ";
				
		assertThat(new HutnContentAssistProcessor().computeCompletionProposals(text),
		           is(arrayContaining(completionProposal("Bike"),
		                              completionProposal("District"),
		                              completionProposal("Dog"),
		                              completionProposal("Family"),
		                              completionProposal("Model"),
		                              completionProposal("Person"),
		                              completionProposal("Pet")
		                              )));
	}
	
	
	@Test
	public void shouldSuggestSlotNamesWhenAtClassLevel() throws EolModelLoadingException {
		final String text = "@Spec {"                    +
		                    "	Metamodel {"             +
		                    "		nsUri: \"families\"" + 
		                    "	}"                       +
		                    "}"                          +
		                    "families { " +
		                    "  Person { ";
		
		assertThat(new HutnContentAssistProcessor().computeCompletionProposals(text),
		           is(arrayContaining(completionProposal("accounts: "),
		                              completionProposal("friends: "),
		                              completionProposal("name: "),
		                              completionProposal("sharedAccounts: ")
		                              )));
	}
	
	
	// For debugging
	protected static void print(ICompletionProposal[] proposals) {
		for (ICompletionProposal proposal : proposals) {
			System.err.println(proposal.getDisplayString());
		}
	}
}
