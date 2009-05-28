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

package org.eclipse.epsilon.concordance.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.commons.profiling.Profiler;
import org.eclipse.epsilon.concordance.index.CrossReferenceIndexManager;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class LoadAllModelsAction implements IObjectActionDelegate {
	
	protected ISelection selection = null;
	
	public LoadAllModelsAction() {
		// TODO Auto-generated constructor stub
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub
		
	}

	public void run(IAction action) {
		IProject project = (IProject) ((StructuredSelection) selection).getFirstElement();
		try {
			project.accept(new ModelLoader());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class ModelLoader implements IResourceVisitor {

		public boolean visit(IResource resource) throws CoreException {
			
			CrossReferenceIndexManager manager = CrossReferenceIndexManager.INSTANCE;
			
			if (manager.isModel(resource)) {
				
				Profiler.INSTANCE.start("Load");
				
				//System.err.println(resource.getFullPath().toOSString());
				URI uri = URI.createPlatformResourceURI(resource.getFullPath().toOSString(), true);
				//System.err.println(uri.toString());
				
				ResourceSet rs = new ResourceSetImpl();
				Resource r = rs.createResource(uri);
				try {
					r.load(null);
					TreeIterator<EObject> it = r.getAllContents();
					while (it.hasNext()) {
						EObject o = it.next();
					}
					EcoreUtil.resolveAll(r);
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
				
				Profiler.INSTANCE.stop();
			}
			
			
			
			//Resource.Factory.Registry.INSTANCE.getFactory(arg0);
			
			return true;
		}
		
	}
	
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

}
 