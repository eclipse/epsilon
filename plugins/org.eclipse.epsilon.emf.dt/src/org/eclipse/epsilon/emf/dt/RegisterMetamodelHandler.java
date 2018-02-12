/*******************************************************************************
 * Copyright (c) 2018 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Horacio Hoyos Rodriguez - move to IHandler, add XCore support
 ******************************************************************************/
package org.eclipse.epsilon.emf.dt;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;


public class RegisterMetamodelHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		Iterator<?> it = ((IStructuredSelection) selection).iterator();
		while (it.hasNext()) {
			IFile file = (IFile) it.next();
			//String fileName = ResourcesPlugin.getWorkspace().getRoot().getRawLocation().toPortableString() + file.getFullPath().toOSString();
			String fileName = file.getFullPath().toOSString();
			//String fileName = file.getRawLocation().toOSString();
			try {
				EmfRegistryManager.getInstance().addMetamodel(fileName);
				LogUtil.logInfo("Metamodel " + fileName + " registered successfully");
			}
			catch (Exception ex) {
				LogUtil.log("Metamodel " + fileName + " could not be registered", ex);
			}
		}
		return null;
	}

	

}
