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
package org.eclipse.epsilon.common.dt.launching.dialogs;

import org.eclipse.epsilon.common.dt.util.DialogUtil;
import org.eclipse.epsilon.eol.models.CachedModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public abstract class AbstractCachedModelConfigurationDialog extends AbstractModelConfigurationDialog {
	
	protected Button isCachedButton;
	
	protected void createGroups(Composite control) {
		super.createGroups(control);
		createPerformanceGroup(control);
	}
	
	protected void createPerformanceGroup(Composite parent) {
		final Composite groupContent = DialogUtil.createGroupContainer(parent, "Performance", 3);
		
		isCachedButton = new Button(groupContent, SWT.CHECK);
		isCachedButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		isCachedButton.setText("Cache model elements to improve execution time");
		isCachedButton.setSelection(true);
		
		GridData isCachedButtonData = new GridData();
		isCachedButtonData.horizontalSpan = 2;
		isCachedButton.setLayoutData(isCachedButtonData);
		
		groupContent.layout();
		groupContent.pack();
	}
	
	protected void loadProperties() {
		super.loadProperties();
		if (properties == null) return;
		if (isCachedButton != null) isCachedButton.setSelection(properties.getBooleanProperty(CachedModel.PROPERTY_CACHED, true));
	}
	
	protected void storeProperties() {
		super.storeProperties();
		if (isCachedButton != null) properties.put(CachedModel.PROPERTY_CACHED, isCachedButton.getSelection() + "");
	}
}
