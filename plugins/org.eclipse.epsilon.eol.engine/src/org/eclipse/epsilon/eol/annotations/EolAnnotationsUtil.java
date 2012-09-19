/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.annotations;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.parse.EolParser;


public class EolAnnotationsUtil {
	
	public static void assignAnnotations(AST ast) {
		List<AST> children = AstUtil.getChildren(ast);
		for (AST child : children) {
			//if (children.indexOf(child) < children.size() - 1) {
				if (child.getType() == EolParser.ANNOTATIONBLOCK) {
					
					AST target = null;
					
					//HACK to support main-less EOL programs
					if (child.getNextSibling() != null) {
						if (child.getNextSibling().getType() != EolParser.BLOCK) {
							target = child.getNextSibling();
						}
						else if (child.getNextSibling().getNextSibling() != null) {
							target = child.getNextSibling().getNextSibling();
						}
					}
					
					if (target != null) {
						target.setAnnotationsAst(child);
					}
					
					//((EolAst) children.get(children.indexOf(child) + 1)).
					//	setAnnotationsAst(child);
				} else {
					EolAnnotationsUtil.assignAnnotations(child);
				}
			//}
		}
	}
	
	public static boolean getBooleanAnnotationValue(AST ast, String name, IEolContext context) throws EolRuntimeException {
		return getBooleanAnnotationValue(ast, name, context, false, true);
	}
	
	public static boolean getBooleanAnnotationValue(AST ast, String name, IEolContext context, boolean ifNotExists, boolean ifNoValue) throws EolRuntimeException {
		IEolAnnotation lazyAnnotation = EolAnnotationsUtil.getAnnotation(ast, name);
		if (lazyAnnotation == null) return ifNotExists;
		if (!lazyAnnotation.hasValue()) return ifNoValue;
		
		Object result = lazyAnnotation.getValue(context);
		try {
			boolean lazy = new Boolean(result.toString());
			return lazy;
		}
		catch (Exception ex) {
			throw new EolIllegalReturnException("Boolean", result, lazyAnnotation.getAst(), context);
		}
	}
	
	public static boolean hasAnnotation(AST ast, String name) {
		return !getAnnotations(ast,name).isEmpty();
	}
	
	public static IEolAnnotation getAnnotation(AST ast, String name) {
		List<IEolAnnotation> annotations = getAnnotations(ast, name);
		if (annotations.isEmpty()) {
			return null;
		}
		else {
			return annotations.get(0);
		}
	}
	
	public static List<IEolAnnotation> getAnnotations(AST ast) {
		return getAnnotations(ast, null);
	}
	
	public static List<IEolAnnotation> getAnnotations(AST ast, String name) {
		List<IEolAnnotation> allAnnotations = new ArrayList<IEolAnnotation>();
		List<IEolAnnotation> annotations = new ArrayList<IEolAnnotation>();
		
		AST annotationsAst = ast.getAnnotationsAst();
		if (annotationsAst != null) {
			for (AST annotationAst : AstUtil.getChildren(annotationsAst)) {
				if (annotationAst.getType() == EolParser.EXECUTABLEANNOTATION) {
					allAnnotations.add(new EolExecutableAnnotation(annotationAst));
				}
				else {
					allAnnotations.addAll(EolSimpleAnnotationFactory.createSimpleAnnotations(annotationAst));	
				}
			}
			if (name == null) return allAnnotations;
			for (IEolAnnotation annotation : allAnnotations) {
				if (annotation.getName().equals(name)) {
					annotations.add(annotation);
				}
			}
		}
		
		return annotations;
	}
	
	public static List<Object> getAnnotationsValues(AST ast, String name, IEolContext context) throws EolRuntimeException {
		List<Object> values = new ArrayList<Object>();
		for (IEolAnnotation annotation : getAnnotations(ast, name)) {
			values.add(annotation.getValue(context));
		}
		return values;
	}
	
	public static Object getAnnotationValue(AST ast, String name, IEolContext context) throws EolRuntimeException {
		List<Object> values = getAnnotationsValues(ast, name, context);
		if (values.isEmpty()) return null;
		return values.get(0);
	}
	
}
