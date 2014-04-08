package org.eclipse.epsilon.eol.parse;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.Token;
import org.eclipse.epsilon.common.parse.StaticFieldNameResolver;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.EolModule;

public class EolFormalParametersWorkbench {
	
	public static void main(String[] args) throws Exception {
		
		boolean newstyle = true;
		boolean oldstyle = true;
		boolean notypes = true;
		boolean checkreturn = true;
		
		String code = "";
		if (oldstyle) code += "fooOldStyle(2);"; 
		if (notypes) code += "fooNoTypes(3);";
		if (checkreturn) code += "return Foo!a#b;";
		if (newstyle) code += "fooNewStyle(1); operation fooNewStyle(Integer i) { i.println(); }";
		if (notypes) code += "operation fooNoTypes(i) { i.println(); }";
		if (oldstyle) code += "operation fooOldStyle(i : Integer) { i.println(); }";
		
		/*
		ANTLRInputStream input = new ANTLRInputStream(new StringBufferInputStream(code));
		EolLexer lexer = new EolLexer(input);
		
		
		Token t = lexer.nextToken();
		StaticFieldNameResolver r = new StaticFieldNameResolver(EolLexer.class);
		while (t.getText()!=null) {
			System.err.println(t.getText() + "->" + r.getField(t.getType()));
			t = lexer.nextToken();
		}
		
		if (1 > 0) return;
		*/
		
		EolModule m = new EolModule();
		
		m.parse(code);
		
		for (ParseProblem p : m.getParseProblems()) {
			System.err.println(p);
			System.err.println(m.getAst().toStringTree());
		}
		if (m.getParseProblems().size() == 0) {
			m.execute();
		}
	}
	
}
