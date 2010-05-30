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

public class GenerateToolGraphMapDelegate extends EugeniaActionDelegate {
 
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
	
	
	/*
	@Override
	public void run(IAction action) {
		
		// Clear previous files
		ClearGmfFileSetAction clearGmfFileSetAction = new ClearGmfFileSetAction();
		clearGmfFileSetAction.setSelection(selection);
		clearGmfFileSetAction.run(action);
		
		// Do Ecore to GenModel transformation
		Ecore2GenModelDelegate ecore2GenModelDelegate = new Ecore2GenModelDelegate();
		ecore2GenModelDelegate.setSelection(this.selection);
		ecore2GenModelDelegate.run(action);
		refresh();
		
		WorkspaceUtil.waitFor(gmfFileSet.getGenModelPath());
		
		System.err.println("done");
		
//		try {
//			runImpl(action);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		refresh();
//		
//		WorkspaceUtil.waitFor(gmfFileSet.getGmfMapPath());
		
		// Do GmfMap to GmfGen
//		GmfMap2GmfGenDelegate gmfMap2GmfGenDelegate = new GmfMap2GmfGenDelegate();
//		gmfMap2GmfGenDelegate.setSelection(this.selection);
//		gmfMap2GmfGenDelegate.run(action);
//		refresh();
		
		// Do FixGmfGen
		//FixGmfGenDelegate fixGmfGenDelegate = new FixGmfGenDelegate();
		//fixGmfGenDelegate.setSelection(this.selection);
		//fixGmfGenDelegate.run(action);
		
	}
	*/
	
	/*@Override
	public void runImpl(IAction action) throws Exception {
		
		// Clear previous files
		ClearGmfFileSetAction clearGmfFileSetAction = new ClearGmfFileSetAction();
		clearGmfFileSetAction.setSelection(selection);
		clearGmfFileSetAction.run(action);
		
//		// Do Ecore to GenModel transformation
//		Ecore2GenModelDelegate ecore2GenModelDelegate = new Ecore2GenModelDelegate();
//		ecore2GenModelDelegate.setSelection(this.selection);
//		ecore2GenModelDelegate.run(action);
//		refresh();
		
		// Do Ecore to GmfTool, GmfGraph and GmfMap
		super.runImpl(action);
		
		
//		// Do GmfMap to GmfGen
//		GmfMap2GmfGenDelegate gmfMap2GmfGenDelegate = new GmfMap2GmfGenDelegate();
//		gmfMap2GmfGenDelegate.setSelection(this.selection);
//		gmfMap2GmfGenDelegate.run(action);
//		refresh();
		
		
		// Do FixGmfGen
		FixGmfGenDelegate fixGmfGenDelegate = new FixGmfGenDelegate();
		fixGmfGenDelegate.setSelection(this.selection);
		fixGmfGenDelegate.run(action);
		
		
	}*/
	
	@Override
	public List<EmfModel> getModels() throws Exception {
		
		List<EmfModel> models = new ArrayList<EmfModel>();
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



}
