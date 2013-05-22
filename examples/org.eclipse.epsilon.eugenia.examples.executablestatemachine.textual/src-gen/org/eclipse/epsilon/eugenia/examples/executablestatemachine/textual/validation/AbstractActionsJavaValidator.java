package org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public class AbstractActionsJavaValidator extends AbstractDeclarativeValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual.actions.ActionsPackage.eINSTANCE);
		return result;
	}

}
