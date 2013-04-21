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
		EModelElement eModelElement = (EModelElement) target;
		EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		eAnnotation.setSource(annotation);
		eModelElement.getEAnnotations().add(eAnnotation);
		
		for (Object key : details.keySet()) {
			eAnnotation.getDetails().put(key + "", details.get(key) + "");
		}
		
		if (eModelElement instanceof EStructuralFeature) {
			return ((EStructuralFeature) eModelElement).getEContainingClass();
		}
		return eModelElement;
	}

	public EModelElement annotate(String annotation) {
		return annotate(annotation, new HashMap<Object, Object>());
	}
}
