/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.common.dt.editor;

import org.eclipse.epsilon.common.dt.launching.extensions.ModelTypeExtension;
import org.eclipse.epsilon.eol.compile.context.IModelFactory;
import org.eclipse.epsilon.eol.models.IModel;

public class ModelTypeExtensionFactory implements IModelFactory {

	@Override
	public IModel createModel(String driver) {
		try {
			return ModelTypeExtension.forType(driver).createModel();
		} catch (Exception e) {
			return null;
		}
	}

}