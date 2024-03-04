/*********************************************************************
 * Copyright (c) 2024 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.eol.dom.Import;

public interface IImportManager {
	
	void loadModuleForImport(Import importAst, Class<? extends IModule> moduleImplClass, URI baseURI) throws URISyntaxException;

}
