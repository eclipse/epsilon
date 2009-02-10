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

package org.eclipse.epsilon.concordance.builder;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

public class WorkspaceMonitor implements IStartup {
	
	//TODO: Add support for project open/close
	public void earlyStartup() {
		/*
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().addPartListener(new IPartListener() {

			public void partActivated(IWorkbenchPart part) {
				// TODO Auto-generated method stub
				System.err.println(part);
			}

			public void partBroughtToTop(IWorkbenchPart part) {
				// TODO Auto-generated method stub
				
			}

			public void partClosed(IWorkbenchPart part) {
				// TODO Auto-generated method stub
				
			}

			public void partDeactivated(IWorkbenchPart part) {
				// TODO Auto-generated method stub
				
			}

			public void partOpened(IWorkbenchPart part) {
				// TODO Auto-generated method stub
				System.err.println(part);
			}
			
		});
		
		/*
		ResourcesPlugin.getWorkspace().addResourceChangeListener(
				new ProjectDeletedListener(), 
				IResourceChangeEvent.PRE_DELETE);
		
		//ResourcesPlugin.getWorkspace().addResourceChangeListener(
		//		new ModelMovedListener(), 
		//		IResourceChangeEvent.PRE_DELETE);
		
		
		ResourcesPlugin.getWorkspace().addResourceChangeListener(
				new ProjectOpenedListener(),
				IResourceChangeEvent.PRE_DELETE);
		*/
	}
	
}
 