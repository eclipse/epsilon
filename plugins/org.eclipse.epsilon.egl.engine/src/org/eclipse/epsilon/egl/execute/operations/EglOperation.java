/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.execute.operations;

import java.util.HashMap;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.egl.engine.traceability.fine.context.IEglContextWithFineGrainedTraceability;
import org.eclipse.epsilon.egl.engine.traceability.fine.context.IEglTraceabilityContext;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.annotations.EolAnnotationsUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolMap;

public class EglOperation extends EolOperation {

	public EglOperation(AST ast) {
		super(ast);
	}
	
	@Override
	protected Object executeBody(IEolContext context) throws EolRuntimeException {
		startUsingCustomDataFromTraceAnnotation(context);
		Object result = super.executeBody(context);
		stopUsingCustomDataFromTraceAnnotation(context);
		return result;
	}

	private void startUsingCustomDataFromTraceAnnotation(IEolContext context) throws EolRuntimeException {
		final Object traceAnnotationValues = EolAnnotationsUtil.getAnnotationValue(getAst(), "trace", context);
		
		if (traceAnnotationValues instanceof EolMap) {		
			getTraceabilityContext(context).setCustomDataForFutureTraceLinks(((EolMap)traceAnnotationValues));
		}
	}
	
	private void stopUsingCustomDataFromTraceAnnotation(IEolContext context) {
		getTraceabilityContext(context).setCustomDataForFutureTraceLinks(new HashMap<String, String>());
	}

	private IEglTraceabilityContext getTraceabilityContext(IEolContext context) {
		return ((IEglContextWithFineGrainedTraceability)context).getTraceabilityContext();
	}
}
