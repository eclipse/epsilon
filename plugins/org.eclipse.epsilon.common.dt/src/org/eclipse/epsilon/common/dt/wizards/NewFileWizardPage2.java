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

import java.io.InputStream;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class NewFileWizardPage2 extends WizardNewFileCreationPage {

    public NewFileWizardPage2(IStructuredSelection selection, String title, String description, String fileExtension) {
        super("page", selection);
        setTitle(title);
        setDescription(description);
        setFileExtension(fileExtension);
    }
}
 