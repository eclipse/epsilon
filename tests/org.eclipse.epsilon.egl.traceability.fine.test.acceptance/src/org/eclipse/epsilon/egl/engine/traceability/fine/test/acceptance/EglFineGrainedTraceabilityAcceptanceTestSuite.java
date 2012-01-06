/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance;

import org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.contributions.DynamicOutputSectionsContributeToTrace;
import org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.contributions.ExplicitPrintsShouldContributeToTrace;
import org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.contributions.StaticSectionsDoNotContributeToTrace;
import org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.customdata.AnnotatedOperationsCanCreateSeveralCustomDataItems;
import org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.customdata.AnnotatedOperationsShouldCreateCustomData;
import org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.customdata.AnnotatedOperationsShouldNotAffectOtherAnnotatedOperations;
import org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.customdata.AnnotatedOperationsShouldNotAffectOtherPrintStatements;
import org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.misc.TraceShouldNotContainDuplicateFeatureAccessesPerTextLocation;
import org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.subtemplates.SubtemplateShouldContributeToTraceOfParent;
import org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.subtemplates.SubtemplateTraceShouldBeAdjustedWhenContributedToParent;
import org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.textlocations.GenerateShouldUpdateTextLocation;
import org.eclipse.epsilon.egl.engine.traceability.fine.test.acceptance.textlocations.ShouldRespectNewLines;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({DynamicOutputSectionsContributeToTrace.class, StaticSectionsDoNotContributeToTrace.class, ExplicitPrintsShouldContributeToTrace.class,
               SubtemplateShouldContributeToTraceOfParent.class, SubtemplateTraceShouldBeAdjustedWhenContributedToParent.class,
               TraceShouldNotContainDuplicateFeatureAccessesPerTextLocation.class,
               ShouldRespectNewLines.class, GenerateShouldUpdateTextLocation.class,
               AnnotatedOperationsShouldCreateCustomData.class, AnnotatedOperationsCanCreateSeveralCustomDataItems.class, AnnotatedOperationsShouldNotAffectOtherPrintStatements.class, AnnotatedOperationsShouldNotAffectOtherAnnotatedOperations.class})
public class EglFineGrainedTraceabilityAcceptanceTestSuite {

}
