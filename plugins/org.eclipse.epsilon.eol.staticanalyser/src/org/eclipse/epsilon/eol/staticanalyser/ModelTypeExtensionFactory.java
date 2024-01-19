package org.eclipse.epsilon.eol.staticanalyser;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.common.dt.launching.extensions.ModelTypeExtension;
import org.eclipse.epsilon.eol.models.IModel;

public class ModelTypeExtensionFactory implements IModelFactory {

	@Override
	public IModel createModel(String driver) {
		IModel model = null ;
		try {
			model = ModelTypeExtension.forType(driver).createModel();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}

}
