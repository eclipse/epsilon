/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.preprocessor;

import java.util.Map;
import java.util.TreeMap;

import org.eclipse.epsilon.egl.util.FileUtil;

public class PreprocessorTrace {

	private Map<Integer, Integer> lineNumberMapping = new TreeMap<>();
	private Map<Integer, Integer> columnCorrections = new TreeMap<>();
	
	private int currentEolLine = 1;
	private int maximumEglLineNumber = 1;

	
	public int getEglLineNumberFor(int eolLine) {
		if (lineNumberMapping.containsKey(eolLine))
			return lineNumberMapping.get(eolLine);
		
		return maximumEglLineNumber;
	}
	
	public int getEglColumnNumberFor(int eolLine, int eolCol) {
		if (columnCorrections.containsKey(eolLine))
			return eolCol + columnCorrections.get(eolLine);
		
		return eolCol;
	}

	void setEglLineNumberForCurrentEolLineNumber(int eglLineNumber) {
		currentEolLine++;
		lineNumberMapping.put(currentEolLine, eglLineNumber);
		maximumEglLineNumber = Math.max(maximumEglLineNumber, eglLineNumber);
	}
	
	void incrementColumnCorrectionNumber(int correction) {
		if (columnCorrections.containsKey(currentEolLine))
			columnCorrections.put(currentEolLine, correction + columnCorrections.get(currentEolLine));
		else
			columnCorrections.put(currentEolLine, correction);
	}
	
	void reset() {
		lineNumberMapping.clear();
		columnCorrections.clear();
		currentEolLine = 0;
		maximumEglLineNumber = 1;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		for (int eolLine = 1; eolLine <= currentEolLine; eolLine++) {
			builder.append(eolLine);
			builder.append(" -> ");
			builder.append(getEglLineNumberFor(eolLine));

			builder.append(" [");
			builder.append(getEglColumnNumberFor(eolLine, 0));
			builder.append("]");
			
			builder.append(FileUtil.NEWLINE);
		}
		
		return builder.toString();
	}
}
