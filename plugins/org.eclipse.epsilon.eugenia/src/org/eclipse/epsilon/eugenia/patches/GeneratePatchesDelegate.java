/*******************************************************************************
 * Copyright (c) 2013 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eugenia.patches;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eugenia.EugeniaActionDelegate;
import org.eclipse.epsilon.eugenia.EugeniaActionDelegateStep;
import org.eclipse.epsilon.eugenia.GmfFileSet;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.gmf.mappings.GMFMapPackage;
import org.eclipse.gmf.tooldef.GMFToolPackage;

public class GeneratePatchesDelegate extends EugeniaActionDelegate {
	
	@Override
	public boolean isApplicable() {
		IFolder patchesFolder = getPatchesFolder();
		return patchesFolder != null && patchesFolder.exists();
	}
	
	@Override
	public String getTitle() {
		return "Generating patches";
	}

	@Override
	public EugeniaActionDelegateStep getStep() {
		return EugeniaActionDelegateStep.generatepatches;
	}
	
	@Override
	protected GmfFileSet createGmfFileSetFromSelection(IResource selection) {
		return new GmfFileSet(findGmfGenNear(selection).getLocation().toFile().toURI().toString());
	}

	private IResource findGmfGenNear(IResource selection) {
		try {
			for (IResource neighbour : selection.getParent().members()) {
				if (neighbour instanceof IFile && "gmfgen".equals(neighbour.getFileExtension())) {
					return neighbour;
				}
			}
		} catch (CoreException e) {
			LogUtil.log("Error encountered whilst generating your patches.", e);
		}
		return null;
	}

	@Override
	public List<IModel> getModels() throws Exception {
		final List<IModel> models = new ArrayList<>();
		
		models.add(loadModel("GmfGen", gmfFileSet.getGmfGenPath(), GMFGenPackage.eINSTANCE.getNsURI(), true, true, false));

		models.add(loadModel("ECore", gmfFileSet.getEcorePath(), EcorePackage.eNS_URI, true, false, true));
		models.add(loadModel("GenModel", gmfFileSet.getGenModelPath(), GenModelPackage.eINSTANCE.getNsURI(), true, false, false));
		models.add(loadModel("GmfGraph", gmfFileSet.getGmfGraphPath(), GMFGraphPackage.eINSTANCE.getNsURI(), true, false, false));
		models.add(loadModel("GmfTool", gmfFileSet.getGmfToolPath(), GMFToolPackage.eINSTANCE.getNsURI(), true, false, false));
		models.add(loadModel("GmfMap", gmfFileSet.getGmfMapPath(), GMFMapPackage.eINSTANCE.getNsURI(), true, false, false));
		
		return models;
	}

	@Override
	public String getBuiltinTransformation() {
		return "transformations/GeneratePatches.eol";
	}

	@Override
	public String getCustomizationTransformation() {
		return "GeneratePatches.egx";
	}
	
	@Override
	public IEolModule createCustomizationModule() throws EglRuntimeException {
		return new EgxModule(createFactory());
	}

	private EglTemplateFactory createFactory() throws EglRuntimeException {
		final EglFileGeneratingTemplateFactory factory = new EglFileGeneratingTemplateFactory();
		//factory.setTemplateRoot(getSelection().getParent().getLocation().toOSString()); Commented out to fix bug #417462
		factory.setOutputRoot(getPatchesFolder().getLocation().toOSString());
		return factory;
	}

	private IFolder getPatchesFolder() {
		return getSelection().getProject().getFolder("patches");
	}

	@Override
	public void refresh() {
		try {
			getPatchesFolder().refreshLocal(IResource.DEPTH_ONE, null);
			super.refresh();
	
		} catch (CoreException e) {}
	}
}
