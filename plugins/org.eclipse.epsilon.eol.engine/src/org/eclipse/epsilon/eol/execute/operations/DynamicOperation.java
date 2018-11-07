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
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationException;
import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationParametersException;
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
		
		Method[] candidates = ReflectionUtil.getMethodsForName(target, methodName);
		
		final Method candidate = Stream.of(candidates)
			.filter(method -> method.getParameterCount() == expressions.size())
			.filter(method -> Stream.of(method.getParameterTypes())
					.filter(Class::isInterface)
					.map(Class::getMethods)
					.flatMap(Stream::of)
					.filter(targetParamMethod ->
						Modifier.isAbstract(targetParamMethod.getModifiers()) &&
						targetParamMethod.getParameterCount() == iteratorParams.size()
					)
					.count() == 1
			)
			.findAny()
			.<EolRuntimeException> orElseThrow(() -> {
				Collector<CharSequence, ?, String> paramJoiner = Collectors.joining(", ");
				
				if (candidates.length > 0) {
					String expectedParams = Stream.of(candidates[0].getParameterTypes())
						.map(Class::getTypeName)
						.collect(paramJoiner);
					
					String actualParams = expressions.stream()
						.map(expr -> expr.getClass().getTypeName())
						.collect(paramJoiner);
					
					return new EolIllegalOperationParametersException(methodName, expectedParams, actualParams, ast);
				}
				else return new EolIllegalOperationException(target, methodName, ast, context.getPrettyPrinterManager());
			});
		
		final int candidateParamCount = candidate.getParameterCount();
		assert candidateParamCount == expressions.size();
		final Object[] candidateParameterValues = new Object[candidateParamCount];
		final java.lang.reflect.Parameter[] candidateParameterTypes = candidate.getParameters();
		
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
			candidate.setAccessible(true);
			return candidate.invoke(target, candidateParameterValues);
		}
		catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
			throw new EolRuntimeException(ex);
		}
	}

}
