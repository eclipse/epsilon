/*******************************************************************************
 * Copyright (c) 2011 The University of York.
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
package org.eclipse.epsilon.egl.engine.traceability.fine.context;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.eclipse.epsilon.egl.engine.traceability.fine.context.FeatureAccessRecorder;
import org.junit.Test;



public class FeatureAccessRecorderTests {

	private final FeatureAccessRecorder recorder = new FeatureAccessRecorder();
	private final Object dummyModelElement = mock(Object.class);
	
	@Test
	public void shouldRecordFeatureAccess() {
		recorder.startRecording();
		recorder.record(dummyModelElement, "DummyFeatureName");
		
		assertEquals(dummyModelElement,  recorder.getFeatureAccesses().get(0).modelElement);
		assertEquals("DummyFeatureName", recorder.getFeatureAccesses().get(0).featureName);
	}
	
	@Test
	public void shouldNotRecordDuplicateFeatureAccess() {
		recorder.startRecording();
		recorder.record(dummyModelElement, "DummyFeatureName");
		recorder.record(dummyModelElement, "DummyFeatureName");
		
		assertEquals(1, recorder.getFeatureAccesses().size());
	}
	
	@Test
	public void shouldNotRecordUnlessToldToStart() {
		recorder.record(dummyModelElement, "DummyFeatureName");
		
		assertEquals(0, recorder.getFeatureAccesses().size());
	}
	
	@Test
	public void shouldNotRecordAfterToldToStop() {
		recorder.startRecording();
		recorder.stopRecording();
		recorder.record(dummyModelElement, "DummyFeatureName");
		
		assertEquals(0, recorder.getFeatureAccesses().size());
	}
	
	@Test
	public void startingToRecordClearsPreviousFeatureAccesses() {
		recorder.startRecording();
		recorder.record(dummyModelElement, "DummyFeatureName");
		recorder.stopRecording();
		
		recorder.startRecording();
		
		assertEquals(0, recorder.getFeatureAccesses().size());
	}
}
