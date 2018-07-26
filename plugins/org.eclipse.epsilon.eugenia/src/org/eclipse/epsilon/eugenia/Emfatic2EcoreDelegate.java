/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eugenia;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.emfatic.core.generator.ecore.EcoreGenerator;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.jface.action.IAction;

public class Emfatic2EcoreDelegate extends EugeniaActionDelegate {

	@Override
	public void runImpl(IAction action) throws Exception {
		EcoreGenerator ecoreGenerator = new EcoreGenerator();
		ecoreGenerator.generate(WorkspaceUtil.getFile(gmfFileSet.getEmfaticPath()), true, new NullProgressMonitor());
	}
	
	@Override
	public boolean isApplicable() {
		return getSelectedFile().getLocationURI().toString().equals(gmfFileSet.getEmfaticPath());
	}
	
	@Override
	public EugeniaActionDelegateStep getStep() {
		return EugeniaActionDelegateStep.ecore;
	}
	
	@Override
	public String getBuiltinTransformation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCustomizationTransformation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IModel> getModels() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() {
		return "Generating Ecore model from Emfatic";
	}

}
