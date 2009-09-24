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
package org.eclipse.epsilon.flock.dt.editor.outline;

import org.eclipse.epsilon.eol.dt.editor.outline.EolModuleElementLabelProvider;
import org.eclipse.epsilon.flock.dt.FlockDevelopmentToolsPlugin;
import org.eclipse.epsilon.flock.model.DeleteRule;
import org.eclipse.epsilon.flock.model.MigrateRule;
import org.eclipse.swt.graphics.Image;

public class FlockModuleElementLabelProvider extends EolModuleElementLabelProvider{

	@Override
	public Image getImage(Object element) {
		if (element instanceof MigrateRule) {
			return FlockDevelopmentToolsPlugin.getDefault().createImage("icons/rules/migrate.gif");
		
		} else if (element instanceof DeleteRule) {
			return FlockDevelopmentToolsPlugin.getDefault().createImage("icons/rules/delete.gif");
			
		} else {
			return super.getImage(element);
		}
	}
	
	@Override
	public String getText(Object element) {
		// The implementation of MigrationRule#toString is good for tests and debugging,
		// but looks messy in outline view, so overriding getText for MigrationRules
		
		if (element instanceof MigrateRule) {
			return ((MigrateRule)element).getOriginalType() + " to " + ((MigrateRule)element).migratedType;
		
		} else if (element instanceof DeleteRule) {
			return "delete " + ((DeleteRule)element).getOriginalType();
			
		} else {
			return super.getText(element);
		}
	}
	
}
