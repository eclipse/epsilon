package org.eclipse.epsilon.eol.parse;

import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.EolModule;

public class EolVariablesWorkbench {
	
	public static void main(String[] args) throws Exception {
		
		boolean oldstyle = true;
		boolean newstyle = true;
		boolean notype = true;
		String code = "";
		
		if (oldstyle) code += "var i : Integer;";
		if (newstyle) code += "Integer j = 5;";
		if (notype) code += "var a;";
		if (oldstyle) code += "i.println();";
		if (newstyle) code += "j.println();";
		
		EolModule m = new EolModule();
		
		m.parse(code);
		
		for (ParseProblem p : m.getParseProblems()) {
			System.err.println(p);
		}
		if (m.getParseProblems().size() == 0) {
			m.execute();
		}
	}
	
}
