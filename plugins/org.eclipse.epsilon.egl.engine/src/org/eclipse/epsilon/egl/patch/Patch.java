package org.eclipse.epsilon.egl.patch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Patch extends TextBlock {
	
	public Patch() {}
	
	public Patch(String... lines) {
		LineFactory lineFactory = new LineFactory();
		for (int i=0; i<lines.length; i++) {
			this.lines.add(lineFactory.createLine(lines[i], i+1));
		}
	}
	
	public List<PatchValidationDiagnostic> validate() {
		List<PatchValidationDiagnostic> diagnostics = new ArrayList<>();
		
		for (Line line : lines) {
			if (line.is(LineType.REGULAR)) diagnostics.add(new PatchValidationDiagnostic(line, "Regular lines are not allowed in patch"));
			if (line.is(LineType.WILDCARD)) {
				if (isFirstLine(line)) {
					diagnostics.add(new PatchValidationDiagnostic(line, "Wildcards are not allowed at the beginning of a patch"));
				}
				else if (isLastLine(line)) {
					diagnostics.add(new PatchValidationDiagnostic(line, "Wildcards are not allowed at the end of a patch"));					
				}
				
				if (!isFirstLine(line) && getPreviousLine(line).is(LineType.WILDCARD)) {
					diagnostics.add(new PatchValidationDiagnostic(line, "Consecutive wildcards are not allowed"));					
				}
				if (!isLastLine(line) && getNextLine(line).is(LineType.WILDCARD)) {
					diagnostics.add(new PatchValidationDiagnostic(line, "Consecutive wildcards are not allowed"));
				}
			}
		}
		
		return diagnostics;
	}
	
	public boolean isValid() {
		return validate().isEmpty();
	}
	
	public List<Match> match(TextBlock block) {
				
		Line startMatchBlockLine = null;
		List<Match> matches = new ArrayList<Match>();
		Patch keepsAndRemoves = this.keepsAndRemoves();
		
		if (keepsAndRemoves.getLines().isEmpty()) return matches;
		
		LineMap lineMap = new LineMap();
		Line blockLine = block.getFirstLine();
		Line patchLine = keepsAndRemoves.getFirstLine();
		
		while (blockLine != null) {
			
			if (patchLine.is(LineType.WILDCARD)) {
				Line matchLine = keepsAndRemoves.getNextLine(patchLine);
				
				if (matchLine == null) {
					if (startMatchBlockLine != null) {
						while (blockLine != null) {
							lineMap.put(patchLine, blockLine);
							blockLine = block.getNextLine(blockLine);
						}
						matches.add(new Match(block, startMatchBlockLine.getNumber()-1, block.getLines().size(), this, lineMap));
					}
					break;
				}
				else {
					while (blockLine != null && !matchLine.getTrimmedText().contentEquals(blockLine.getTrimmedText())) {
						lineMap.put(patchLine, blockLine);
						blockLine = block.getNextLine(blockLine);
					}
					
					patchLine = matchLine;
					continue;
				}
			}
			else if (patchLine.getTrimmedText().contentEquals(blockLine.getTrimmedText())) {
				lineMap.put(patchLine, blockLine);
				if (startMatchBlockLine == null) {
					startMatchBlockLine = blockLine;
				}
				
				if (keepsAndRemoves.isLastLine(patchLine)) {
					matches.add(new Match(block, startMatchBlockLine.getNumber()-1, blockLine.getNumber()-1, this, lineMap));
					patchLine = keepsAndRemoves.getFirstLine();
					startMatchBlockLine = null;
				}
				else {
					patchLine = keepsAndRemoves.getNextLine(patchLine);
				}
				blockLine = block.getNextLine(blockLine);
			}
			else {
				blockLine = block.getNextLine(blockLine);
				patchLine = keepsAndRemoves.getFirstLine();
				startMatchBlockLine = null;
				lineMap = new LineMap();
			}
			
		}
		
		// If we're left in the middle of a match and all that remains are insertions, complete the match.
		// e.g. TextBlock["1"] and Patch["=1",">2"]
		//if (startMatchBlockLine != null && keepsAndRemoves.isFirstLine(patchLine)) {
		//	matches.add(new Match(block, startMatchBlockLine.getNumber()-1, block.getLines().size(), this, lineMap));
		//}
		
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
					if (line.is(LineType.WILDCARD)) {
						for (Line originalLine : match.getLineMap().get(line)) {
							merged.getLines().add(new Line(LineType.REGULAR, originalLine.getText(), -1));
						}
					}
					else if (line.isNot(LineType.REMOVE)) {
						String text;
						if (line.getType() == LineType.INSERT) text = line.getText();
						else text = match.getLineMap().get(line).get(0).getText();
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
				filter(l -> l.getType() == LineType.KEEP 
						 || l.getType() == LineType.REMOVE
						 || l.getType() == LineType.WILDCARD).
				collect(Collectors.toList()));
		return patch;
	}
	
}
