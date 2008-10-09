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
 * $Id: ModelGeneratorSuite.java,v 1.3 2008/08/08 17:19:01 louis Exp $
 */
package org.eclipse.epsilon.hutn.test.unit;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.eclipse.epsilon.hutn.generate.model.Associations;
import org.eclipse.epsilon.hutn.generate.model.Containment;
import org.eclipse.epsilon.hutn.generate.model.EmptySpec;
import org.eclipse.epsilon.hutn.generate.model.Enumerations;
import org.eclipse.epsilon.hutn.generate.model.NoMetaModel;
import org.eclipse.epsilon.hutn.generate.model.SingleClass;
import org.eclipse.epsilon.hutn.generate.model.SingleClassWithAttributes;
import org.eclipse.epsilon.hutn.generate.model.TwoClasses;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({NoMetaModel.class, EmptySpec.class, SingleClass.class,
               TwoClasses.class, SingleClassWithAttributes.class,
               Associations.class, Containment.class, Enumerations.class})
public class ModelGeneratorSuite {

	public static Test suite() {
		return new JUnit4TestAdapter(ModelGeneratorSuite.class);
	}
}
