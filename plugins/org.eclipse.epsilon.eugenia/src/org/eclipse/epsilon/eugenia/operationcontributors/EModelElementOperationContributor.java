/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eugenia.operationcontributors;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;

public class EModelElementOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target instanceof EModelElement;
	}
	
	public EModelElement annotate(String annotation, Map<?,?> details) {
		EModelElement eModelElement = (EModelElement) getTarget();
		EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		eAnnotation.setSource(annotation);
		eModelElement.getEAnnotations().add(eAnnotation);
		
		for (Map.Entry<?, ?> entry : details.entrySet()) {
			eAnnotation.getDetails().put(entry.getKey() + "", entry.getValue() + "");
		}
		
		if (eModelElement instanceof EStructuralFeature) {
			return ((EStructuralFeature) eModelElement).getEContainingClass();
		}
		return eModelElement;
	}

	public EModelElement annotate(String annotation) {
		return annotate(annotation, new HashMap<>());
	}
}
