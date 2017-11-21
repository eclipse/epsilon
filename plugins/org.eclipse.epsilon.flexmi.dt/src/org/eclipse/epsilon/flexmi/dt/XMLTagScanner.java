package org.eclipse.epsilon.flexmi.dt;

import org.eclipse.jface.text.*;
import org.eclipse.jface.text.rules.*;

public class XMLTagScanner extends RuleBasedScanner {

	public XMLTagScanner(ColorManager manager) {
		IToken string =
			new Token(
				new TextAttribute(manager.getColor(IXMLColorConstants.STRING)));
		IToken noise =
				new Token(
					new TextAttribute(manager.getColor(IXMLColorConstants.PROC_INSTR)));
		
		IRule[] rules = new IRule[3];

		// Add rule for double quotes
		rules[0] = new SingleLineRule("\"", "\"", string, '\\');
		// Add a rule for single quotes
		rules[1] = new SingleLineRule("'", "'", string, '\\');
		// Add generic whitespace rule.
		rules[2] = new WhitespaceRule(new XMLWhitespaceDetector());
		
		//rules[3] = new WordRule(new SingleCharacterWordDetector('=', '<', '>', '\"'), noise);
		
		setRules(rules);
	}
}
