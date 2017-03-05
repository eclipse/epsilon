package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolMapType;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;
import org.eclipse.epsilon.eol.types.EolType;

public abstract class TypeInitialiser extends Expression {
	
	protected Object initialiseType(EolType type, List<Expression> parameters, IEolContext context, boolean createIfNonPrimitive) throws EolRuntimeException {
		
		if (type instanceof EolPrimitiveType || type instanceof EolCollectionType || type instanceof EolMapType){
			return type.createInstance();
		}
		else if (createIfNonPrimitive) {
			
			if (type instanceof EolModelElementType && !((EolModelElementType) type).isInstantiable()) {
				EolModelElementType modelElementType = (EolModelElementType) type;
				throw new EolNotInstantiableModelElementTypeException(modelElementType);
			}
			
			if (type instanceof EolModelElementType) {
				
				Object instance = type.createInstance();
				
				for (Expression parameter : parameters) {
					if (parameter instanceof EqualsOperatorExpression) {
						EqualsOperatorExpression equalsOperatorExpression = (EqualsOperatorExpression) parameter;
						if (equalsOperatorExpression.getFirstOperand() instanceof NameExpression) {
							String property = ((NameExpression) equalsOperatorExpression.getFirstOperand()).getName();
							IPropertySetter setter = context.getIntrospectionManager().getPropertySetterFor(instance, property, context);
							if (setter != null) {
								setter.setAst(parameter);
								setter.invoke(context.getExecutorFactory().execute(equalsOperatorExpression.getSecondOperand(), context));
							}
							else throw new EolIllegalPropertyException(instance, property, equalsOperatorExpression.getFirstOperand(), context);
						}
						else {
							throw new EolRuntimeException("Property name expected", equalsOperatorExpression.getFirstOperand());
						}
					}
					else {
						throw new EolRuntimeException("Property initialisation expression expected", parameter);
					}
				}
				
				return instance;
				
			}
			else {
				if (!parameters.isEmpty()) {
					ArrayList<Object> parameterValues = new ArrayList<Object>();
					for (Expression parameter : parameters) {
						parameterValues.add(context.getExecutorFactory().execute(parameter, context));
					}
					return type.createInstance(parameterValues);
				}
				else {
					return type.createInstance();
				}
			}
		}
		return null;
	}
	
	protected IModel getModelThatKnowsAboutProperty(Object instance, String property, IEolContext context) {
		for (IModel model : context.getModelRepository().getModels()) {
			if (model.knowsAboutProperty(instance, property)) {
				return model;
			}
		}
		return null;
	}
	
}
