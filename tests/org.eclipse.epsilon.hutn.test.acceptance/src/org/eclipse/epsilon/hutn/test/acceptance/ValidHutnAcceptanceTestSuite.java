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
 * $Id: ValidHutnAcceptanceTestSuite.java,v 1.9 2008/08/14 13:04:24 louis Exp $
 */
package org.eclipse.epsilon.hutn.test.acceptance;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.eclipse.epsilon.hutn.test.acceptance.valid.Adjectives;
import org.eclipse.epsilon.hutn.test.acceptance.valid.AssociationBlock;
import org.eclipse.epsilon.hutn.test.acceptance.valid.Associations;
import org.eclipse.epsilon.hutn.test.acceptance.valid.ClassifierLevelAttributePrecedence;
import org.eclipse.epsilon.hutn.test.acceptance.valid.ClassifierLevelAttributes;
import org.eclipse.epsilon.hutn.test.acceptance.valid.Comments;
import org.eclipse.epsilon.hutn.test.acceptance.valid.Containment;
import org.eclipse.epsilon.hutn.test.acceptance.valid.ContainmentEmpty;
import org.eclipse.epsilon.hutn.test.acceptance.valid.ContainmentRepeatedFeatureName;
import org.eclipse.epsilon.hutn.test.acceptance.valid.DefaultValue;
import org.eclipse.epsilon.hutn.test.acceptance.valid.Enumerations;
import org.eclipse.epsilon.hutn.test.acceptance.valid.ExternalObjectReference;
import org.eclipse.epsilon.hutn.test.acceptance.valid.InferEmptyInstanceForRequiredReference;
import org.eclipse.epsilon.hutn.test.acceptance.valid.Inference;
import org.eclipse.epsilon.hutn.test.acceptance.valid.InfixAssociation;
import org.eclipse.epsilon.hutn.test.acceptance.valid.Simple;
import org.eclipse.epsilon.hutn.test.acceptance.valid.SpecOnly;
import org.eclipse.epsilon.hutn.test.acceptance.valid.TwoMetamodels;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({SpecOnly.class, Simple.class, Comments.class, Adjectives.class,
               Associations.class, Containment.class, ContainmentEmpty.class,
               Inference.class, DefaultValue.class, Enumerations.class, 
               ClassifierLevelAttributes.class, ClassifierLevelAttributePrecedence.class, 
               AssociationBlock.class, InfixAssociation.class,
               ExternalObjectReference.class, TwoMetamodels.class,
               ContainmentRepeatedFeatureName.class, InferEmptyInstanceForRequiredReference.class})
public class ValidHutnAcceptanceTestSuite {

	public static Test suite() {
		return new JUnit4TestAdapter(ValidHutnAcceptanceTestSuite.class);
	}
}
