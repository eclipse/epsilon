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

import org.eclipse.epsilon.egl.merge.output.ProtectedRegion;
import org.eclipse.epsilon.egl.merge.partition.Partitioner;
import org.eclipse.epsilon.egl.status.ProtectedRegionWarning;

public class DefaultMerger extends Merger {
	
	public DefaultMerger(Partitioner partitioner, String generated, String existing) {
		super(partitioner, generated, existing);
	}

	@Override
	public String merge() {
		warnings.clear();
		final List<String> idsPresentInGenerated = new LinkedList<String>();
		
		for (ProtectedRegion generatedRegion : generated.getProtectedRegions()) {
			final ProtectedRegion existingRegion = existing.getProtectedRegion(generatedRegion.getId());
			
			idsPresentInGenerated.add(generatedRegion.getId());
			
			if (existingRegion != null && existingRegion.isEnabled()) {
				generatedRegion.setEnabled(true);
				generatedRegion.setContents(existingRegion.getContents());
			}
		}
		
		for (ProtectedRegion existingRegion : existing.getProtectedRegions()) {
			if (!idsPresentInGenerated.contains(existingRegion.getId())) {
				warnings.add(new ProtectedRegionWarning(existingRegion.getId()));
			}
		}
		
		return generated.toString();
	}
}
