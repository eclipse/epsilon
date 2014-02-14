/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.introspection.recording;

import static org.junit.Assert.*;

import org.junit.Test;

public class PropertyAccessRecorderTests {

	@Test
	public void recordingIsInitiallyOff() throws Exception {
		final PropertyAccessRecorder recorder = new PropertyAccessRecorder();
		recorder.record("DummyModelElement", "foo");
		
		assertTrue(recorder.getPropertyAccesses().isEmpty());
	}
	
	@Test
	public void recordingWorksAfterStarted() throws Exception {
		final PropertyAccessRecorder recorder = new PropertyAccessRecorder();
		
		recorder.startRecording();
		recorder.record("DummyModelElement", "foo");
		recorder.stopRecording();
		
		final PropertyAccesses expectedPropertyAccesses = new PropertyAccesses(
			new PropertyAccess("DummyModelElement", "foo")
		);
		
		assertEquals(expectedPropertyAccesses, recorder.getPropertyAccesses());
	}
	
	@Test
	public void recordingNoLongerWorksAfterStopping() throws Exception {
		final PropertyAccessRecorder recorder = new PropertyAccessRecorder();
		
		recorder.startRecording();
		recorder.record("DummyModelElement", "foo");
		recorder.stopRecording();
		recorder.record("DummyModelElement", "bar");
		
		final PropertyAccesses expectedPropertyAccesses = new PropertyAccesses(
			new PropertyAccess("DummyModelElement", "foo")
		);
		
		assertEquals(expectedPropertyAccesses, recorder.getPropertyAccesses());
	}
	
	@Test
	public void previousRecordingsAreClearedAfterStarting() throws Exception {
		final PropertyAccessRecorder recorder = new PropertyAccessRecorder();
		
		recorder.startRecording();
		recorder.record("DummyModelElement", "foo");
		recorder.stopRecording();
		
		recorder.startRecording();
		
		assertTrue(recorder.getPropertyAccesses().isEmpty());
	}
}
