/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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
	private final List<String> locatedRegionIds           = new LinkedList<String>();
	private final List<String> duplicatedLocatedRegionIds = new LinkedList<String>();
	
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
			if (r instanceof LocatedRegion) {
				final LocatedRegion pr = (LocatedRegion)r;
				
				if (locatedRegionIds.contains(pr.getId())) {
					duplicatedLocatedRegionIds.add(pr.getId());
				} else {
					locatedRegionIds.add(pr.getId());
				}
			}
		}
	}
	
	public List<Region> getRegions() {
		return Collections.unmodifiableList(regions);
	}
	
	public List<LocatedRegion> getLocatedRegions() {
		List<LocatedRegion> locatedRegions = new LinkedList<LocatedRegion>();
		
		for (Region region : regions) {
			if (region instanceof LocatedRegion)
				locatedRegions.add((LocatedRegion)region);
		}
		
		return Collections.unmodifiableList(locatedRegions);
	}
	
	public LocatedRegion getLocatedRegion(String id) {
		for (Region region : regions) {
			if (region instanceof LocatedRegion) {
				LocatedRegion locatedRegion = (LocatedRegion)region;
				if (locatedRegion.getId().equals(id)) {
					return locatedRegion;
				}
			}
		}
		
		return null;
	}
	
	public List<String> getProblems() {
		final List<String> problems = new LinkedList<String>();
		
		for (String id : duplicatedLocatedRegionIds) {
			problems.add("Output contains more than one region with the identifier '"+id+"'");
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
