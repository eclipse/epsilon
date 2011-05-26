/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.output;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.epsilon.commons.util.StringUtil;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.exceptions.EglStoppedException;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.merge.partition.CommentBlockPartitioner;
import org.eclipse.epsilon.egl.status.Warning;
import org.eclipse.epsilon.egl.util.FileUtil;

public class OutputBuffer {
	
	private final StringBuilder buffer = new StringBuilder();
	private final IEglContext context;
	
	private final List<CommentBlockPartitioner> customPartitioners = new LinkedList<CommentBlockPartitioner>();
	private boolean contentTypeSet = false;
	private String lastLine = null;
	
	public OutputBuffer(IEglContext context) {
		this(context, null);
	}
	
	public OutputBuffer() {
		this(null, null);
	}
	
	// For unit tests
	OutputBuffer(IEglContext context, String contents) {
		this.context = context;
		if (contents != null) buffer.append(contents);
	}
	
	public void chop(int chars){
		int limit = Math.min(chars, buffer.length());
		for (int i=0;i<limit;i++){
			buffer.deleteCharAt(buffer.length()-1);
		}
	}
	
	public void print(Object o){
		buffer.append(o == null ? "null" : o.toString());
	}
	
	private String getLastLineInBuffer() {
		final int indexOfLastLine = buffer.lastIndexOf("\n");
		
		if (indexOfLastLine == -1) {
			return buffer.substring(0, buffer.length());
		}
		else {
			return buffer.substring(indexOfLastLine + 1, buffer.length());
		}
	}
	
	private String calculateIndentationToMatch(String previousLine) {
		final StringBuilder builder = new StringBuilder();
		
		for (char c : previousLine.toCharArray()) {
			if (Character.isWhitespace(c)) {
				builder.append(c);
			}
			else {
				builder.append(' ');
			}
		}
		
		return builder.toString();
	}
	
	public void printdyn(Object o) {
		final String indentation = calculateIndentationToMatch(getLastLineInBuffer());
		final String[] lines = StringUtil.toString(o).split(FileUtil.NEWLINE);
		
		for (int i=0;i<lines.length;i++) {
			if (i == 0) {
				// Any text before the first newline character should not be
				// placed on a newline nor indented  
				buffer.append(lines[i]);
			} else {
				buffer.append(FileUtil.NEWLINE + indentation + lines[i]);
			}
		}
	}
	
	public String getSpaces(int howMany) {
		String str = "";
		for (int i=0;i<howMany;i++) {
			str += " ";
		}
		return str;
	}
	
	public void println(){
		buffer.append(FileUtil.NEWLINE);
	}
	
	public void println(Object o) {
		print(o);
		println();
	}
	
	public String preserve(String id,
	                       boolean enabled,
	                       String contents) throws EglRuntimeException {

		return startPreserve(id, enabled) + FileUtil.NEWLINE +
		       contents + FileUtil.NEWLINE +
		       stopPreserve();
	}
	
	public String preserve(String startComment,
	                       String endComment,
	                       String id,
	                       boolean enabled,
	                       String contents) throws EglRuntimeException {
		
		return startPreserve(startComment, endComment, id, enabled) + FileUtil.NEWLINE +
		       contents + FileUtil.NEWLINE +
		       stopPreserve();
	}
	
	public void setContentType(String name) throws EglRuntimeException {
		if (contentTypeSet) {
			context.addStatusMessage(new Warning("Cannot set content type to '" + name + "' - content type already specified."));
		} else {
			if (!context.usePartitionerFor(name)) {
				throw new EglRuntimeException("'" + name + "' is not a recognised content type.", context.getModule().getAst());
			}
			
			for (CommentBlockPartitioner customPartitioner : customPartitioners) {
				context.getPartitioner().addPartitioner(customPartitioner);
			}
			
			contentTypeSet = true;
		}
	}
	
	public String startPreserve(String id, boolean enabled) throws EglRuntimeException {
	
		if (lastLine != null)
			throw new EglRuntimeException("Preservation of the current region must be stopped before preservation of another region may begin.", context.getModule().getAst());
		
		if (context.getPartitioner().getDefaultPartitioner() == null)
			throw new EglRuntimeException("A content type must be specified before using startPreserve(id, enabled).", context.getModule().getAst());
		
		lastLine = context.getPartitioner().getDefaultPartitioner().getLastLine(id);
		
		return context.getPartitioner().getDefaultPartitioner().getFirstLine(id, enabled);	
	}
	
	
	public String startPreserve(String startComment,
	                            String endComment,
	                            String id,
	                            boolean enabled) throws EglRuntimeException {

		if (lastLine != null)
			throw new EglRuntimeException("Preservation of the current region must be stopped before preservation of another region may begin.", context.getModule().getAst());
		
		final CommentBlockPartitioner customPartitioner = new CommentBlockPartitioner(startComment, endComment);
		lastLine = customPartitioner.getLastLine(id);
		
		context.getPartitioner().addPartitioner(customPartitioner);
		customPartitioners.add(customPartitioner);
		
		return customPartitioner.getFirstLine(id, enabled);	
	}
	
	public String stopPreserve() throws EglRuntimeException {
		if (lastLine == null)
			throw new EglRuntimeException("There is no current region to stop preserving.", context.getModule().getAst());

		final String result = lastLine;
		lastLine = null;
		
		return result;
	}
	
	public void stop() throws EglStoppedException {
		throw new EglStoppedException(context.getModule().getAst());
	}
	
	public int getCurrentLineNumber() {
		return toString().split(FileUtil.NEWLINE).length;
	}
	
	@Override
	public String toString(){
		return buffer.toString();
	}
}
