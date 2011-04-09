/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
******************************************************************************/

package org.eclipse.epsilon.common.dt.editor;

import org.eclipse.epsilon.common.dt.editor.contentassist.AbstractModuleEditorCompletionProcessor;
import org.eclipse.epsilon.common.dt.editor.hyperlinks.AbstractModuleEditorHyperlinkDetector;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlinkPresenter;
import org.eclipse.jface.text.hyperlink.MultipleHyperlinkPresenter;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.DefaultAnnotationHover;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.graphics.RGB;

public class AbstractModuleEditorSourceViewerConfiguration extends SourceViewerConfiguration {
	
	protected AbstractModuleEditor editor = null;
	
	protected AbstractModuleEditorScanner scanner;
	protected AbstractModuleEditorCommentScanner commentScanner;
	
	public AbstractModuleEditorSourceViewerConfiguration(AbstractModuleEditor editor) {
		this.editor = editor;
		scanner = new AbstractModuleEditorScanner(editor);
		commentScanner = new AbstractModuleEditorCommentScanner();
	}
	
	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		final PresentationReconciler reconciler = new PresentationReconciler();
		
		final DefaultDamagerRepairer dr = new DefaultDamagerRepairer(scanner);
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);
		
		final DefaultDamagerRepairer commentDR = new DefaultDamagerRepairer(commentScanner);
		reconciler.setDamager(commentDR, AbstractModuleEditorPartitionScanner.COMMENT);
		reconciler.setRepairer(commentDR, AbstractModuleEditorPartitionScanner.COMMENT);

		return reconciler;
	}
	
	@Override
	public ITextDoubleClickStrategy getDoubleClickStrategy(
			ISourceViewer sourceViewer, String contentType) {
		ITextDoubleClickStrategy clickStrat = new ITextDoubleClickStrategy() {
			public void doubleClicked(ITextViewer viewer) {
				try {
					IDocument doc = viewer.getDocument();
					int caretOffset = viewer.getSelectedRange().x;

					int start = caretOffset;
					int end = caretOffset;
					boolean isIdentifierPart = Character
							.isJavaIdentifierPart(doc.getChar(start));
					// boolean isWhitespace =
					// Character.isWhitespace(doc.getChar(start));

					if (isIdentifierPart) {
						while (Character.isJavaIdentifierPart(doc
								.getChar(start))) {
							start--;
						}

						while (Character.isJavaIdentifierPart(doc
								.getChar(end))) {
							end++;
						}
					}
					/*
					 * else if (isWhitespace){ while
					 * (Character.isWhitespace(doc.getChar(start))){
					 * start--; }
					 * 
					 * while (Character.isWhitespace(doc.getChar(end))){
					 * end++; } }
					 */
					viewer.setSelectedRange(start + 1, end - start - 1);

				} catch (BadLocationException e) {
					// DebugUIPlugin.log(e);
				}
			}
		};
		return clickStrat;
	}
	
	@Override
	public IAnnotationHover getAnnotationHover(ISourceViewer sourceViewer) {
		return new DefaultAnnotationHover();
	}
	
	AbstractModuleEditorHyperlinkDetector hyperlinkDetector = null;
	
	@Override
	public IHyperlinkPresenter getHyperlinkPresenter(ISourceViewer sourceViewer) {
		return new MultipleHyperlinkPresenter(new RGB(0, 0, 255));
	}
	
	@Override
	public IHyperlinkDetector[] getHyperlinkDetectors(ISourceViewer sourceViewer) {
		
		if (!editor.supportsHyperlinks()) return null;
		
		if (hyperlinkDetector == null) {
			hyperlinkDetector = new AbstractModuleEditorHyperlinkDetector();
			editor.addModuleParsedListener(hyperlinkDetector);
		}
		return new IHyperlinkDetector[] { hyperlinkDetector };
	}
	
	public IContentAssistant getContentAssistant (ISourceViewer sourceViewer) {
		ContentAssistant assistance = new ContentAssistant();
		assistance.setContentAssistProcessor(new AbstractModuleEditorCompletionProcessor(editor),
				IDocument.DEFAULT_CONTENT_TYPE);
		
		assistance.enableAutoActivation (true);
		assistance.setAutoActivationDelay(500);
		assistance.setProposalPopupOrientation (
				IContentAssistant.PROPOSAL_OVERLAY);
		return assistance;
	}
	
	
}
