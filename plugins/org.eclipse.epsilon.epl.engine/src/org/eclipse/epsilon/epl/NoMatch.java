package org.eclipse.epsilon.epl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.eol.execute.introspection.IUndefined;

public class NoMatch implements IUndefined {
	
	private NoMatch(){}
	
	public static NoMatch INSTANCE = new NoMatch();
	protected static ArrayList<Object> list = null; 
	
	public static List<Object> asList() {
		if (list == null) {
			list = new ArrayList<Object>();
			list.add(INSTANCE);
		}
		return list;
	}
}
