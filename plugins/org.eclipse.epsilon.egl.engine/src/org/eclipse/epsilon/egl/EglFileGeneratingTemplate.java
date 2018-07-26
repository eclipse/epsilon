/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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
import org.eclipse.epsilon.egl.incremental.IncrementalitySettings;
import org.eclipse.epsilon.egl.merge.output.LocatedRegion;
import org.eclipse.epsilon.egl.output.Writer;
import org.eclipse.epsilon.egl.spec.EglTemplateSpecification;
import org.eclipse.epsilon.egl.spec.EglTemplateSpecificationFactory;
import org.eclipse.epsilon.egl.status.ProtectedRegionWarning;
import org.eclipse.epsilon.egl.traceability.OutputFile;
import org.eclipse.epsilon.egl.util.FileUtil;

public class EglFileGeneratingTemplate extends EglPersistentTemplate {

	private File target;
	private String targetName;
	private OutputFile currentOutputFile;
	private String existingContents;
	private String newContents;
	private String positiveMessage;
	private OutputMode outputMode;

	private static enum OutputMode {
		WRITE, MERGE, APPEND;
	}
	
	// For tests
	protected EglFileGeneratingTemplate(URI path, IEglContext context, URI outputRoot) throws Exception {
		this(new EglTemplateSpecificationFactory(new NullFormatter(), new IncrementalitySettings()).fromResource(path.toString(), path), context, outputRoot, outputRoot.getPath());
	}

	public EglFileGeneratingTemplate(EglTemplateSpecification spec, IEglContext context, URI outputRoot, String outputRootPath) throws Exception {
		super(spec, context, outputRoot, outputRootPath);
	}
	
	public File append(String path) throws EglRuntimeException {
		try {
			final File target = resolveFile(path);

			if (!isProcessed()) {
				process();
			}
			
			this.target = target;
			this.targetName = name(path);			
			this.existingContents = FileUtil.readIfExists(target);
			this.outputMode = OutputMode.APPEND;
			
			prepareNewContents();
			writeNewContentsIfDifferentFromExistingContents();

			return target;
		} catch (URISyntaxException e) {
			throw new EglRuntimeException("Could not resolve path: " + target, e, module);
		} catch (IOException ex) {
			throw new EglRuntimeException("Could not generate to: " + target, ex, module);
		}
	}

	protected void doGenerate(File target, String targetName, boolean overwrite, boolean merge) throws EglRuntimeException {
		try {
			this.target = target;
			this.targetName = targetName;			
			this.existingContents = FileUtil.readIfExists(target);
			this.outputMode = (merge && target.exists()) ? OutputMode.MERGE : OutputMode.WRITE;
			
			prepareNewContents();
			writeNewContentsIfDifferentFromExistingContents();
			
		} catch (URISyntaxException e) {
			throw new EglRuntimeException("Could not resolve path: " + target, e, module);
		} catch (IOException ex) {
			throw new EglRuntimeException("Could not generate to: " + target, ex, module);
		}
	}
	
	private void prepareNewContents() throws EglRuntimeException {
		switch (outputMode) {
			case APPEND:
				if (existingContents != null) {
					newContents = existingContents + FileUtil.NEWLINE + getContents();
				} else {
					newContents = getContents();
				}
				positiveMessage = "Successfully appended to ";
				break;
	
			case MERGE:
				newContents = merge(existingContents);
				positiveMessage = "Protected regions preserved in ";
				break;
				
			case WRITE:
				newContents = getContents();
				positiveMessage = "Successfully wrote to ";
				break;
				
			default:
				throw new EglRuntimeException("Unsupported output mode " + outputMode, new IllegalStateException());
		}
	}
	
	private void writeNewContentsIfDifferentFromExistingContents() throws URISyntaxException, IOException {
		if (isOverwriteUnchangedFiles() || !newContents.equals(existingContents)) {
			write();
			addMessage(positiveMessage + targetName);
		} else {
			addMessage("Content unchanged for " + targetName);			
		}
	}
	
	private boolean isOverwriteUnchangedFiles() {
		return getIncrementalitySettings().isOverwriteUnchangedFiles();
	}

	private void write() throws IOException, URISyntaxException {
		new Writer(target, newContents).write();
		
		currentOutputFile = template.addOutputFile(targetName, UriUtil.fileToUri(target));
		
		if (outputMode == OutputMode.MERGE) {
			for (LocatedRegion pr : module.getContext().getPartitioner().partition(newContents).getLocatedRegions()) {
				currentOutputFile.addProtectedRegion(pr.getId(), pr.isEnabled(), pr.getOffset());
			}
		}
	}

	@Override
	protected void addProtectedRegionWarning(ProtectedRegionWarning warning) {
		super.addProtectedRegionWarning(new ProtectedRegionWarning(warning.getId(), target.getAbsolutePath()));
	}
}
