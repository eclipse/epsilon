/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.workbench;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ListIterator;

import javax.swing.UIManager;

import org.eclipse.epsilon.commons.parse.EpsilonTreeAdaptor;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.egl.execute.EglExecutorFactory;
import org.eclipse.epsilon.egl.execute.context.EglContext;
import org.eclipse.epsilon.egl.output.OutputBuffer;
import org.eclipse.epsilon.egl.parse.EglLexer;
import org.eclipse.epsilon.egl.parse.EglParser;
import org.eclipse.epsilon.egl.parse.problem.EglParseProblem;
import org.eclipse.epsilon.egl.preprocessor.Preprocessor;
import org.eclipse.epsilon.egl.template.FileGeneratingTemplateFactory;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.execute.context.Variable;

public class Workbench {
	
	private static final String EGL_FILE = "test.egl";
	
	public static void main(String[] args) throws Exception{
		
		try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		File f = new File(Workbench.class.getResource(EGL_FILE).toURI());
		//InputStream i = Workbench.class.getResourceAsStream("Uml2Java.egl");		
		
		EglLexer lexer = new EglLexer(new FileInputStream(f)); 
		    
		//Token token;
		
		//while ((token = lexer.nextToken()) != null){
		//	System.out.println(token.toString());
		//}
		
		EglParser parser = new EglParser(lexer, new EpsilonTreeAdaptor(f));
		parser.parse();
		
		Preprocessor preprocessor = new Preprocessor();
		String eol = preprocessor.convertToEol(parser.getAST());
		
	    System.out.println(eol);
	    System.out.println(preprocessor.getTrace());
		
	    //if (1>0) return;
	    
		//new ASTViewer(parser.getAST());
		
		IEolModule eolModule = new EolModule();
		OutputBuffer out = new OutputBuffer(new EglContext());
		eolModule.getContext().getFrameStack().put(Variable.createReadOnlyVariable("out", out));
		eolModule.getContext().getFrameStack().put(Variable.createReadOnlyVariable("TemplateFactory", new FileGeneratingTemplateFactory(new EglContext())));
		
		eolModule.getContext().setExecutorFactory(new EglExecutorFactory());
		
		//TestModelFactory tmf = new TestModelFactory();
		//xolEngine.getContext().getModelRepository().addModel(tmf.getModel("EducationalPerspective", "UML"));
		//eolModule.getContext().getModelRepository().addModel(tmf.getMetaModel("UML", "MOF"));
		//eolModule.getContext().getModelRepository().addModel(tmf.getModel("EducationalPerspective", "Uml"));
		
		boolean ok = eolModule.parse(eol);
		
		if (!ok){
			ListIterator li = eolModule.getParseProblems().listIterator();
			while (li.hasNext()){
				ParseProblem anomaly = (ParseProblem) li.next();
				System.err.println(
						new EglParseProblem(anomaly, preprocessor.getTrace()).toString()
				);
			}
			return;
		}
		
		eolModule.execute();
	
		
		System.out.println(out);
		
		}
		catch (IOException tex){
			tex.printStackTrace();
		}
		
	}
	
}
