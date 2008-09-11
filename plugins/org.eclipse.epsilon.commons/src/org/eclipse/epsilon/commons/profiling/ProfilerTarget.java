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

import java.util.ArrayList;
import java.util.List;


public class ProfilerTarget {
	
	protected String name;
	protected long startTime;
	protected long globalEndTime;
	protected long internalEndTime;
	protected long aggregatedWorked;
	protected long internalWorked;
	protected List<ProfilerTarget> children;
	protected ProfilerTarget parent;
	protected String data;
	protected FileMarker fileMarker;
	protected Stopwatch globalStopwatch;
	protected Stopwatch internalStopwatch;
	
	public ProfilerTarget(String name, Stopwatch globalStopwatch, String data, FileMarker fileMarker) {
		this.name = name;
		this.globalStopwatch = globalStopwatch;
		this.internalStopwatch = new Stopwatch();
		internalStopwatch.resume();
		this.startTime = globalStopwatch.getElapsed();
		this.globalEndTime = -1l;
		this.internalEndTime = -1l;
		children = new ArrayList<ProfilerTarget>();
		this.data = data;
		this.fileMarker = fileMarker;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void pause() {
		internalStopwatch.pause();
	}
	
	public void resume() {
		internalStopwatch.resume();
	}
	
	public void stop() {
		internalStopwatch.pause();
		this.globalEndTime = globalStopwatch.getElapsed();
		this.internalEndTime = internalStopwatch.getElapsed();
		this.aggregatedWorked = globalEndTime - startTime;
		this.internalWorked = internalStopwatch.getElapsed();
	}
	
	public void addChild(ProfilerTarget child) {
		children.add(child);
		child.parent = this;
	}
	
	public List<ProfilerTarget> getChildren() {
		return children;
	}

	public ProfilerTarget getParent() {
		return parent;
	}
	
	public boolean isRunning() {
		return globalEndTime == -1l;
	}
	
	public long getWorked(boolean aggregate) {
		if (!aggregate) {
			if (isRunning()) return internalStopwatch.getElapsed();
			else return internalWorked;
		}
		else {
			if (isRunning()) return globalStopwatch.getElapsed() - startTime;
			else return aggregatedWorked;
		}
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public FileMarker getFileMarker() {
		return fileMarker;
	}

	public void setFileMarker(FileMarker fileMarker) {
		this.fileMarker = fileMarker;
	}
}
