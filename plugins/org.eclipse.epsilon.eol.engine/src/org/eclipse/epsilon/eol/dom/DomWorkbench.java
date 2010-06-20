package org.eclipse.epsilon.eol.dom;

import java.io.File;
import java.io.FileInputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.parse.EpsilonTreeAdaptor;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.dom.print.DomElementPrinterFactory;
import org.eclipse.epsilon.eol.parse.EolLexer;
import org.eclipse.epsilon.eol.parse.EolParser;

public class DomWorkbench {
	
	public static void main(String[] args) throws Exception {
		new DomWorkbench().run();
	}
	
	public void run() throws Exception {
		
		File file = new File("/Users/dimitrioskolovos/Projects/Eclipse/3.5.1/Eclipse.app/Contents/MacOS/workspace/org.eclipse.epsilon.eol.engine/src/org/eclipse/epsilon/eol/dom/test.eol");
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(file));
		EolLexer lexer = new EolLexer(input);
		CommonTokenStream stream = new CommonTokenStream(lexer);
		EolParser parser = new EolParser(stream);
		EpsilonTreeAdaptor adaptor = new EpsilonTreeAdaptor(file);
		parser.setDeepTreeAdaptor(adaptor);
		
		AST ast = (AST) parser.eolModule().getTree();
		
		System.err.println(ast.toStringTree());
		
		DomElementFactory factory = new DomElementFactory();
		
		DomElement de = factory.createDomElement(ast);
		
		System.err.println(new DomElementPrinterFactory().print(de));
		
	}
	
}
