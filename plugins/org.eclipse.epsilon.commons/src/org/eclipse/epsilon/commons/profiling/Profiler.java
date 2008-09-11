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
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Profiler {
	
	protected Collection<IProfilerListener> listeners = new ArrayList<IProfilerListener>();
	public static Profiler INSTANCE = new Profiler();
	protected ProfilerTarget root;
	protected ProfilerTarget activeTarget;
	protected Stopwatch stopwatch;
	protected Map<String, Long> targets;
	protected List<String> targetNames;
	
	private Profiler() {
		stopwatch = new Stopwatch();
		root = new ProfilerTarget("", stopwatch, "", null);
		reset();
	}
	
	public ProfilerTarget start(String targetName) {
		return start(targetName, "", null);
	}
	
	public ProfilerTarget start(String targetName, String data, FileMarker fileMarker) {
		stopwatch.pause();
		activeTarget.pause();
		ProfilerTarget target = new ProfilerTarget(targetName, stopwatch, data, fileMarker);
		activeTarget.addChild(target);
		activeTarget = target;
		if (targets.containsKey(targetName)) {
			targets.put(targetName, targets.get(targetName) + 1);
		}
		else {
			targets.put(targetName, 1l);
		}
		if (!targetNames.contains(targetName)) {
			targetNames.add(targetName);
		}
		/*
		if (!allTargets.containsKey(target)) {
			allTargets.put(target, 0l);
			ArrayList<Long> history = new ArrayList<Long>();
			history.add(0l);
			targetHistory.put(target, history);
		}
		runningTargets.add(0, new ProfilerTarget(target, stopwatch.getElapsed()));
		
		for (IProfilerListener listener : listeners) {
			listener.targetStarted(target);
		}
		*/
		activeTarget.resume();
		stopwatch.resume();
		return target;
	}
	
	public void stop() {
		stop(null);
	}
	
	public void stop(String target) {
		stopwatch.pause();
		activeTarget.stop();
		
		if (target != null && target.compareTo(activeTarget.getName()) != 0) {
			throw new IllegalStateException(
					"Attempted to stop profiling target " 
					+ target + 
					" while the active one is " 
					+ activeTarget.getName());
		}
		
		
		//activeTarget.setEndTime(stopwatch.getElapsed());
		activeTarget = activeTarget.getParent();
		
		/*
		if (runningTargets.size() == 0) return;
		
		ProfilerTarget profilerTarget = runningTargets.remove(0);
		
		if (!profilerTarget.getName().equalsIgnoreCase(target)) throw new IllegalStateException("Illegal State");
		
		long startTime = profilerTarget.getStartTime();
		long worked = stopwatch.getElapsed() - startTime;
		long previouslyWorked = allTargets.get(target);
		allTargets.put(target, previouslyWorked + worked);
		
		targetHistory.get(target).add(worked);
		*/
		
		for (IProfilerListener listener : listeners) {
			listener.targetStopped(target);
		}
		activeTarget.resume();
		stopwatch.resume();
	}
	
	public List<String> getTargetNames() {
		//return targets.keySet();
		return targetNames;
	}
	
	public long getTotalTime(String targetName, boolean aggregate) {
		return getWorked(root, targetName, aggregate);
	}
	
	public long getExecutionCount(String targetName) {
		return targets.get(targetName);
	}
	
	protected long getWorked(ProfilerTarget target, String targetName, boolean aggregate) {
		if (target.getName().compareTo(targetName) == 0) {
			return target.getWorked(aggregate);
		}
		else {
			long sum = 0l;
			Collection<ProfilerTarget> children = new ArrayList<ProfilerTarget>();
			children.addAll(target.getChildren());
			for (ProfilerTarget child : children) {
				sum += getWorked(child, targetName, aggregate);
			}
			return sum;
		}
	}
	
	public boolean isRunning(String targetName) {
		ProfilerTarget target = activeTarget;
		while (target.getParent() != null) {
			if (target.getName().compareTo(targetName) == 0) {
				return true;
			}
			else {
				target=target.getParent();
			}
		}
		return false;
	}
	
	public void reset() {
		root.getChildren().clear();
		activeTarget = root;
		targets = new HashMap<String, Long>();
		targetNames = new ArrayList<String>();
	}
	
	public void addListener(IProfilerListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}
	
	public void removeListener(IProfilerListener listener) {
		if (listeners.contains(listener)) {
			listeners.remove(listener);
		}
	}
	
	public Stopwatch getStopwatch() {
		return stopwatch;
	}
	
	public ProfilerTarget getRoot() {
		return root;
	}
	
	public static void main(String[] args) throws Exception {
		
		Profiler profiler = new Profiler();
		
		ProfilerTarget t1 = profiler.start("t1");
		
		Thread.sleep(500);
		
		profiler.start("t2");
		
		Thread.sleep(600);
		
		profiler.stop();
		
		profiler.stop();
		
		System.err.println(t1.getWorked(true));
		
		System.err.println(t1.getWorked(false));
	}
}
