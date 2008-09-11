/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.merge.output;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Output {

	private final List<Region> regions                      = new LinkedList<Region>();
	private final List<String> protectedRegionIds           = new LinkedList<String>();
	private final List<String> duplicatedProtectedRegionIds = new LinkedList<String>();
	
	public Output(Region... regions) {
		this.regions.addAll(Arrays.asList(regions));	
		processIds();
	}
	
	public Output(List<Region> regions) {
		this.regions.addAll(regions);
		processIds();
	}
	
	private void processIds() {
		for (Region r : regions) {
			if (r instanceof ProtectedRegion) {
				final ProtectedRegion pr = (ProtectedRegion)r;
				
				if (protectedRegionIds.contains(pr.getId())) {
					duplicatedProtectedRegionIds.add(pr.getId());
				} else {
					protectedRegionIds.add(pr.getId());
				}
			}
		}
	}
	
	public List<Region> getRegions() {
		return Collections.unmodifiableList(regions);
	}
	
	public List<ProtectedRegion> getProtectedRegions() {
		List<ProtectedRegion> protectedRegions = new LinkedList<ProtectedRegion>();
		
		for (Region region : regions) {
			if (region instanceof ProtectedRegion)
				protectedRegions.add((ProtectedRegion)region);
		}
		
		return Collections.unmodifiableList(protectedRegions);
	}
	
	public ProtectedRegion getProtectedRegion(String id) {
		for (Region region : regions) {
			if (region instanceof ProtectedRegion) {
				ProtectedRegion protectedRegion = (ProtectedRegion)region;
				if (protectedRegion.getId().equals(id)) {
					return protectedRegion;
				}
			}
		}
		
		return null;
	}
	
	public List<String> getProblems() {
		final List<String> problems = new LinkedList<String>();
		
		for (String id : duplicatedProtectedRegionIds) {
			problems.add("Output contains more than one protected region with the identifier '"+id+"'");
		}
		
		return Collections.unmodifiableList(problems);
	}
	
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		
		for (Region region : regions) {
			builder.append(region);
		}
		
		return builder.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (!(o instanceof Output)) return false;
		
		final Output that = (Output)o;
		
		return regions.equals(that.regions);
	}
	
	@Override
	public int hashCode() {
		return regions.hashCode();
	}
}
