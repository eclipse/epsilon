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
package org.eclipse.epsilon.egl.test.acceptance.traceability;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.egl.test.acceptance.AcceptanceTestUtil;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.test.util.ModelWithEolAssertions;

public class EglFineGrainedTraceabilityAcceptanceTest {

	protected static ModelWithEolAssertions trace;
	
	protected static void generateTrace(String egl, EObject root) throws Exception {
		String s = AcceptanceTestUtil.run(egl, new InMemoryEmfModel("Ecore", EmfUtil.createResource(root), EcorePackage.eINSTANCE));
		System.out.println(s);
		trace = new ModelWithEolAssertions(AcceptanceTestUtil.getFineGrainedTrace());
		trace.setVariable("trace", "Trace.all.first");
	}
}
