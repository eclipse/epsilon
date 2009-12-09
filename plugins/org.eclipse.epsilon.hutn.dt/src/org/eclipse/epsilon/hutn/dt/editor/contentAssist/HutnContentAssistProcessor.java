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

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

public class HutnContentAssistProcessor implements IContentAssistProcessor {

	private final ContentAssistHelper helper = new ContentAssistHelper();
	
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		return computeCompletionProposals(getDocumentText(viewer, offset));
	}
	
	private String getDocumentText(ITextViewer viewer, int offset) {
		try {
			return viewer.getDocument().get(0, offset);
		
		} catch (BadLocationException e) {
			throw new IllegalArgumentException("Offset, " + offset + " is past the end of this document, length: " + viewer.getDocument().getLength());
		}
	}
	
	public ICompletionProposal[] computeCompletionProposals(String text) {
		final ProposalsFactory proposalsFactory = new ProposalsFactory(text.length(), helper.lastWord(text));
		
		if (helper.contextIsClass(text)) {
			for (String feature : helper.featureNamesFor(helper.currentClassName(text), text)) {
				proposalsFactory.propose(feature + ": ");
			}
			
		} else {
			for (String classifier : helper.classifierNames(text)) {
				proposalsFactory.propose(classifier);
			}
		}
			
		return proposalsFactory.proposals();
	}

	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		return new IContextInformation[0];
	}

	
	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}
	
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}

	public String getErrorMessage() {
		return null;
	}

}
