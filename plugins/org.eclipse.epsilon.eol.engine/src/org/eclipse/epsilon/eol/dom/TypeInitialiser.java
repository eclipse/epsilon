package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolMapType;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;
import org.eclipse.epsilon.eol.types.EolType;

public abstract class TypeInitialiser extends Expression {
	
	protected Object initialiseType(EolType type, List<Expression> parameters, IEolContext context, boolean createIfNonPrimitive) throws EolRuntimeException {
		
		if (type instanceof EolPrimitiveType || type instanceof EolCollectionType || type instanceof EolMapType) {
			return type.createInstance();
		}
		else if (createIfNonPrimitive) {
			
			if (type instanceof EolModelElementType && !((EolModelElementType) type).isInstantiable()) {
				EolModelElementType modelElementType = (EolModelElementType) type;
				throw new EolNotInstantiableModelElementTypeException(modelElementType);
			}
							
			ArrayList<Object> parameterValues = new ArrayList<>();
			for (Expression parameter : parameters) {
				if (!(parameter.getClass() == EqualsOperatorExpression.class)) {
					parameterValues.add(context.getExecutorFactory().execute(parameter, context));
				}
			}
			
			Object instance = null;
			
			if (parameterValues.isEmpty()) {
				instance = type.createInstance();
			}
			else {
				instance = type.createInstance(parameterValues);
			}
			
			for (Expression parameter : parameters) {
				if (parameter.getClass() == EqualsOperatorExpression.class) {
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
			}
			
			return instance;
				
		}
		return null;
	}
	
}
