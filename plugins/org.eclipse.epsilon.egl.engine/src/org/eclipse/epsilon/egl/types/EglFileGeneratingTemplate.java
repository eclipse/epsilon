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
package org.eclipse.epsilon.egl.types;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.epsilon.commons.util.UriUtil;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.merge.output.ProtectedRegion;
import org.eclipse.epsilon.egl.output.Writer;
import org.eclipse.epsilon.egl.status.ProtectedRegionWarning;
import org.eclipse.epsilon.egl.status.StatusMessage;
import org.eclipse.epsilon.egl.traceability.OutputFile;
import org.eclipse.epsilon.egl.util.FileUtil;

public class EglFileGeneratingTemplate extends EglTemplate {

	private final URI    outputRoot;
	private final String outputRootPath;
	
	private String currentOutputPath;
	private OutputFile currentOutputFile;
	
	// For tests
	protected EglFileGeneratingTemplate(URI path,
	                                    IEglContext callersContext,
	                                    URI outputRoot) throws EglRuntimeException {
		
		this(path.toString(), path, callersContext, outputRoot, outputRoot.getPath());
	}
	
	public EglFileGeneratingTemplate(String name,
	                                 URI path, 
	                                 IEglContext callersContext, 
	                                 URI outputRoot,
	                                 String outputRootPath) throws EglRuntimeException {

			super(name, path, callersContext);
			this.outputRoot     = outputRoot;
			this.outputRootPath = outputRootPath;
	}
	
	private void addMessage(String message) {
		callersContext.addStatusMessage(new StatusMessage(message));
	}
	
	private String name(String path) {
		String name = path;
		 
		 if (outputRootPath != null)
			 name = new File(outputRootPath).getPath() + FileUtil.FILE_SEP + name;
		 
		 return name;
	}
	
	private void write(File file, String contents, String message) throws EglRuntimeException {		
		try {
			new Writer(file, contents).write();
		
			addMessage(message);
			
			currentOutputFile = module.getContext().getTemplate().addOutputFile(name(currentOutputPath), UriUtil.fileToUri(file));

		} catch (IOException ex) {
			throw new EglRuntimeException("Could not write to " + file, ex, callersContext.getModule().getAst());
		
		} catch (URISyntaxException e) {
			throw new EglRuntimeException("Could not resolve path: "+file, e, callersContext.getModule().getAst());
		}
	}
	
	protected File resolveFile(String path) throws EglRuntimeException {
		try {
			final String encodedPath = UriUtil.encode(path, false);
			final URI resolved       = UriUtil.resolve(encodedPath, outputRoot);
			
			if (resolved.getScheme().equals("file"))
				return new File(resolved);
			
			else
				return new File(new URI("file:///" + encodedPath));
			
		} catch (URISyntaxException e) {
			throw new EglRuntimeException("Could not resolve path: "+path, e, callersContext.getModule().getAst());
		}
	}
	
	public void store(String path) throws EglRuntimeException {
		store(path, false);
	}
	
	public void store(String path, boolean overwrite) throws EglRuntimeException {
		currentOutputPath = path;
		final File outputFile = resolveFile(path);
		
		if (!overwrite && outputFile.exists()) {
			addMessage("Existing contents of "+name(path)+" were preserved.");
		
		} else {
			if (!isProcessed()) process();
			write(outputFile, getContents(), "Successfully wrote to " + name(path));
		}
	}
	
	public void generate(String path) throws EglRuntimeException {
		try {
			currentOutputPath = path;
			final File outputFile = resolveFile(path);
			
			if (!isProcessed()) process();
			
			if (outputFile.exists()) {
				final String merged = merge(FileUtil.read(outputFile));
				
				write(outputFile, merged, "Protected regions of "+name(path)+" were preserved.");
			
				for (ProtectedRegion pr : module.getContext().getPartitioner().partition(merged).getProtectedRegions()) {
					currentOutputFile.addProtectedRegion(pr.getId(), pr.isEnabled(), pr.getOffset());
				}
				
			} else {
				write(outputFile, getContents(), "Successfully wrote to " + name(path));
			}
		} catch (IOException ex) {
			throw new EglRuntimeException("Could not generate to " + path, ex, callersContext.getModule().getAst());
		}
	}
	
	@Override
	protected void addProtectedRegionWarning(ProtectedRegionWarning warning) {
		super.addProtectedRegionWarning(new ProtectedRegionWarning(warning.getId(), currentOutputPath));
	}
	
}
