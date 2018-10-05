/*
 * Copyright (c) Ian F. Darwin, http://www.darwinsys.com/, 1996-2002.
 * All rights reserved. Software written by Ian F. Darwin and others.
 * $Id: LICENSE,v 1.8 2004/02/09 03:33:38 ian Exp $
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS ``AS IS''
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 */
package org.eclipse.epsilon.common.dt.console;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;


/**
 * TeePrintStream tees all PrintStream operations into a file, rather like the
 * UNIX tee(1) command. It is a PrintStream subclass. The expected usage would
 * be something like the following:
 * 
 * <PRE>
 * 
 * ... TeePrintStream ts = new TeePrintStream(System.err, "err.log");
 * System.setErr(ts); // ...lots of code that occasionally writes to
 * System.err... ts.close(); ...
 * 
 * <PRE>
 * 
 * <P>
 * I only override Constructors, the write(), check() and close() methods, since
 * any of the print() or println() methods must go through these. Thanks to
 * Svante Karlsson for help formulating this.
 * 
 * @author Ian F. Darwin, http://www.darwinsys.com/
 * @author Horacio Hoyos Rodriguez 
 * @since 1.6
 */
public class TeePrintStream extends PrintStream {
	
	protected PrintStream fileStream;

	protected String fileName;
	
	private boolean trouble = false;

	/** A simple test case. */
	public static void main(String[] args) throws IOException {
		TeePrintStream ts = new TeePrintStream(System.err, true);
		ts.enableTee("err.log");
		System.setErr(ts);
		System.err.println("An imitation error message");
		ts.close();
	}
	
	/**
	 * Construct a TeePrintStream given an existing PrintStream, an opened
	 * OutputStream, and a boolean to control auto-flush. This is the main
	 * constructor, to which others delegate via "this".
	 */
	public TeePrintStream(OutputStream os, boolean flush) {
		super(os, flush);
	}
	
	public TeePrintStream(OutputStream os) {
		super(os, true);
	}

	/** Return true if either stream has an error. */
	@Override
	public boolean checkError() {
		boolean error = trouble || super.checkError();
		return fileStream == null ? error : error || fileStream.checkError();
	}

	/** override write(). This is the actual "tee" operation. */
	@Override
	public void write(int x) {
		if (fileStream != null) fileStream.write(x); // "write once;
		super.write(x); // write somewhere else."
	}

	/** override write(). This is the actual "tee" operation. */
	@Override
	public void write(byte[] x, int o, int l) {
		if (fileStream != null) fileStream.write(x, o, l); // "write once;
		super.write(x, o, l); // write somewhere else."
	}
	
	

	/** Close both streams. */
	@Override
	public void close() {
		disableTee();
		super.close();
	}

	/** Flush both streams. */
	@Override
	public void flush() {
		if (fileStream != null) fileStream.flush();
		super.flush();
	}
	
	/**
	 * Enable tee operation by specifying the file to which the operations are teed. If there is an
	 * error the TeePrintStream will be flagged as having an error.
	 * By default bytes will be written to the beginning of the file
	 * @param fileName				The name of the file to direct output.
	 * @see #enableTee(String, boolean)
	 */
	public void enableTee(String fileName) {
		enableTee(fileName, false);
	}
	
	/**
	 * Enable tee operation by specifying the file to which the operations are teed. If there is an
	 * error the TeePrintStream will be flagged as having an error.
	 *
	 * @param fileName 			The name of the file to direct output.
	 * @param append 			if true, then bytes will be written to the end of the file rather than the beginning
	 */
	public void enableTee(String fileName, boolean append) {
		this.fileName = fileName;
		try {
			this.fileStream = new PrintStream(new FileOutputStream(fileName, append), true);
			clearError();
		} catch (FileNotFoundException e) {
			this.trouble = true;
		}
	}
	
	/**
	 * Disable the tee operation.
	 */
	public void disableTee() {
		this.fileName = "";
		if (fileStream != null) {
			fileStream.close();
			fileStream = null;
		}
	}
	
	/**
     * Sets the error state of the stream to <code>true</code>.
     *
     * <p> This method will cause subsequent invocations of {@link
     * #checkError()} to return <tt>true</tt> until {@link
     * #clearError()} is invoked.
     */
    protected void setError() {
        trouble = true;
    }

    /**
     * Clears the internal error state of this stream.
     *
     * <p> This method will cause subsequent invocations of {@link
     * #checkError()} to return <tt>false</tt> until another write
     * operation fails and invokes {@link #setError()}.
     */
    protected void clearError() {
        trouble = false;
    }
}