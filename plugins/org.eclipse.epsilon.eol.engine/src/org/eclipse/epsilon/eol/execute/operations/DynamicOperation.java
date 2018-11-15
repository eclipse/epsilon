/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.execute.operations;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.util.ReflectionUtil;

/**
 * Provides a bridge between EOL first-order syntax and Java lambdas
 * (i.e. {@linkplain FunctionalInterface}s).
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class DynamicOperation extends AbstractOperation {

	final ModuleElement ast;
	
	public DynamicOperation(ModuleElement caller) {
		this.ast = caller;
	}
	
	@Override
	public Object execute(Object target, NameExpression operationNameExpression, List<Parameter> iterators, List<Expression> expressions, IEolContext context) throws EolRuntimeException {
		
		final String methodName = operationNameExpression.getName();
		
		final List<Parameter> iteratorParams;
		
		if (iterators.size() == 1 && StringUtil.isOneOf(iterators.get(0).getName(), "null", "_"))
			iteratorParams = Collections.emptyList();
		else
			iteratorParams = iterators;
		
		Predicate<Method> criteria = method ->
			//method.isAccessible() && TODO: get this working for Java 9+
			method.getParameterCount() == expressions.size() &&
			Stream.of(method.getParameterTypes())
				.filter(Class::isInterface)
				.map(Class::getMethods)
				.flatMap(Stream::of)
				.filter(targetParamMethod ->
					Modifier.isAbstract(targetParamMethod.getModifiers()) &&
					targetParamMethod.getParameterCount() == iteratorParams.size()
				)
				.count() == 1;
		
		final Method resolvedMethod = ReflectionUtil.findApplicableMethodOrThrow(
			target, methodName, criteria, expressions.stream(), ast, context.getPrettyPrinterManager()
		);
		
		final int candidateParamCount = resolvedMethod.getParameterCount();
		assert candidateParamCount == expressions.size();
		final Object[] candidateParameterValues = new Object[candidateParamCount];
		final java.lang.reflect.Parameter[] candidateParameterTypes = resolvedMethod.getParameters();
		
		for (int i = 0; i < candidateParamCount; i++) {
			Class<?> targetType = candidateParameterTypes[i].getType();
			Expression eolExpression = expressions.get(i);
			
			candidateParameterValues[i] = Proxy.newProxyInstance(targetType.getClassLoader(), new Class[]{targetType}, new InvocationHandler() {
				
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					FrameStack scope = context.getFrameStack();
					scope.enterLocal(FrameType.UNPROTECTED, eolExpression);
	
					if (args != null) {
						assert iteratorParams.size() == args.length;
						
						Iterator<Parameter> eolParamsIter = iteratorParams.iterator();
						for (Object arg : args) {
							scope.put(eolParamsIter.next().getName(), arg);
						}
					}
					
					Object result = context.getExecutorFactory().execute(eolExpression, context);
					scope.leaveLocal(eolExpression);
					return result;
				}
			});
		}
		
		
		try {
			resolvedMethod.setAccessible(true);	// TODO: Illegal reflective access from Java 9+
			return resolvedMethod.invoke(target, candidateParameterValues);
		}
		catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
			throw new EolRuntimeException(ex);
		}
	}

}
