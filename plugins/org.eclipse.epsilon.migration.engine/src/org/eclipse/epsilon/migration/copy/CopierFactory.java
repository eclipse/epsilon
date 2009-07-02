package org.eclipse.epsilon.migration.copy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;

public class CopierFactory {

	public Copier createCopier(EObject original, AbstractEmfModel targetModel) {
		return new Copier(original, targetModel);
	}
}
