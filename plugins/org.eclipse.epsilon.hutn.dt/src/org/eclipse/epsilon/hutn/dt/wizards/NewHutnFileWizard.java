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
package org.eclipse.epsilon.hutn.dt.wizards;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.common.dt.wizards.AbstractNewFileWizard;

public class NewHutnFileWizard extends AbstractNewFileWizard {

	public NewHutnFileWizard() {
		super(new NewHutnFileWizardPage());
	}
	
	
	public String getTitle() {
		return "New HUTN File";
	}

	public String getExtension() {
		return "hutn";
	}

	public String getDescription() {
		return "This wizard creates a new HUTN file with *.hutn extension";
	}

	
	private EPackage selectedEPackage;
	
	@Override
	public boolean performFinish() {
		selectedEPackage = ((NewHutnFileWizardPage)page).getSelectedEPackage();
		
		return super.performFinish();
	} 
	
	@Override
	protected String determineInitialContents() {
		if (selectedEPackage == null)
			return "";
		
		else
			return "@Spec {\n" +
			       "\tmetamodel \"" + getMetamodelName() + "\" {\n" +
			       "\t\tnsUri: \"" + selectedEPackage.getNsURI() + "\"\n" +
			       "\t}\n" +
			       "}\n\n" +
			       selectedEPackage.getName() + " {\n" +
			       "\t\n" + 
			       "}";
	}
	
	
	private String getMetamodelName() {
		if (selectedEPackage == null) {
			return "";
		
		} else {
			final String nsUri = selectedEPackage.getNsURI();
			
			if (nsUri.contains("/")) {
				return nsUri.substring(nsUri.lastIndexOf('/')+1);
			
			} else {
				return nsUri;
			}
		}
	}
	
}
