/**
 * *******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 * ******************************************************************************
 *
 * $Id: ModelValidatorSuite.java,v 1.4 2008/10/09 11:54:05 louis Exp $
 */
package org.eclipse.epsilon.hutn.test.unit;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.eclipse.epsilon.hutn.validation.model.externalrefs.NonExistentModel;
import org.eclipse.epsilon.hutn.validation.model.externalrefs.NonExistentModelElementId;
import org.eclipse.epsilon.hutn.validation.model.externalrefs.NonExistentModelElementXpath;
import org.eclipse.epsilon.hutn.validation.model.externalrefs.Valid;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({Valid.class, NonExistentModel.class,
               NonExistentModelElementXpath.class, NonExistentModelElementId.class})
public class ModelValidatorExternalRefSuite {

	public static Test suite() {
		return new JUnit4TestAdapter(ModelValidatorExternalRefSuite.class);
	}
}
