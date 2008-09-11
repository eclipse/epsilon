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
package org.eclipse.epsilon.dt.exeed.modelink;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.jdom.Document;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class StoreXmlDocumentOperation extends WorkspaceModifyOperation {
	
	protected Document doc;
	protected IFile file;
	
	public StoreXmlDocumentOperation(Document doc, IFile file) {
		super();
		this.doc = doc;
		this.file = file;
	}
	
	@Override
	protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
		
		XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
		try {
			outputter.output(doc, new FileOutputStream(file.getLocation().toOSString()));
			file.refreshLocal(IResource.DEPTH_ZERO, null);
			//ResourcesPlugin.getWorkspace().getRoot().refreshLocal())
		} catch (Exception e) {
			LogUtil.log(e);
		}
	}

}
