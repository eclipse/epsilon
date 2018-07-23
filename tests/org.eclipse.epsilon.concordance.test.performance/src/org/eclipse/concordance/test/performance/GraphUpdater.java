/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.concordance.test.performance;

import java.io.File;

import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfModelFactory;
import org.eclipse.epsilon.emc.emf.EmfModelFactory.AccessMode;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

public class GraphUpdater {
	
	public File update(File target) {
		try {
			final IEolModule module = new EolModule();
												
			module.getContext().getModelRepository().addModel(loadGraphModel(target));			
			module.parse(GraphUpdater.class.getResource("GraphUpdater.eol").toURI());
			module.execute();
			
			module.getContext().getModelRepository().dispose();
						
		} catch (Exception e) {
			LogUtil.log("Error encountered whilst generating model to " + target, e);
		}
		
		return target;
	}

	private EmfModel loadGraphModel(File target) throws EolModelLoadingException {
		return EmfModelFactory.getInstance().loadEmfModel("Model", target, "graph", AccessMode.READ_WRITE);
	}
}
