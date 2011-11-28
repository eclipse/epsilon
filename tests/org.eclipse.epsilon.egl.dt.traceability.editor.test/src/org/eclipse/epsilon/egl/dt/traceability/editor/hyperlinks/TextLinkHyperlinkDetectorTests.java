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

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.epsilon.egl.dt.traceability.editor.TextLinkModel;
import org.eclipse.epsilon.egl.dt.traceability.editor.hyperlinks.TextLinkHyperlinkDetector.HyperlinkSpec;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.TextlinkFactory;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.TraceLink;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.jface.text.Region;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TextLinkHyperlinkDetectorTests.FilteringTests.class, TextLinkHyperlinkDetectorTests.SpecCreationTests.class})
public class TextLinkHyperlinkDetectorTests {

	public static class FilteringTests {
		private final DocumentLocation hoverLocation = mock(DocumentLocation.class);
		private final TextLinkModel model = mock(TextLinkModel.class);
		private final TraceLink traceLink = createTraceLink();
		private final TextLinkHyperlinkDetector hyperlinkDetector = spy(new TextLinkHyperlinkDetector());

	
		@Before
		public void setup() {
			when(model.getTraceLinks()).thenReturn(Collections.singleton(traceLink));
			when(hyperlinkDetector.isActive(traceLink)).thenReturn(true);
		}
		
		@Test
		public void filterIncludesTraceLinksWhoseDestinationsContainHoverLocation() throws EolModelElementTypeNotFoundException {
			when(hoverLocation.isIn(traceLink.getDestination().getRegion())).thenReturn(true);
			
			assertThat(filter(), containsInAnyOrder(traceLink));
		}
	
		@Test
		public void filterExcludesTraceLinksWhoseDestinationsDoNotContainHoverLocation() throws EolModelElementTypeNotFoundException {
			when(hoverLocation.isIn(traceLink.getDestination().getRegion())).thenReturn(false);
			
			assertTrue(filter().isEmpty());
		}
	
		
		private TraceLink createTraceLink() {
			final TraceLink traceLink = TextlinkFactory.eINSTANCE.createTraceLink();
			traceLink.setDestination(TextlinkFactory.eINSTANCE.createTextLocation());
			traceLink.getDestination().setRegion(TextlinkFactory.eINSTANCE.createRegion());
			return traceLink;
		}
		
		private Collection<TraceLink> filter() throws EolModelElementTypeNotFoundException {
			return hyperlinkDetector.matchingTraceLinksFor(hoverLocation, model);
		}
	}

	public static class SpecCreationTests {
		
		@Test
		public void simple() {
			final TraceLink traceLink = createTraceLink(2, 4);
			final Collection<TraceLink> traceLinks = Collections.singleton(traceLink);
			
			Collection<HyperlinkSpec> result = new TextLinkHyperlinkDetector().createHyperlinkSpecsFor(traceLinks);
			
			assertEquals(new Region(2, 4), result.iterator().next().region);
			assertEquals(traceLink.getSource(), result.iterator().next().source);
		}
		
		private TraceLink createTraceLink(int offset, int length) {
			final TraceLink traceLink = TextlinkFactory.eINSTANCE.createTraceLink();
			traceLink.setSource(TextlinkFactory.eINSTANCE.createEmfModelLocation());
			traceLink.setDestination(TextlinkFactory.eINSTANCE.createTextLocation());
			traceLink.getDestination().setRegion(createRegion(offset, length));
			return traceLink;
		}

		private org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.Region createRegion(int offset, int length) {
			org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.Region region = TextlinkFactory.eINSTANCE.createRegion();
			region.setOffset(offset);
			region.setLength(length);
			return region;
		}
	}
}
