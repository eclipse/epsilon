/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.commons.profiling;

public class Stopwatch {
	
	protected long lastPauseTime;
	protected long startTime;
	protected long pauseDuration;
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
	
	public static void main(String[] args) throws Exception{
		Stopwatch s = new Stopwatch();
		s.resume();
		Thread.sleep(100);
		//s.pause();
		Thread.sleep(200);
		//s.resume();
		Thread.sleep(400);
		//s.pause();
		System.err.println(s.getElapsed());
	}
	
}
