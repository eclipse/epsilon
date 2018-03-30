package org.eclipse.epsilon.eol.dom;

import java.util.Collection;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.compile.m3.MetaClass;
import org.eclipse.epsilon.eol.compile.m3.StructuralFeature;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolCollectionType;
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
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		targetExpression = (Expression) module.createAst(cst.getFirstChild(), this);
		propertyNameExpression = (NameExpression) module.createAst(cst.getSecondChild(), this);
	}
	
	public Object execute(IEolContext context, boolean returnSetter) throws EolRuntimeException {
		Object source = context.getExecutorFactory().execute(targetExpression, context);
		return execute(source, propertyNameExpression, context, returnSetter);
	}
	
	public Object execute(Object source, NameExpression propertyNameExpression, IEolContext context, boolean returnSetter) throws EolRuntimeException {
		String propertyName = propertyNameExpression.getName();
		if (source == null) throw new EolRuntimeException("Called feature " + propertyName + " on undefined object", propertyNameExpression);
		
		if (returnSetter) {
			IPropertySetter setter = context.getIntrospectionManager().getPropertySetterFor(source, propertyName, context);
			setter.setAst(propertyNameExpression);
			return setter;
		}
		else {
			IPropertyGetter getter = context.getIntrospectionManager().getPropertyGetterFor(source, propertyName, context);
			
			// Added support for properties on collections
			if (source instanceof Collection<?> && !getter.hasProperty(source, propertyName)) {
				EolSequence<Object> results = new EolSequence<>();
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
	public Object execute(IEolContext context) throws EolRuntimeException {
		return execute(context, false);
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		targetExpression.compile(context);
		
		// Extended properties
		if (propertyNameExpression.getName().startsWith("~")) {
			resolvedType = EolAnyType.Instance;
		}
		// e.g. EPackage.all
		else if (targetExpression instanceof NameExpression && ((NameExpression) targetExpression).isTypeName()) {
			if (((NameExpression) targetExpression).getResolvedType() instanceof EolModelElementType) {
				if (propertyNameExpression.getName().equals("all") || propertyNameExpression.getName().equals("allInstances")) {
					resolvedType = new EolCollectionType("Sequence", targetExpression.getResolvedType());
				}
			}
		}
		// Regular properties
		else {
			EolType type = targetExpression.getResolvedType();
			
			boolean many = false;
			MetaClass metaClass = null;
			if (type instanceof EolModelElementType && ((EolModelElementType) type).getMetaClass() != null) {
				metaClass = (MetaClass) ((EolModelElementType) type).getMetaClass();
			}
			else if (type instanceof EolCollectionType && ((EolCollectionType) type).getContentType() instanceof EolModelElementType) {
				metaClass = ((EolModelElementType)((EolCollectionType) type).getContentType()).getMetaClass();
				many = true;
			}
			
			if (metaClass != null) {
				StructuralFeature structuralFeature = metaClass.getStructuralFeature(propertyNameExpression.getName());
				if (structuralFeature != null) {
					if (structuralFeature.isMany()) {
						EolCollectionType collectionType = null;
						if (structuralFeature.isOrdered()) {
							if (structuralFeature.isUnique())
								collectionType = new EolCollectionType("OrderedSet");
							else
								collectionType = new EolCollectionType("Sequence");
						}
						else {
							if (structuralFeature.isUnique())
								collectionType = new EolCollectionType("Set");
							else
								collectionType = new EolCollectionType("Bag");
						}
						collectionType.setContentType(structuralFeature.getType());
						resolvedType = collectionType;
					}
					else {
						resolvedType = structuralFeature.getType();
					}
					if (many) {
						resolvedType = new EolCollectionType("Sequence", resolvedType);
					}
				}
				else {
					context.addWarningMarker(propertyNameExpression, "Structural feature " + propertyNameExpression.getName() + " not found in type " + metaClass.getName());
				}
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
