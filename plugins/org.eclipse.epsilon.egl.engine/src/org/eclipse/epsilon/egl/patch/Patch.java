package org.eclipse.epsilon.egl.patch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Patch extends TextBlock {
	
	public Patch() {}
	
	public Patch(String... lines) throws InvalidLineException {
		LineFactory lineFactory = new LineFactory();
		for (int i=0; i<lines.length; i++) {
			Line line = lineFactory.createLine(lines[i], i+1);
			if (line.getType() == LineType.REGULAR) throw new InvalidLineException(line);
			this.lines.add(line);
		}
	}
	
	public List<Match> match(TextBlock block) {
		
		int patchLineNumber = 0;
		int startMatchBlockLineNumber = -1;
		
		List<Match> matches = new ArrayList<Match>();
		Patch keepsAndRemoves = this.keepsAndRemoves();
		
		if (keepsAndRemoves.getLines().isEmpty()) return matches;
		
		HashMap<Line, Line> lineMap = new HashMap<>();
		
		for (int blockLineNumber=0; blockLineNumber<block.getLines().size(); blockLineNumber++) {
			
			Line blockLine = block.getLines().get(blockLineNumber);
			String blockLineText = blockLine.getText().trim();
			
			//if (patchLineNumber == keepsAndRemoves.getLines().size()) break;
			
			Line patchLine = keepsAndRemoves.getLines().get(patchLineNumber);
			String patchLineText = patchLine.getText().trim();
			
			if (patchLineText.contentEquals(blockLineText)) {
				lineMap.put(patchLine, blockLine);
				if (patchLineNumber == 0) {
					startMatchBlockLineNumber = blockLineNumber;
				}
				
				if (patchLineNumber == keepsAndRemoves.getLines().size() - 1) {
					matches.add(new Match(block, startMatchBlockLineNumber, blockLineNumber, this, lineMap));
					patchLineNumber = 0;
					startMatchBlockLineNumber = -1;
				}
				else {
					patchLineNumber ++;
				}
			}
			else {
				patchLineNumber = 0;
				startMatchBlockLineNumber = 0;
				lineMap = new HashMap<Line, Line>();
			}
		}
		
		// If we're left in the middle of a match and all that remains are insertions, complete the match.
		// e.g. TextBlock["1"] and Patch["=1",">2"]
		if (startMatchBlockLineNumber >= 0 && patchLineNumber == keepsAndRemoves.getLines().size()) {
			matches.add(new Match(block, startMatchBlockLineNumber, block.getLines().size(), this, lineMap));
		}
		
		return matches;
	}
	
	public boolean appliesTo(TextBlock block) {
		return match(block).size() > 0;
	}
	
	public TextBlock apply(TextBlock block) {
		List<Match> matches = match(block);
		if (matches.isEmpty()) return block;
		
		TextBlock merged = new TextBlock();
		Iterator<Match> matchIterator = matches.iterator();
		Match match = matchIterator.next();
//		System.out.println(match);
		
		for (int originalLineNumber=0;originalLineNumber<block.getLines().size();originalLineNumber++) {
			if (match != null && originalLineNumber == match.getStartLine()) {
//				System.out.println(match.getPatch().getLines().size());
				for (Line line : match.getPatch().getLines()) {
					if (line.getType() != LineType.REMOVE) {
						String text;
						if (line.getType() == LineType.INSERT) text = line.getText();
						else text = match.getLineMap().get(line).getText();
						merged.getLines().add(new Line(LineType.REGULAR, text, -1));
					}
				}
				
				originalLineNumber = match.getEndLine();
				if (matchIterator.hasNext()) match = matchIterator.next();
				else match = null;
			}
			else {
				merged.getLines().add(block.getLines().get(originalLineNumber));
			}
		}
		
		return merged;
	}
	
	public Patch keepsAndRemoves() {
		Patch patch = new Patch();
		patch.getLines().addAll(this.getLines().stream().
				filter(l -> l.getType() == LineType.KEEP || l.getType() == LineType.REMOVE).
				collect(Collectors.toList()));
		return patch;
	}
	
}
