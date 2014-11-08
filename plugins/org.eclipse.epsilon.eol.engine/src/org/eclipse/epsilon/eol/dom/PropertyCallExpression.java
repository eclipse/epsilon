package org.eclipse.epsilon.eol.dom;

import java.util.Collection;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.types.EolSequence;

public class PropertyCallExpression extends FeatureCallExpression {
	
	public Object execute(IEolContext context, boolean returnSetter) throws EolRuntimeException {
		AST objectAst = getFirstChild();
		AST featureCallAst = objectAst.getNextSibling();
		Object source = context.getExecutorFactory().executeAST(objectAst, context);
		return execute(source, featureCallAst, context, returnSetter);
	}
	
	public Object execute(Object source, AST featureCallAst, IEolContext context, boolean returnSetter) throws EolRuntimeException {
		
		String propertyName = featureCallAst.getText();
		if (source == null) throw new EolRuntimeException("Called feature " + propertyName + " on undefined object", featureCallAst);
		
		if (returnSetter){
			IPropertySetter setter = context.getIntrospectionManager().getPropertySetterFor(source, propertyName, context);
			setter.setAst(featureCallAst);
			return setter;
		} else{
			IPropertyGetter getter = context.getIntrospectionManager().getPropertyGetterFor(source, propertyName, context);
			
			// Added support for properties on collections
			if (source instanceof Collection<?> && !getter.hasProperty(source, propertyName)) {
				EolSequence<Object> results = new EolSequence<Object>();
				for (Object content : ((Collection<?>) source)) {
					results.add(context.getIntrospectionManager().getPropertyGetterFor(content, propertyName, context).invoke(content, propertyName));
				}
				return results;
			}
			
			getter.setAst(featureCallAst);
			return wrap(getter.invoke(source, propertyName));
		}
		
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException{
		return execute(context, false);
	}
	
	
	
}
