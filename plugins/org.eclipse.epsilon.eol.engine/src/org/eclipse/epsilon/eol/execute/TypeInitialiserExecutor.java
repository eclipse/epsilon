package org.eclipse.epsilon.eol.execute;

import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;
import org.eclipse.epsilon.eol.types.EolType;

public abstract class TypeInitialiserExecutor extends AbstractExecutor {
	
	protected Object initialiseType(EolType type, AST parametersAst, IEolContext context, boolean createIfNonPrimitive) throws EolRuntimeException {
		
		if (type instanceof EolPrimitiveType || type instanceof EolCollectionType){
			return type.createInstance();
		}
		else if (createIfNonPrimitive) {
			
			if (type instanceof EolModelElementType && !((EolModelElementType) type).isInstantiable()) {
				EolModelElementType modelElementType = (EolModelElementType) type;
				throw new EolNotInstantiableModelElementTypeException(modelElementType);
			}
			
			if (parametersAst != null) {
				List<Object> parameters = (List<Object>) context.getExecutorFactory().executeAST(parametersAst, context);
				return type.createInstance(parameters);
			}
			else {
				return type.createInstance();
			}
		}
		return null;
	}
	
}
