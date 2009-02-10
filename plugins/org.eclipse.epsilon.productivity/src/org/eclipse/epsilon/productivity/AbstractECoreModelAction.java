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
package org.eclipse.epsilon.productivity;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.commons.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public abstract class AbstractECoreModelAction implements IObjectActionDelegate {
	
	ISelection selection;
	
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		
	}

	public void run(IAction action) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Iterator it = structuredSelection.iterator();
			while (it.hasNext()) {
				IFile file = (IFile) it.next();
				EmfModel model = new EmfModel();
				StringProperties properties = new StringProperties();
				properties.put(EmfModel.PROPERTY_MODEL_FILE, file.getFullPath().toOSString());
				properties.put(EmfModel.PROPERTY_METAMODEL_URI, EcorePackage.eINSTANCE.getNsURI());
				properties.put(EmfModel.PROPERTY_IS_METAMODEL_FILE_BASED, "false");
				properties.put(EmfModel.PROPERTY_READONLOAD, "true");
				properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, "false");
				try {
					model.load(properties, null);
					perform(file, model);
				} catch (Exception e) {
					LogUtil.log(e);
				}
			}
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}
	
	abstract protected void perform(IFile file, EmfModel model) throws Exception;
	
}
