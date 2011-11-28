/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.dt.traceability.editor;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.EmfModelLocation;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.ModelLocation;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.TextLocation;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.MultiEditor;
import org.eclipse.ui.texteditor.ITextEditor;

public class TextLinkEditor extends MultiEditor {
		
	private TabbedEditor<EcoreEditor> sources;
	private TabbedEditor<ITextEditor> destinations;
	private TextLinkInnerEditors innerEditors;
	
	@Override
	protected void drawGradient(IEditorPart innerEditor, Gradient g) {}
	
	public TextLinkModel getTextlinkModel() {
		return ((TextLinkEditorInput)getEditorInput()).textlinkModel;
	}
	
	@Override
	public void createPartControl(Composite parent) {
		final SashForm form = new SashForm(parent, SWT.HORIZONTAL);
		form.setLayout(new FillLayout());
		
		innerEditors = new TextLinkInnerEditors(getInnerEditors());
		sources = new TabbedEditor<EcoreEditor>(form, innerEditors.getAllModelEditors());
		destinations = new TabbedEditor<ITextEditor>(form, innerEditors.getAllTextEditors());
		
		sources.addMouseListenerToEditors(new MouseAdapter() {
			@Override public void mouseDoubleClick(MouseEvent e) {
				selectAndRevealDestination();
			}
		});
		
		setPartName(getTextlinkModel().getFileName());
	}

	public boolean isActiveDestination(TextLocation destination) {
		final TextLinkInnerEditorInput<?> activeDestinationEditorInput = (TextLinkInnerEditorInput<?>) destinations.getActiveEditor().getEditorInput();
		return activeDestinationEditorInput.contains(destination);
	}

	public void selectAndReveal(ModelLocation source) {
		if (source instanceof EmfModelLocation) {
			final EcoreEditor sourceEditor = (EcoreEditor)innerEditors.getEditorThatContains(source);
			
			final EObject selection = sourceEditor.getEditingDomain().getResourceSet().getEObject(modelElementToUri(((EmfModelLocation) source).getModelElement()), true);
			
//			((ISelectionProvider)innerEditor).setSelection(new StructuredSelection(selection));
			((EcoreEditor)sourceEditor).setSelectionToViewer(Arrays.asList(selection));
			
			sources.switchTo(sourceEditor);
		}
	}
	
	private URI modelElementToUri(EObject me) {
		URI uri = EcoreUtil.getURI(me);

		try {
			java.net.URI location = new java.net.URI(uri.trimFragment().toString());
			final IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(location);
			
			if (files.length > 0) {
				uri = URI.createPlatformResourceURI(files[0].getFullPath().toString(), true).appendFragment(uri.fragment());
			}
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		return uri;
	}
	
	private void selectAndRevealDestination() {
		final TextLocation firstDestination = getTextlinkModel().getFirstDestinationFor(getFirstSelectedModelElement());
			
		if (firstDestination != null) {
			selectAndReveal(firstDestination);
		}
	}
	
	private EObject getFirstSelectedModelElement() {
		final EcoreEditor activeModelEditor = sources.getActiveEditor();
		final ITreeSelection selection = (ITreeSelection)activeModelEditor.getSelection();
		
		return (EObject)selection.getFirstElement();
	}
	
	private void selectAndReveal(TextLocation destination) {
		final ITextEditor destinationEditor = (ITextEditor)innerEditors.getEditorThatContains(destination);
		destinationEditor.selectAndReveal(destination.getRegion().getOffset(), destination.getRegion().getLength());
		destinations.switchTo(destinationEditor);
	}
	
	private static class TextLinkInnerEditors {
		
		private final IEditorPart[] editors;
		
		public TextLinkInnerEditors(IEditorPart[] editorParts) {
			this.editors = editorParts;
		}
		
		public Collection<EcoreEditor> getAllModelEditors() {
			return getEditors(true);
		}
		
		public Collection<ITextEditor> getAllTextEditors() {
			return getEditors(false);
		}

		@SuppressWarnings("unchecked")
		private <T> Collection<T> getEditors(boolean isSource) {
			final List<T> innerTextEditors = new LinkedList<T>();
			
			for (IEditorPart editor : editors) {
				if (((TextLinkInnerEditorInput<?>)editor.getEditorInput()).isSource() == isSource) {
					innerTextEditors.add((T)editor);
				}
			}
			
			return innerTextEditors;
		}
		
		public IEditorPart getEditorThatContains(Object o) {
			for (IEditorPart editor : editors) {
				
				if (((TextLinkInnerEditorInput<?>)editor.getEditorInput()).contains(o)) {
					return editor;
				}
			}
			
			return null;
		}
	}
}
