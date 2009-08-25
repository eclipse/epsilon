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
package org.eclipse.epsilon.common.dt.console;

import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsolePageParticipant;
import org.eclipse.ui.part.IPageBookViewPage;

public class EpsilonConsolePageParticipant implements IConsolePageParticipant {

	public void activated() {
		
	}

	public void deactivated() {
		// TODO Auto-generated method stub

	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void init(IPageBookViewPage page, IConsole console) {
		// TODO Auto-generated method stub
		//System.err.println(console.getName() + " -> " + page);
		/*
		if (console.getName().equalsIgnoreCase("Epsilon")) {
			IOConsolePage ioConsolePage = (IOConsolePage) page;
			IToolBarManager toolbarManager = ioConsolePage.getSite().getActionBars().getToolBarManager();
			
			for (IContributionItem item : toolbarManager.getItems()) {
				System.err.println(item.isSeparator());
			}
			
			toolbarManager.add(new Action() {

				@Override
				public ImageDescriptor getImageDescriptor() {
					return EpsilonCommonsPlugin.getImageDescriptor("icons/stop.enabled.gif");
				}
				
			});
		}
		*/
	}

	
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
