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
package org.eclipse.epsilon.concordance.model;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.common.util.FileUtil;
import org.junit.Test;

public class CrossReferenceAnalyserTests {
	
	@Test
	public void shouldProduceCrossReferenceBetweenSourceAndTarget() throws IOException {
		assertEquals(crossReferences(crossReferenceBetween("ReferenceTarget.model", "/", "Target.model", "/")), crossReferencesOf("ReferenceTarget.model"));
	}
	
	@Test
	public void shouldProduceCrossReferencesWithFragments() throws IOException {
		assertEquals(crossReferences(crossReferenceBetween("ReferenceTargetWithManyElements.model", "//@contents.0", "TargetWithManyElements.model", "//@contents.1"),
		                             crossReferenceBetween("ReferenceTargetWithManyElements.model", "//@contents.1", "TargetWithManyElements.model", "//@contents.0")),
		             crossReferencesOf("ReferenceTargetWithManyElements.model"));
	}
	
	@Test
	public void shouldProduceCrossReferenceBetweenSourceAndTargetWhenTargetDoesNotExist() throws IOException {
		assertEquals(crossReferences(crossReferenceBetween("ReferenceDeleted.model", "/", "Deleted.model", "/0")), crossReferencesOf("ReferenceDeleted.model"));
	}

	@Test
	public void shouldNotProduceCrossReferenceForInternalReference() throws IOException {
		assertEquals(crossReferences(), crossReferencesOf("InternalReference.model"));
	}
	

	private Set<CrossReference> crossReferences(CrossReference... crossReferences) {
		return new HashSet<CrossReference>(Arrays.asList(crossReferences));
	}

	private static Set<CrossReference> crossReferencesOf(String model) throws IOException {
		return new CrossReferenceAnalyser(new ConcordanceModel(uriOf(model))).determineCrossReferences();
	}

	private static CrossReference crossReferenceBetween(String sourceModel, String sourceModelElement, String targetModel, String targetModelElement) {
		return new CrossReference(new ModelElement(uriOf(sourceModel, sourceModelElement)),
		                          new ModelElement(uriOf(targetModel, targetModelElement)),
		                          "single");
	}
	
	private static URI uriOf(String model) {
		return URI.createPlatformPluginURI("/org.eclipse.epsilon.concordance.core.test/src" +
		                                   FileUtil.getFile(model, CrossReferenceAnalyserTests.class).getAbsolutePath(),
		                                   true);
	}
	
	private static URI uriOf(String model, String fragment) {
		return uriOf(model).appendFragment(fragment);
	}

}
