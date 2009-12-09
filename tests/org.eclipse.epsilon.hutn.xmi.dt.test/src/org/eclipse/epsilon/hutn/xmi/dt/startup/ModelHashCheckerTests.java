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
package org.eclipse.epsilon.hutn.xmi.dt.startup;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.epsilon.hutn.xmi.dt.ModelHashCache;
import org.eclipse.epsilon.hutn.xmi.hashing.Xmi2Hash;
import org.junit.Test;

public class ModelHashCheckerTests {

	@Test
	public void hashChangedWhenCurrentHashIsDifferentToCachedHash() throws URISyntaxException {
		final URI modelUri = new URI("file:///tmp/dummy.txt");
		
		final Xmi2Hash mockHasher          = createMock("mockHasher", Xmi2Hash.class);
		final ModelHashCache mockHashCache = createMock("mockHashCache", ModelHashCache.class);
		
		expect(mockHasher.calculateMetamodelHash()).andReturn(1);
		expect(mockHashCache.noHashFor(modelUri)).andReturn(false);
		expectLastCall().atLeastOnce();
		expect(mockHashCache.getHashFor(modelUri)).andReturn(2);
		expectLastCall().atLeastOnce();
		
		mockHashCache.updateHashFor(modelUri, 1);
		
		replay(mockHasher, mockHashCache);
		
		
		assertTrue(new ModelHashChecker(modelUri, mockHasher, mockHashCache).hasHashChangedFor());
		
		verify(mockHasher, mockHashCache);
	}
	
	@Test
	public void hashNotChangedWhenCurrentHashIsSameAsCachedHash() throws URISyntaxException {
		final URI modelUri = new URI("file:///tmp/dummy.txt");
		
		final Xmi2Hash mockHasher          = createMock("mockHasher", Xmi2Hash.class);
		final ModelHashCache mockHashCache = createMock("mockHashCache", ModelHashCache.class);
		
		expect(mockHasher.calculateMetamodelHash()).andReturn(1);
		expect(mockHashCache.noHashFor(modelUri)).andReturn(false);
		expect(mockHashCache.getHashFor(modelUri)).andReturn(1);
		expectLastCall().atLeastOnce();

				
		replay(mockHasher, mockHashCache);
		
		
		assertFalse(new ModelHashChecker(modelUri, mockHasher, mockHashCache).hasHashChangedFor());
		
		verify(mockHasher, mockHashCache);
	}
	
	@Test
	public void hashChangedWhenNoCachedHash() throws URISyntaxException {
		final URI modelUri = new URI("file:///tmp/dummy.txt");
		
		final Xmi2Hash mockHasher          = createMock("mockHasher", Xmi2Hash.class);
		final ModelHashCache mockHashCache = createMock("mockHashCache", ModelHashCache.class);
		
		expect(mockHasher.calculateMetamodelHash()).andReturn(1);
		expect(mockHashCache.noHashFor(modelUri)).andReturn(true);
		expectLastCall().atLeastOnce();
		expect(mockHashCache.getHashFor(modelUri)).andStubReturn(null);
		
		mockHashCache.updateHashFor(modelUri, 1);
		
		replay(mockHasher, mockHashCache);
		
		
		assertTrue(new ModelHashChecker(modelUri, mockHasher, mockHashCache).hasHashChangedFor());
		
		verify(mockHasher, mockHashCache);
	}
}
