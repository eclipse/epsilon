/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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

import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.common.util.FileUtil;
import org.junit.Test;

public class ContentAnalyserTests {
	
	@Test
	public void shouldReturnTrueForElementThatExists() throws IOException {
		assertEquals(true, modelContains("TargetWithManyElements.model", "//@contents.0"));
	}
	
	@Test
	public void shouldReturnFalseForElementThatDoesNotExist() throws IOException {
		assertEquals(false, modelContains("TargetWithManyElements.model", "//@contents.2"));
	}
	
	@Test
	public void shouldReturnTrueForTopElement() throws IOException {
		assertEquals(true, modelContains("TargetWithManyElements.model", "/"));
	}
	
	@Test
	public void shouldReturnTrueForEmptyFragment() throws IOException {
		assertEquals(true, modelContains("TargetWithManyElements.model", ""));
	}
	
	@Test
	public void shouldReturnFalseForNonExistentModel() throws IOException {
		assertEquals(false, modelContains("NonExistent.model", "//@contents.0"));
	}
	
	@Test
	public void shouldReturnFalseForNonExistentModelAndEmptyFragment() throws IOException {
		assertEquals(false, modelContains("NonExistent.model", ""));
	}
	

	private boolean modelContains(String model, String modelElementFragment) {
		return new ContentAnalyser(new ConcordanceModel(uriOf(model))).contains(modelElementFragment);
	}

	private static URI uriOf(String model) {
		return URI.createPlatformPluginURI("/org.eclipse.epsilon.concordance.core.test/src" +
		                                   FileUtil.getFile(model, ContentAnalyserTests.class).getAbsolutePath(),
		                                   true);
	}
}
