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
package org.eclipse.epsilon.ecl.trace;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.ecl.MatchRule;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class MatchTrace {
	
	protected List<Match> matches = new ArrayList();
	
	public MatchTrace getReduced() { 
		MatchTrace reduced = new MatchTrace();
		for (Match match : matches) {
			if (match.isMatching()) {
				reduced.getMatches().add(match);
			}
		}
		return reduced;
	}
	
	public MatchTrace(){
		
	}
	
	public MatchTrace(MatchTrace copy){
		this.getMatches().addAll(copy.getMatches());
	}
	
	public Match add(Object left, Object right, boolean matching, MatchRule rule){
		Match match = createMatch(left,right,matching);
		match.setRule(rule);
		getMatches().add(match);
		return match;
	}
	
	public Match getMatch(Object left, Object right){
		for (Match match : this.getMatches()) {
			if (match.contains(left,right)){
					return match;
			}
		}
		return null;
	}
	
	public List getMatches(Object object){
		ArrayList matches = new ArrayList();
		for (Match match : this.getMatches()) {
			if (match.contains(object) && match.isMatching()){
				matches.add(match);
			}
		}
		return matches;
	}
	
	public Match getMatch(Object object){
		for (Match match : this.getMatches()) {
			if (match.contains(object) && match.isMatching()){
				return match;
			}
		}
		return null;
	}
	
	public Match getMatch(Object left, MatchRule rule) {
		for (Match match : this.getMatches()) {
			if (match.isMatching() && match.left == left && match.getRule() == rule) {
				return match;
			}
		}
		return null;
	}
	
	public boolean hasBeenMatched(Object object){
		for (Match match : this.getMatches()) {
			if (match.contains(object)){
				return true;
			}
		}
		return false;
	}
	
	public Match createMatch(Object left, Object right, boolean matching) {
		return new Match(left, right, matching);
	}
	
	public String toString(IEolContext context){
		String str = "";
		
		for (Match match : this.getMatches()) {
			str += "[" + match.isMatching() + "]\n";
			str += context.getPrettyPrinterManager().toString(match.getLeft());
			str += "\n ->" + context.getPrettyPrinterManager().toString(match.getRight());
		}
		str += "-------------------------------------------";
		
		return str;
	}

	public List<Match> getMatches() {
		return matches;
	}
	
	
}
