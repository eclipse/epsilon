package org.eclipse.epsilon.egl.patch;

import java.util.ArrayList;
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
		int startMatchBlockLineNumber = 0;
		
		List<Match> matches = new ArrayList<Match>();
		Patch keepsAndRemoves = this.keepsAndRemoves();
		
		for (int blockLineNumber=0; blockLineNumber<block.getLines().size(); blockLineNumber++) {
			
			String blockLine = block.getLines().get(blockLineNumber).getText().trim();
			String patchLine = keepsAndRemoves.getLines().get(patchLineNumber).getText().trim();
			
			if (patchLine.contentEquals(blockLine)) {
				if (patchLineNumber == 0) {
					startMatchBlockLineNumber = blockLineNumber;
					patchLineNumber ++;
				}
				else if (patchLineNumber == keepsAndRemoves.getLines().size() - 1) {
					matches.add(new Match(block, startMatchBlockLineNumber, blockLineNumber, this));
					patchLineNumber = 0;
					startMatchBlockLineNumber = 0;
				}
				else {
					patchLineNumber ++;
				}
			}
			else {
				patchLineNumber = 0;
				startMatchBlockLineNumber = 0;
			}
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
		
		for (int originalLineNumber=0;originalLineNumber<block.getLines().size();originalLineNumber++) {
			if (match != null && originalLineNumber == match.getStartLine()) {
//				System.out.println(match.getPatch().getLines().size());
				for (Line line : match.getPatch().getLines()) {
					if (line.getType() != LineType.REMOVE) {
//						System.out.println("Adding " + line.getText());
						merged.getLines().add(new Line(LineType.REGULAR, line.getText(), -1));
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
