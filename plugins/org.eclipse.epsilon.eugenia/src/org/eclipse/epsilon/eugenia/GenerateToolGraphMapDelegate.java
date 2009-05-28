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
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.gmf.mappings.GMFMapPackage;
import org.eclipse.gmf.tooldef.GMFToolPackage;

public class GenerateToolGraphMapDelegate extends EolTransformationActionDelegate {

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
	public List<EmfModel> getModels() throws Exception {
		
		String ecorePath = getSelectedFile().getLocationURI().toString();
		String gmfGraphPath = ecorePath.replaceAll("ecore", "gmfgraph");
		String gmfToolPath = ecorePath.replaceAll("ecore", "gmftool");
		String gmfMapPath = ecorePath.replaceAll("ecore", "gmfmap");
		
		List<EmfModel> models = new ArrayList<EmfModel>();
		models.add(loadModel("ECore", ecorePath, EcorePackage.eNS_URI, true, true, true));
		models.add(loadModel("GmfMap", gmfMapPath, GMFMapPackage.eNS_URI, false, true, true));
		models.add(loadModel("GmfGraph", gmfGraphPath, GMFGraphPackage.eNS_URI, false, true, true));
		models.add(loadModel("GmfTool", gmfToolPath, GMFToolPackage.eNS_URI, false, true, true));
		
		return models;
	}

	@Override
	public String getTitle() {
		return "Generating GMF .gmfgraph, .gmftool and .gmfmap models";
	}



}
