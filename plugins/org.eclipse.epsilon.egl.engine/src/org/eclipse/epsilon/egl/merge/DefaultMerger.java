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
package org.eclipse.epsilon.egl.merge;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.epsilon.egl.merge.output.LocatedRegion;
import org.eclipse.epsilon.egl.merge.output.RegionType;
import org.eclipse.epsilon.egl.merge.partition.Partitioner;
import org.eclipse.epsilon.egl.status.ProtectedRegionWarning;

public class DefaultMerger extends Merger {
	
	public DefaultMerger(Partitioner partitioner, String generated, String existing) {
		super(partitioner, generated, existing);
	}

	@Override
	public String merge() {
		warnings.clear();
		
		boolean hasProtectedRegions = false;
		boolean hasControlledRegions = false;
		
		for (LocatedRegion region : generated.getLocatedRegions()) {
			if (region.getType() == RegionType.Protected) {
				hasProtectedRegions = true;
				break;
			}
			else if (region.getType() == RegionType.Controlled) {
				hasControlledRegions = true;
				break;
			}
		}
		
		if (hasControlledRegions) {
			return mergeControlledRegions();
		}
		else /*if (hasProtectedRegions)*/ {
			return mergeProtectedRegions();
		}
		/*else {
			return generated.toString();
		}*/
		
	}
	
	public String mergeControlledRegions() {
		for (LocatedRegion existingRegion : existing.getLocatedRegions()) {
			final LocatedRegion generatedRegion = generated.getLocatedRegion(existingRegion.getId());
						
			if (existingRegion != null && existingRegion.isEnabled() && existingRegion.getType() == RegionType.Controlled) {
				generatedRegion.setEnabled(true);
				existingRegion.setContents(generatedRegion.getContents());
			}
		}
		
		return existing.toString();
	}
	
	public String mergeProtectedRegions() {
		warnings.clear();
		final List<String> idsPresentInGenerated = new LinkedList<String>();
		
		for (LocatedRegion generatedRegion : generated.getLocatedRegions()) {
			final LocatedRegion existingRegion = existing.getLocatedRegion(generatedRegion.getId());
			
			idsPresentInGenerated.add(generatedRegion.getId());
			
			if (existingRegion != null && existingRegion.isEnabled() && existingRegion.getType() == RegionType.Protected) {
				generatedRegion.setEnabled(true);
				generatedRegion.setContents(existingRegion.getContents());
			}
		}
		
		for (LocatedRegion existingRegion : existing.getLocatedRegions()) {
			if (!idsPresentInGenerated.contains(existingRegion.getId())) {
				warnings.add(new ProtectedRegionWarning(existingRegion.getId()));
			}
		}
		
		return generated.toString();
	}
	
}
