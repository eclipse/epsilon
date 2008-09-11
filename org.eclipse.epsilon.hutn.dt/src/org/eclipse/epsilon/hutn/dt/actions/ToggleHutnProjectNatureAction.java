/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.hutn.dt.actions;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.hutn.dt.nature.HutnNature;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;

public class ToggleHutnProjectNatureAction extends AbstractObjectActionDelegate implements IObjectActionDelegate {

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		super.selectionChanged(action, selection);
		
		try {
			action.setChecked(containsEpsilonNature(selection));
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	public void run(IAction action) {
		try {
			if (getFirstElementInSelection() instanceof IProject) {
				final IProject project = (IProject)getFirstElementInSelection();
				
				final IProjectDescription desc = project.getDescription();
				final String[] natureIds = desc.getNatureIds();
				
				final String[] newNatureIds;
				
				if (containsEpsilonNature(natureIds)) {
					newNatureIds = new String[natureIds.length - 1];
					
					int index = 0;
					for (String natureId : natureIds) {
						if (!HutnNature.ID.equals(natureId)) {
							newNatureIds[index++] = natureId;
						}
					}
					
				} else {
					newNatureIds = new String[natureIds.length + 1];
					System.arraycopy(natureIds, 0, newNatureIds, 1, natureIds.length);
					newNatureIds[0] = HutnNature.ID;
				}
				
				desc.setNatureIds(newNatureIds);
				project.setDescription(desc, null);
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean containsEpsilonNature(ISelection selection) throws CoreException {
		if (getFirstElementOf(selection) instanceof IProject) {
			final IProject project = (IProject)getFirstElementOf(selection);
			final String[] natureIds = project.getDescription().getNatureIds();
			
			return containsEpsilonNature(natureIds);
		}
		
		return false;
	}
	
	private boolean containsEpsilonNature(String[] natureIds) {
		for (String natureId : natureIds) {
			if (HutnNature.ID.equals(natureId))
				return true;
		}
		
		return false;
	}
}
