package org.eclipse.epsilon.eugenia.operationcontributors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.types.EolNoType.EolNoTypeInstance;

public class ContextlessOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target instanceof EolNoTypeInstance;
	}
	
	public Object _class(String name) throws Exception {
		IModel ecoreModel = context.getModelRepository().getModelByName("Ecore");
		for (Object o : ecoreModel.getAllOfType("EClass")) {
			if (((EClass) o).getName().equals(name)) {
				return o;
			}
		}
		throw new EolRuntimeException("Class " + name + " not found in the Ecore metamodel");
	}

}
