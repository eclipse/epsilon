/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.engine.traceability.fine.wrappers;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.ModelRepository;

public class TraceableModelInjector {
	
	public void makeTraceable(ModelRepository repository) {
		final List<IModel> untraceableModels = repository.getModels();
		final List<TraceableModel> traceableModels = new LinkedList<TraceableModel>();
		
		for (int modelIndex = 0; modelIndex < untraceableModels.size(); modelIndex++) {
			final IModel untraceableModel = untraceableModels.remove(modelIndex);
			traceableModels.add(new TraceableModel(untraceableModel));
		}
		
		for (TraceableModel traceableModel : traceableModels) {
			repository.addModel(traceableModel);
		}
	}
}
