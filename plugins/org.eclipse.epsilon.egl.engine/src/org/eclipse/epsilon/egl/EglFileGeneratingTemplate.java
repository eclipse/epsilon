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
package org.eclipse.epsilon.egl;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.epsilon.common.util.UriUtil;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.formatter.NullFormatter;
import org.eclipse.epsilon.egl.merge.output.ProtectedRegion;
import org.eclipse.epsilon.egl.output.Writer;
import org.eclipse.epsilon.egl.spec.EglTemplateSpecification;
import org.eclipse.epsilon.egl.spec.EglTemplateSpecificationFactory;
import org.eclipse.epsilon.egl.status.ProtectedRegionWarning;
import org.eclipse.epsilon.egl.traceability.OutputFile;
import org.eclipse.epsilon.egl.util.FileUtil;

public class EglFileGeneratingTemplate extends EglPersistentTemplate {

	private String currentOutputPath;
	private OutputFile currentOutputFile;

	// For tests
	protected EglFileGeneratingTemplate(URI path, IEglContext context, URI outputRoot) throws Exception {
		this(new EglTemplateSpecificationFactory(new NullFormatter()).fromResource(path.toString(), path), context, outputRoot, outputRoot.getPath());
	}

	public EglFileGeneratingTemplate(EglTemplateSpecification spec, IEglContext context, URI outputRoot, String outputRootPath) throws Exception {
		super(spec, context, outputRoot, outputRootPath);
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
			throw new EglRuntimeException("Could not generate to " + targetName, ex, module.getAst());
		}

	}
	
	private void write(File target, String targetName, String contents, String message) throws EglRuntimeException {
		try {
			new Writer(target, contents).write();

			addMessage(message);

			currentOutputFile = template.addOutputFile(targetName, UriUtil.fileToUri(target));

		} catch (IOException ex) {
			throw new EglRuntimeException("Could not write to " + target, ex, module.getAst());

		} catch (URISyntaxException e) {
			throw new EglRuntimeException("Could not resolve path: " + target, e, module.getAst());
		}
	}

	@Override
	protected void addProtectedRegionWarning(ProtectedRegionWarning warning) {
		super.addProtectedRegionWarning(new ProtectedRegionWarning(warning.getId(), currentOutputPath));
	}

}
