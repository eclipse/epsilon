package org.eclipse.epsilon.eol.dom;

import java.util.Collection;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.compile.m3.MetaClass;
import org.eclipse.epsilon.eol.compile.m3.StructuralFeature;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.eol.types.EolType;

public class PropertyCallExpression extends FeatureCallExpression {
	
	protected NameExpression propertyNameExpression;
	
	public PropertyCallExpression() {}
	
	public PropertyCallExpression(Expression targetExpression, NameExpression propertyNameExpression) {
		this.targetExpression = targetExpression;
		this.propertyNameExpression = propertyNameExpression;
	}
	
	@Override
	public void build() {
		super.build();
		targetExpression = (Expression) getFirstChild();
		propertyNameExpression = (NameExpression) getSecondChild();
	}
	
	public Object execute(IEolContext context, boolean returnSetter) throws EolRuntimeException {
		AST targetExpression = getFirstChild();
		Object source = context.getExecutorFactory().executeAST(targetExpression, context);
		return execute(source, propertyNameExpression, context, returnSetter);
	}
	
	public Object execute(Object source, NameExpression propertyNameExpression, IEolContext context, boolean returnSetter) throws EolRuntimeException {
		
		String propertyName = propertyNameExpression.getName();
		if (source == null) throw new EolRuntimeException("Called feature " + propertyName + " on undefined object", propertyNameExpression);
		
		if (returnSetter){
			IPropertySetter setter = context.getIntrospectionManager().getPropertySetterFor(source, propertyName, context);
			setter.setAst(propertyNameExpression);
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
			
			getter.setAst(propertyNameExpression);
			return wrap(getter.invoke(source, propertyName));
		}
		
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException{
		return execute(context, false);
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		// TODO Auto-generated method stub
		targetExpression.compile(context);
		EolType type = targetExpression.getResolvedType();
		if (type instanceof EolModelElementType && ((EolModelElementType) type).getMetaClass() != null) {
			MetaClass metaClass = (MetaClass) ((EolModelElementType) type).getMetaClass();
			StructuralFeature structuralFeature = metaClass.getStructuralFeature(propertyNameExpression.getName());
			if (structuralFeature == null) {
				context.addWarningMarker(propertyNameExpression, "Structural feature " + propertyNameExpression.getName() + " not found in type " + metaClass.getName());
			}
			else {
				
			}
		}
	}
	
	public NameExpression getPropertyNameExpression() {
		return propertyNameExpression;
	}
	
	public void setPropertyNameExpression(NameExpression propertyNameExpression) {
		this.propertyNameExpression = propertyNameExpression;
	}
	
}
