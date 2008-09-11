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
package org.eclipse.epsilon.eol.models.java;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class JavaWorkbench {
	
	public static void main(String[] args) throws Exception {
		new JavaWorkbench().work();
	}
	
	public void work() throws Exception {
		
		EolModule module = new EolModule();
		module.parse(new File(JavaWorkbench.class.getResource("TestJava.eol").toURI()));
		IEolContext context = module.getContext();
		context.setErrorStream(System.err);
		context.setOutputStream(System.out);
		
		Collection<Object> objects = new ArrayList();
		Collection<Class> classes = new ArrayList<Class>();
		classes.add(Tree.class);
		
		JavaModel javaModel = new JavaModel(objects, classes);
		javaModel.setName("Java");
		
		context.getModelRepository().addModel(javaModel);
		
		module.execute();
		
		
	}
}
