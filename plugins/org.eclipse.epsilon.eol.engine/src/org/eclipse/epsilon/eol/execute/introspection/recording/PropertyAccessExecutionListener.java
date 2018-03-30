/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.introspection.recording;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.WeakHashMap;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.dom.AssignmentStatement;
import org.eclipse.epsilon.eol.dom.PropertyCallExpression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.control.IExecutionListener;

public class PropertyAccessExecutionListener implements IExecutionListener {

	private final Collection<IPropertyAccessRecorder> recorders = new LinkedList<>();
	private final WeakHashMap<ModuleElement, Object> cache = new WeakHashMap<>();
	
	public PropertyAccessExecutionListener(IPropertyAccessRecorder... recorders) {
		this.recorders.addAll(Arrays.asList(recorders));
	}
	
	@Override
	public void aboutToExecute(ModuleElement ast, IEolContext context) {}
	
	@Override
	public void finishedExecuting(ModuleElement ast, Object result, IEolContext context) {
		// When the left-hand side of a point expression has been executed, store the object on 
		// which the point expression was invoked, so that we can pass it to any property access recorders
		if (isLeftHandSideOfPointExpression(ast)) {
			cache.put(ast, result);
		}
		
		// When a property access is executed, notify the recorders
		if (isPropertyAccessExpression(ast)) {
			
			PropertyCallExpression propertyCallExpression = (PropertyCallExpression) ast;
			
			final Object modelElement = cache.get(propertyCallExpression.getTargetExpression());
			final String propertyName = propertyCallExpression.getPropertyNameExpression().getName();
			
			if (isModelBasedProperty(modelElement, propertyName, context)) {
				for (IPropertyAccessRecorder recorder : this.recorders) {
					recorder.record(modelElement, propertyName);
				}
			}
		}
	}
	
	@Override
	public void finishedExecutingWithException(ModuleElement ast, EolRuntimeException exception, IEolContext context) {}
	
	private boolean isLeftHandSideOfPointExpression(ModuleElement ast) {
		return ast.getParent() instanceof PropertyCallExpression && ((PropertyCallExpression)ast.getParent()).getTargetExpression() == ast;
	}
	
	private boolean isPropertyAccessExpression(ModuleElement ast) {
		return ast instanceof PropertyCallExpression &&          // AST is a point expression 
		       !isAssignee(ast);                            // AST is not the left-hand side of an assignment
	}
	
	// Determines whether a property access is model-based (and not, for example, for an extended property) 
	private boolean isModelBasedProperty(Object object, String property, IEolContext context) {
		return context.getIntrospectionManager().isModelBasedProperty(object, property, context);
	}
	
	// Determines whether the specified AST is the left-hand side of an assignment expression
	private boolean isAssignee(ModuleElement ast) {
		return ast.getParent() instanceof AssignmentStatement && 
				((AssignmentStatement) ast.getParent()).getTargetExpression() == ast;
	}
}
