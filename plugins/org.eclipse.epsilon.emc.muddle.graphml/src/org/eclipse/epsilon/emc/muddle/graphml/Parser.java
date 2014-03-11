package org.eclipse.epsilon.emc.muddle.graphml;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
	
	public static void main(String[] args) {
		Parser parser = new Parser("(\\S+?)\\s+(\\S+)");
		System.err.println(parser.matches("Integer foo"));
		System.err.println(parser.getGroups());
	}
	
	protected String regex;
	protected Matcher matcher;
	
	public Parser(String regex) {
		this.regex = regex;
	}
	
	public boolean matches(String target) {
		Pattern p = Pattern.compile(regex);
		matcher = p.matcher(target);
		return matcher.find();
	}
	
	public List<String> getGroups() {
		List<String> groups = new ArrayList<String>();
		for (int i=1;i<=matcher.groupCount();i++) {
			groups.add(matcher.group(i));
		}
		return groups;
	}
	
}
