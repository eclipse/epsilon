/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
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
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.eol.types.EolType;

public class PropertyCallExpression extends FeatureCallExpression {
	
	public PropertyCallExpression() {}
	
	public PropertyCallExpression(Expression targetExpression, NameExpression propertyNameExpression) {
		this.targetExpression = targetExpression;
		this.nameExpression = propertyNameExpression;
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		targetExpression = (Expression) module.createAst(cst.getFirstChild(), this);
		nameExpression = (NameExpression) module.createAst(cst.getSecondChild(), this);
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		return execute(context.getExecutorFactory().execute(targetExpression, context), nameExpression, context);
	}
	
	public Object execute(Object source, NameExpression propertyNameExpression, IEolContext context) throws EolRuntimeException {
		String propertyName = propertyNameExpression.getName();
		if (source == null) throw new EolRuntimeException("Called feature '" + propertyName + "' on undefined object", propertyNameExpression);

		IPropertyGetter getter = context.getIntrospectionManager().getPropertyGetterFor(source, propertyName, context);
		// Added support for properties on collections
		if (source instanceof Collection<?> && !getter.hasProperty(source, propertyName, context)) {
			EolSequence<Object> results = new EolSequence<>();
			results.ensureCapacity(((Collection<?>) source).size());
			for (Object content : (Collection<?>) source) {
				results.add(
					context.getIntrospectionManager().getPropertyGetterFor(content, propertyName, context)
						.invoke(content, propertyName, context)
				);
			}
			return results;
		}

		try {
			return wrap(getter.invoke(source, propertyName, context));
		}
		catch (EolRuntimeException eox) {
			if (eox.getAst() == null) {
				eox.setAst(this);
			}
			throw eox;
		}
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		targetExpression.compile(context);
		
		// Extended properties
		if (nameExpression.getName().startsWith("~")) {
			resolvedType = EolAnyType.Instance;
		}
		// e.g. EPackage.all
		else if (targetExpression instanceof NameExpression && ((NameExpression) targetExpression).isTypeName()) {
			if (((NameExpression) targetExpression).getResolvedType() instanceof EolModelElementType) {
				if (nameExpression.getName().equals("all") || nameExpression.getName().equals("allInstances")) {
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
				metaClass = ((EolModelElementType) type).getMetaClass();
			}
			else if (type instanceof EolCollectionType && ((EolCollectionType) type).getContentType() instanceof EolModelElementType) {
				metaClass = ((EolModelElementType)((EolCollectionType) type).getContentType()).getMetaClass();
				many = true;
			}
			
			if (metaClass != null) {
				StructuralFeature structuralFeature = metaClass.getStructuralFeature(nameExpression.getName());
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
					context.addWarningMarker(nameExpression, "Structural feature " + nameExpression.getName() + " not found in type " + metaClass.getName());
				}
			}
			
		}
	}
}
