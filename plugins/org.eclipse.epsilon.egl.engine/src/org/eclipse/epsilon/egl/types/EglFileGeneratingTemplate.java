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
import org.eclipse.epsilon.egl.traceability.OutputFile;
import org.eclipse.epsilon.egl.util.FileUtil;

public class EglFileGeneratingTemplate extends EglPersistentTemplate {

	private String currentOutputPath;
	private OutputFile currentOutputFile;

	// For tests
	protected EglFileGeneratingTemplate(URI path, IEglContext callersContext, URI outputRoot) throws EglRuntimeException {
		this(path.toString(), path, callersContext, outputRoot, outputRoot.getPath());
	}

	public EglFileGeneratingTemplate(String name, URI path, IEglContext callersContext, URI outputRoot, String outputRootPath) throws EglRuntimeException {
		super(name, path, callersContext, outputRoot, outputRootPath);
	}

	protected void doGenerate(File target, String targetName, boolean overwrite, boolean protectRegions) throws EglRuntimeException {
		currentOutputPath = target.getAbsolutePath();

		try {
			if (protectRegions && target.exists()) {
				final String merged = merge(FileUtil.read(target));

				write(target, targetName, merged, "Protected regions of " + targetName + " were preserved.");

				for (ProtectedRegion pr : module.getContext().getPartitioner().partition(merged).getProtectedRegions()) {
					currentOutputFile.addProtectedRegion(pr.getId(), pr.isEnabled(), pr.getOffset());
				}

			} else {
				write(target, targetName, getContents(), "Successfully wrote to " + targetName);
			}
		} catch (IOException ex) {
			throw new EglRuntimeException("Could not generate to " + targetName, ex, callersContext.getModule().getAst());
		}

	}
	
	private void write(File target, String targetName, String contents, String message) throws EglRuntimeException {
		try {
			new Writer(target, contents).write();

			addMessage(message);

			currentOutputFile = module.getContext().getTemplate().addOutputFile(targetName, UriUtil.fileToUri(target));

		} catch (IOException ex) {
			throw new EglRuntimeException("Could not write to " + target, ex,
					callersContext.getModule().getAst());

		} catch (URISyntaxException e) {
			throw new EglRuntimeException("Could not resolve path: " + target, e,
					callersContext.getModule().getAst());
		}
	}

	@Override
	protected void addProtectedRegionWarning(ProtectedRegionWarning warning) {
		super.addProtectedRegionWarning(new ProtectedRegionWarning(warning.getId(), currentOutputPath));
	}

}
