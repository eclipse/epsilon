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
/**
 * 
 */
package org.eclipse.epsilon.hutn.dt.editor.contentAssist;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

class CompletionProposalMatcher extends TypeSafeMatcher<ICompletionProposal> {

	private final String display;
	
	public CompletionProposalMatcher(String display) {
		this.display = display;
	}

	@Override
	protected boolean matchesSafely(ICompletionProposal proposal) {
		return display == null ? proposal.getDisplayString() == null : display.equals(proposal.getDisplayString());
	}

	public void describeTo(Description description) {
		description.appendText("'" + display + "' proposal");
	}
	
	public static CompletionProposalMatcher completionProposal(String display) {
		return new CompletionProposalMatcher(display);
	}
	
}