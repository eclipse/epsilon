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
import org.eclipse.epsilon.eol.execute.prettyprinting.PrettyPrinter;
import org.eclipse.epsilon.eol.types.EolInteger;

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
	
	public void chop(EolInteger chars){
		int limit = Math.min(chars.intValue(), buffer.length());
		for (int i=0;i<limit;i++){
			buffer.deleteCharAt(buffer.length()-1);
		}
	}
	
	public void print(Object o){
		buffer.append(o == null ? "null" : o.toString());
	}
	
	public void printdyn(Object o) {
		int lastline = buffer.lastIndexOf("\n");
		String str = StringUtil.toString(o);
		String[] parts = str.split("\r\n");
		String spaceStr = null; 
		if (lastline == -1) {
			spaceStr = buffer.substring(0, buffer.length());
		}
		else {
			spaceStr = buffer.substring(lastline + 1, buffer.length());
		}
		
		String temp = "";
		
		for (char c : spaceStr.toCharArray()) {
			if (Character.isWhitespace(c)) {
				temp = temp + c;
			}
			else {
				temp = temp + " ";
			}
		}
		
		spaceStr = temp;
		
		//spaceStr = spaceStr.replaceAll("^[\\s]*", " ");
		
		for (int i=0;i<parts.length;i++) {
			//System.err.println(parts[i]);
			if (i > 0) {
				buffer.append("\n" + spaceStr + parts[i]);
			}
			else {
				buffer.append(parts[i]);
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
	
	@Override
	public String toString(){
		return buffer.toString();
	}
}
