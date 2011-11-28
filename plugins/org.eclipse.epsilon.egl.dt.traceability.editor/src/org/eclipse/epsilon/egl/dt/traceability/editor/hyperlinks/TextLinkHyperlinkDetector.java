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
package org.eclipse.epsilon.egl.dt.traceability.editor.hyperlinks;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.egl.dt.traceability.editor.TextLinkEditor;
import org.eclipse.epsilon.egl.dt.traceability.editor.TextLinkModel;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.EmfModelLocation;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.ModelLocation;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.Region;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.TraceLink;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.AbstractHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

public class TextLinkHyperlinkDetector extends AbstractHyperlinkDetector {

	private TextLinkEditor editor;
	
	@Override
	public IHyperlink[] detectHyperlinks(ITextViewer textViewer, IRegion region, boolean canShowMultipleHyperlinks) {	
		if (textViewer.getDocument() == null)
			return null;
		
		if (!(getActiveEditor() instanceof TextLinkEditor))
			return null;
		
		editor = (TextLinkEditor)getActiveEditor();
		
		final Collection<TraceLink> matchingTraceLinks = matchingTraceLinksFor(new DocumentLocation(region.getOffset()), editor.getTextlinkModel());
		final Collection<HyperlinkSpec> hyperlinkSpecs = createHyperlinkSpecsFor(matchingTraceLinks);
		
		return createHyperlinks(hyperlinkSpecs);
	}

	private static IEditorPart getActiveEditor() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
	}

	Collection<TraceLink> matchingTraceLinksFor(DocumentLocation hoverLocation, TextLinkModel model) {
		final List<TraceLink> matching = new LinkedList<TraceLink>();
		
		for (TraceLink candidate : model.getTraceLinks()) {
			final Region region = candidate.getDestination().getRegion();
		
			if (editor.isActiveDestination(candidate.getDestination()) && hoverLocation.isIn(region)) {				
				matching.add(candidate);
			}
		}
		
		return matching;
	}
	
	Set<HyperlinkSpec> createHyperlinkSpecsFor(Collection<TraceLink> traceLinks) {
		final Set<HyperlinkSpec> hyperlinkSpecs = new HashSet<HyperlinkSpec>();
		
		for (TraceLink traceLink : traceLinks) {
			final Region textlinkRegion = traceLink.getDestination().getRegion();
			final IRegion jfaceRegion = new org.eclipse.jface.text.Region(textlinkRegion.getOffset(), textlinkRegion.getLength());
			
			hyperlinkSpecs.add(new HyperlinkSpec(jfaceRegion, traceLink.getSource()));
		}
		
		return hyperlinkSpecs;
	}
	
	private IHyperlink[] createHyperlinks(Collection<HyperlinkSpec> hyperlinkSpecs) {
		final List<IHyperlink> hyperlinks = new LinkedList<IHyperlink>();
		
		for (HyperlinkSpec hyperlinkSpec : hyperlinkSpecs) {
			hyperlinks.add(new TextlinkHyperlink(hyperlinkSpec));
		}
		
		return hyperlinks.toArray(new IHyperlink[]{});
	}
	
	class HyperlinkSpec {
		public final IRegion region;
		public final ModelLocation source;
		
		public HyperlinkSpec(IRegion region, ModelLocation source) {
			this.region = region;
			this.source = source;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof HyperlinkSpec))
				return false;
			
			final HyperlinkSpec other = (HyperlinkSpec)obj;
			
			return regionEquals(other) && modelLocationEquals(other);
		}

		private boolean regionEquals(HyperlinkSpec other) {
			return this.region.getOffset() == other.region.getOffset() &&
			       this.region.getLength() == other.region.getLength();
		}
		
		private boolean modelLocationEquals(HyperlinkSpec other) {
			return getModelElement().equals(other.getModelElement());
		}
		
		@Override
		public int hashCode() {
			return region.getOffset() + region.getLength() + getModelElement().hashCode();
		}
		
		private EObject getModelElement() {
			return ((EmfModelLocation)this.source).getModelElement();
		}
	}
	
	private class TextlinkHyperlink implements IHyperlink {

		private final HyperlinkSpec spec;
		
		public TextlinkHyperlink(HyperlinkSpec spec) {
			this.spec = spec;
		}
		
		@Override
		public IRegion getHyperlinkRegion() {
			return spec.region;
		}

		@Override
		public String getTypeLabel() {
			return null;
		}

		@Override
		public String getHyperlinkText() {
			return "Open '" + getLabelForSource() + "' in model editor";
		}

		private String getLabelForSource() {
			if (spec.source instanceof EmfModelLocation) {
				final EObject modelElement = ((EmfModelLocation)spec.source).getModelElement();
				
				final EStructuralFeature nameFeature = modelElement.eClass().getEStructuralFeature("name");
				
				if (nameFeature != null) {
					final String name = modelElement.eGet(nameFeature).toString();
					
					if (name != null && !name.isEmpty()) {
						return name;
					} else {
						return modelElement.eClass().getName();
					}
				}				
			}
			
			return "Unknown";
		}

		@Override
		public void open() {
			editor.selectAndReveal(spec.source);
		}
	}
}
