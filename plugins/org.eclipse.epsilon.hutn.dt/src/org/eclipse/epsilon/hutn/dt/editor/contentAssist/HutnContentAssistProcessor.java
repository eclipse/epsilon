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

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

public class HutnContentAssistProcessor implements IContentAssistProcessor {

	private final DocumentProcessor documentProcessor = new DocumentProcessor();
	
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		final String lastWord = documentProcessor.lastWord(viewer.getDocument(), offset);
		
		final ProposalsFactory proposalsFactory = new ProposalsFactory(offset, lastWord);
				
		for (String classifier : documentProcessor.classifierNames(viewer.getDocument())) {
			proposalsFactory.propose(classifier);
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
