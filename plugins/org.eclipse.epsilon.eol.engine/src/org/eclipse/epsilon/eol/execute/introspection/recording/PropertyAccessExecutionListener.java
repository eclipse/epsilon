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

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.PropertyCallExpression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.control.IExecutionListener;
import org.eclipse.epsilon.eol.parse.EolParser;

public class PropertyAccessExecutionListener implements IExecutionListener {

	private final Collection<IPropertyAccessRecorder> recorders = new LinkedList<IPropertyAccessRecorder>();
	private final WeakHashMap<AST, Object> cache = new WeakHashMap<AST, Object>();
	
	public PropertyAccessExecutionListener(IPropertyAccessRecorder... recorders) {
		this.recorders.addAll(Arrays.asList(recorders));
	}
	
	@Override
	public void aboutToExecute(AST ast, IEolContext context) {}
	
	@Override
	public void finishedExecuting(AST ast, Object result, IEolContext context) {
		// When the left-hand side of a point expression has been executed, store the object on 
		// which the point expression was invoked, so that we can pass it to any property access recorders
		if (isLeftHandSideOfPointExpression(ast)) {
			cache.put(ast, result);
		}
		
		// When a property access is executed, notify the recorders
		if (isPropertyAccessExpression(ast)) {
			
			final Object modelElement = cache.get(ast.getFirstChild());
			final String propertyName = ast.getSecondChild().getText();
			
			if (isModelBasedProperty(modelElement, propertyName, context)) {
				for (IPropertyAccessRecorder recorder : this.recorders) {
					recorder.record(modelElement, propertyName);
				}
			}
		}
	}
	
	@Override
	public void finishedExecutingWithException(AST ast, EolRuntimeException exception, IEolContext context) {}
	
	private boolean isLeftHandSideOfPointExpression(AST ast) {
		return ast.getParent() instanceof PropertyCallExpression && ast.getParent().getFirstChild() == ast;
	}
	
	private boolean isPropertyAccessExpression(AST ast) {
		return ast.getType() == EolParser.POINT &&          // AST is a point expression  
		       ast.getSecondChild().getChildCount() == 0 && // AST's right-hand side is not a method call
		       !isAssignee(ast);                            // AST is not the left-hand side of an assignment
	}
	
	// Determines whether a property access is model-based (and not, for example, for an extended property) 
	private boolean isModelBasedProperty(Object object, String property, IEolContext context) {
		return context.getIntrospectionManager().isModelBasedProperty(object, property, context);
	}
	
	// Determines whether the specified AST is the left-hand side of an assignment expression
	private boolean isAssignee(AST ast) {
		return ast.getParent().getType() == EolParser.ASSIGNMENT &&
			   ast.getParent().getFirstChild() == ast;
	}
}
