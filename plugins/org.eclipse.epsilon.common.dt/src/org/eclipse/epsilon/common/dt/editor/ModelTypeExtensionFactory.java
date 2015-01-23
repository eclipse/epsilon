package org.eclipse.epsilon.common.dt.editor;

import org.eclipse.epsilon.common.dt.launching.extensions.ModelTypeExtension;
import org.eclipse.epsilon.eol.compile.context.IModelFactory;
import org.eclipse.epsilon.eol.models.IModel;

public class ModelTypeExtensionFactory implements IModelFactory {

	@Override
	public IModel createModel(String driver) {
		try {
			return ModelTypeExtension.forType(driver).createModel();
		} catch (Exception e) {
			return null;
		}
	}

}