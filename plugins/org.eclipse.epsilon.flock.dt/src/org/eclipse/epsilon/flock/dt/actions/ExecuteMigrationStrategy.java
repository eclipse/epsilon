/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.flock.dt.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.epsilon.common.dt.actions.AbstractObjectActionDelegate;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.flock.dt.util.MigrationStrategyExecutor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;

public class ExecuteMigrationStrategy extends AbstractObjectActionDelegate {
	
	private final MigrationStrategyExtensionLocator locator = new MigrationStrategyExtensionLocator();
	
	private IFile modelFile;
	private MigrationStrategyExtension migrationStrategyExtension;
	
	
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		super.selectionChanged(action, selection);
		
		try {
			if (getFirstElementInSelection() instanceof IFile) {
				modelFile    = (IFile)getFirstElementInSelection();
				
				migrationStrategyExtension = locator.findMigrationStrategyExtensionFor(modelFile);
				
				action.setEnabled(migrationStrategyExtension != null);
			}
		
		} catch (MigrationStrategyExtensionLocatorException ex) {
			printError("Error while finding migration strategy for " + modelFile.getName() + ": " + ex.getLocalizedMessage());		
		}
	}


	@Override
	public void run(IAction action) {
		if (getFirstElementInSelection() instanceof IFile) {
			if (migrationStrategyExtension == null) {
				printInfo("No appropriate migration strategy could be found for " + modelFile.getName());
				
			} else {
				migrateSelectionUsing(migrationStrategyExtension);
			}
		}
	}	
	
	
	private void migrateSelectionUsing(MigrationStrategyExtension extension) {
		new MigrationStrategyExecutor(modelFile,
		                              extension.getStrategyFile(),
		                              extension.getOriginalMetamodel(),
		                              extension.getEvolvedMetamodel()).run();
	}


	private static void printInfo(Object message) {
		EpsilonConsole.getInstance().getInfoStream().println(message);
	}
	
	private static void printError(Object message) {
		EpsilonConsole.getInstance().getErrorStream().println(message);
	}
}
