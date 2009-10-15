package org.eclipse.epsilon.hutn.xmi.dt.startup;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.resource.Resource;

/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */

public class RegisteredMetamodels {

	private static RegisteredMetamodels instance = new RegisteredMetamodels();
	
	private RegisteredMetamodels() {}
	
	public static RegisteredMetamodels getInstance() {
		return instance;
	}
	
	public Collection<String> getFileExtensionsOfAllRegisteredMetamodels() {
		return Collections.unmodifiableCollection(Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().keySet());
	}

}
