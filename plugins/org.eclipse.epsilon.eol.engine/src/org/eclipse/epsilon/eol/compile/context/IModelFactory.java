package org.eclipse.epsilon.eol.compile.context;

import org.eclipse.epsilon.eol.models.IModel;

public interface IModelFactory {
	
	public IModel createModel(String driver);
	
}
