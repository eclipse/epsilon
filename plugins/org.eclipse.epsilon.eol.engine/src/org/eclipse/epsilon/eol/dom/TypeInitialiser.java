package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;
import org.eclipse.epsilon.eol.types.EolType;

public abstract class TypeInitialiser extends Expression {
	
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
				//List<Object> parameters = (List<Object>) context.getExecutorFactory().executeAST(parametersAst, context);
				AST parameterAst = parametersAst.getFirstChild();
				ArrayList<Object> parameters = new ArrayList<Object>();
				
				while (parameterAst != null){
					parameters.add(context.getExecutorFactory().executeAST(parameterAst, context));
					parameterAst = parameterAst.getNextSibling();
				}
				
				return type.createInstance(parameters);
			}
			else {
				return type.createInstance();
			}
		}
		return null;
	}
}
