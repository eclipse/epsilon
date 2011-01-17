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
package org.eclipse.epsilon.flock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.eclipse.epsilon.flock.emc.wrappers.Model;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.junit.Test;

public class FlockExecutionTests {

	final FlockExecution execution = new FlockExecution(mock(MigrationStrategyRunner.class));
	final Model originalModel = mock(Model.class);
	
	@Test
	public void runShouldEnsureExpandIsOff() throws FlockRuntimeException {
		run();
		
		verify(originalModel).ensureExpandIsOff();
	}
	
	@Test
	public void runShouldAddWarningIfExpandWasTurnedOff() throws FlockRuntimeException {
		when(originalModel.ensureExpandIsOff())
			.thenReturn(true);
		
		assertEquals(1, run().getWarnings().size());
	}
	
	@Test
	public void runShouldNotAddWarningIfExpandWasNotTurnedOff() throws FlockRuntimeException {
		when(originalModel.ensureExpandIsOff())
			.thenReturn(false);
		
		assertEquals(0, run().getWarnings().size());
	}
	
	private FlockResult run() throws FlockRuntimeException {
		return execution.run(originalModel);
	}
}
