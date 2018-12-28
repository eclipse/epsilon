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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.Arrays;
import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.function.LambdaFactory;
import org.eclipse.epsilon.eol.types.EolNoType;
import org.eclipse.epsilon.eol.util.ReflectionUtil;

/**
 * Provides a bridge between EOL first-order syntax and Java lambdas
 * (i.e. {@linkplain FunctionalInterface}s).
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class DynamicOperation extends AbstractOperation {
	
	@Override
	public Object execute(Object target, NameExpression operationNameExpression, List<Parameter> iterators, List<Expression> expressions, IEolContext context) throws EolRuntimeException {
		assert expressions != null && !expressions.isEmpty();
		
		final String methodName = operationNameExpression.getName();
		final List<Parameter> iteratorParams;
		
		if (iterators.size() == 1 && StringUtil.isOneOf(iterators.get(0).getName(), "null", "_"))
			iteratorParams = Collections.emptyList();
		else
			iteratorParams = iterators;
		
		if (target instanceof EolNoType || target instanceof LambdaFactory || target == null) {
			return LambdaFactory.resolveFor(methodName, iteratorParams, expressions.get(0), operationNameExpression, context);
		}
		
		// Look for a matching method with FunctionalInterface parameter(s)
		Predicate<Method> criteria = method ->
			//method.isAccessible() && TODO: get this working for Java 9+
			method.getParameterCount() == expressions.size() &&
			Arrays.stream(method.getParameterTypes())
				.filter(Class::isInterface)
				.allMatch(intf -> Arrays.stream(intf.getAnnotations())
						.anyMatch(a -> a.annotationType().getSimpleName().equals("FunctionalInterface")) ||
					Arrays.stream(intf.getMethods())
					.filter(targetParamMethod ->
						Modifier.isAbstract(targetParamMethod.getModifiers())
					)
					.count() == 1
				);
		
		final Method resolvedMethod = ReflectionUtil.findApplicableMethodOrThrow(
			target, methodName, criteria, expressions.stream(), operationNameExpression, context.getPrettyPrinterManager()
		);
		
		final int candidateParamCount = resolvedMethod.getParameterCount();
		final Object[] candidateParameterValues = new Object[candidateParamCount];
		final java.lang.reflect.Parameter[] candidateParameterTypes = resolvedMethod.getParameters();
		
		for (int i = 0; i < candidateParamCount; i++) {
			final Class<?> targetType = candidateParameterTypes[i].getType();
			final Expression eolExpression = expressions.get(i);
			
			if (!targetType.isInterface()) {
				candidateParameterValues[i] = eolExpression.execute(context);
				continue;
			}
			
			try {
				// First try to use the CheckedEol version of known functional interfaces
				candidateParameterValues[i] = LambdaFactory.resolveFor(targetType, iterators, eolExpression, operationNameExpression, context);
			}
			catch (EolIllegalOperationException eox) {
				// Failing that, try to implement the interface
				candidateParameterValues[i] = Proxy.newProxyInstance(
					targetType.getClassLoader(),
					new Class[]{targetType},
					(proxy, method, args) ->
						LambdaFactory.executeExpression(context, operationNameExpression, null, eolExpression, iteratorParams, args)
				);
			}
		}
		
		// Finally, call the method with the resolved parameters
		try {
			resolvedMethod.setAccessible(true);	// TODO: Illegal reflective access from Java 9+
			return resolvedMethod.invoke(target, candidateParameterValues);
		}
		catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
			throw new EolRuntimeException(ex);
		}
	}

}
