/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.profiling;

public class Stopwatch {
	
	protected long lastPauseTime, startTime, pauseDuration;
	protected boolean paused;
	
	public Stopwatch() {
		startTime = System.currentTimeMillis();
		paused = false;
		pause();
	}
	
	public synchronized void pause() {
		if (!paused) {
			lastPauseTime = System.currentTimeMillis();
			paused = true;
		}
		//else {
		//	throw new IllegalStateException("The stopwatch is already paused");
		//}
	}
	
	public synchronized void resume() {
		if (paused) {
			pauseDuration += System.currentTimeMillis() - lastPauseTime;
			paused = false;
		}
		//else {
		//	throw new IllegalStateException("The stopwatch is not paused");
		//}
	}
	
	public long getElapsed() {
		if (paused) {
			return lastPauseTime - pauseDuration - startTime;
		}
		else {
			return System.currentTimeMillis() - pauseDuration - startTime;
		}
	}
}
