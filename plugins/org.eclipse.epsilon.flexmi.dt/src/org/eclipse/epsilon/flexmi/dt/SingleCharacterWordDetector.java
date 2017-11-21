package org.eclipse.epsilon.flexmi.dt;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.rules.IWordDetector;

public class SingleCharacterWordDetector implements IWordDetector {

	private List<Character> chars = new ArrayList<Character>();
    
	public SingleCharacterWordDetector(char...chars) {
		for (char c : chars) {
			this.chars.add(c);
		}
	}
	
    public void addChar(char c) {
        chars.add(c);
    }
     
    public boolean isWordPart(char c) {
        return false;
    }
 
    public boolean isWordStart(char c) {
        return chars.contains(c);
    }

}
