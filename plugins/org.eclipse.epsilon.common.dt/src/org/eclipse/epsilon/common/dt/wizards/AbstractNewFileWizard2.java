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

package org.eclipse.epsilon.common.dt.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

public abstract class AbstractNewFileWizard2 extends Wizard implements INewWizard {

    private IStructuredSelection selection;
    private NewFileWizardPage2 newFileWizardPage;
    private IWorkbench workbench;
 

    public AbstractNewFileWizard2() {

        setWindowTitle(getTitle());

    } 


	public abstract String getTitle();
	
	public abstract String getExtension();

	public abstract String getDescription();


    @Override
    public void addPages() {

        newFileWizardPage = new NewFileWizardPage2(selection,getTitle(), getDescription(), getExtension());
        addPage(newFileWizardPage);
    }
    
    @Override
    public boolean performFinish() {
        
        final IFile file = newFileWizardPage.createNewFile();
        
        getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page =
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(page, file, true);
				} catch (PartInitException e) {
				}
			}
		});
        
        if (file != null)
            return true;
        else
            return false;        
    }

    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.workbench = workbench;
        this.selection = selection;
    }
}