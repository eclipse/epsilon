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
package org.eclipse.epsilon.eugenia;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.gmf.mappings.GMFMapPackage;
import org.eclipse.gmf.tooldef.GMFToolPackage;

public class GenerateToolGraphMapDelegate extends GuardedEcoreModelGenerationDelegate {
	
	boolean valid = false;
	
	public GenerateToolGraphMapDelegate() {
		super();
	}

	@Override
	public String getBuiltinTransformation() {
		return "transformations/ECore2GMF.eol";
	}

	@Override
	public String getCustomizationTransformation() {
		return "ECore2GMF.eol";
	}
	
	@Override
	public EugeniaActionDelegateStep getStep() {
		return EugeniaActionDelegateStep.gmf;
	}
	
	@Override
	public List<IModel> getModels() throws Exception {
		List<IModel> models = new ArrayList<IModel>();
		models.add(loadModel("ECore", gmfFileSet.getEcorePath(), EcorePackage.eNS_URI, true, true, true));
		models.add(loadModel("GmfMap", gmfFileSet.getGmfMapPath(), GMFMapPackage.eNS_URI, false, true, true));
		models.add(loadModel("GmfGraph", gmfFileSet.getGmfGraphPath(), GMFGraphPackage.eNS_URI, false, true, true));
		models.add(loadModel("GmfTool", gmfFileSet.getGmfToolPath(), GMFToolPackage.eNS_URI, false, true, true));
		
		return models;
	}

	@Override
	public String getTitle() {
		return "Generating GMF .gmfgraph, .gmftool and .gmfmap models";
	}

	@Override
	public AbstractEcoreModelValidationDelegate createEcoreModelValidationDelegate() {
		 return new ToolGraphMapEcoreValidationDelegate();
	}
	
}
