/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.merge;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.epsilon.egl.merge.output.Output;
import org.eclipse.epsilon.egl.merge.partition.Partitioner;
import org.eclipse.epsilon.egl.status.ProtectedRegionWarning;

public abstract class Merger {

	protected final Partitioner partitioner;
	protected final Output generated, existing;
	
	protected final List<ProtectedRegionWarning> warnings = new LinkedList<>();
	
	protected Merger(Partitioner partitioner, String generated, String existing) {
		this.partitioner = partitioner;
		this.generated   = partitioner.partition(generated);
		this.existing    = partitioner.partition(existing);
	}
	
	public List<ProtectedRegionWarning> getMergeWarnings() {
		return Collections.unmodifiableList(warnings); 
	}
	
	public abstract String merge();
}
