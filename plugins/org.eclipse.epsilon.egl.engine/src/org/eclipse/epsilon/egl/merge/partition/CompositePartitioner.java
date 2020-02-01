/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.merge.partition;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.eclipse.epsilon.egl.merge.output.Output;
import org.eclipse.epsilon.egl.merge.output.LocatedRegion;
import org.eclipse.epsilon.egl.merge.output.Region;

public class CompositePartitioner implements Partitioner {

	private final List<CommentBlockPartitioner> partitioners = new LinkedList<>();
	
	public CompositePartitioner(CommentBlockPartitioner... partitioners) {
		for (CommentBlockPartitioner partitioner : partitioners) {
			addPartitioner(partitioner);
		}
	}
	
	public void addPartitioner(CommentBlockPartitioner partitioner) {
		if (partitioner == null)
			throw new NullPointerException("partitioner cannot be null");
		
		if (!partitioners.contains(partitioner)) partitioners.add(partitioner);
	}

	@Override
	public Output partition(String text) {
		return partition(text, 0);
	}
	
	@Override
	public Output partition(String text, int offset) {
		final List<Region> regions = new LinkedList<>();
		
		regions.add(new Region(text));
		
		for (CommentBlockPartitioner partitioner : partitioners) {
			int currentOffset = offset;
			
			for (int index = 0; index < regions.size(); index++) {
				final Region region = regions.get(index);
				
				if (!(region instanceof LocatedRegion)) {
					final Output output = partitioner.partition(region.getContents(), currentOffset);
					
					if (output.getLocatedRegions().size() > 0) {
						regions.remove(index);
						regions.addAll(index, output.getRegions());
						
						for (Region r : output.getRegions()) {
							currentOffset += r.toString().length();
						}
						
						index += output.getRegions().size() - 1;
					} else {
						currentOffset += region.toString().length();
					}
				
				} else {
					currentOffset += region.toString().length();
				}
			}
		}
		
		return new Output(regions);
	}
	
	public CommentBlockPartitioner getDefaultPartitioner() {
		return partitioners.isEmpty() ? null : partitioners.get(0);
	}
	
	@Override
	public String toString() {
		return partitioners.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CompositePartitioner)) return false;	
		final CompositePartitioner that = (CompositePartitioner) o;
		return Objects.equals(this.partitioners, that.partitioners);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(partitioners);
	}
}
