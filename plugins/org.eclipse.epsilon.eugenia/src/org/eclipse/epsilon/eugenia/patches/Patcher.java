/*******************************************************************************
 * Copyright (c) 2013 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eugenia.patches;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.compare.patch.IFilePatch2;
import org.eclipse.compare.patch.IFilePatchResult;
import org.eclipse.compare.patch.IHunk;
import org.eclipse.compare.patch.PatchConfiguration;
import org.eclipse.compare.patch.PatchParser;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Status;
import org.eclipse.epsilon.common.dt.util.LogUtil;

public class Patcher {
	
	private final IProject project;
	private Errors errors;
	
	public Patcher(IProject project) {
		this.project = project;
	}
	
	public void runForwards() {
		run(false);
	}
	
	public void runBackwards() {
		run(true);
	}
	
	private void run(boolean reversed) {
		errors = new Errors();
		
		try {			
			final IResource patchDir = project.findMember("patches");
			
			if (patchDir != null && patchDir instanceof IFolder) {
				for (IResource member : getFolderContents((IFolder)patchDir, reversed)) {
					if (member instanceof IFile && "patch".equals(((IFile)member).getFileExtension())) {
						applyPatch((IFile)member, reversed);
					} else {
						errors.add("Ignoring '" + member.getName() + "' as it is not a file with a name ending in.patch");
					}
				}
			}
			
		} catch (CoreException e) {
			errors.add("An error was encountered whilst attempting to " + getVerb(reversed) + " your patches to the generated GMF code.", e);
		}
		
		errors.display();
	}

	private Collection<IResource> getFolderContents(IFolder folder, boolean reversed) throws CoreException {
		final List<IResource> members = new LinkedList<>(Arrays.asList(folder.members()));
		if (reversed) { Collections.reverse(members); }
		return members;
	}

	private void applyPatch(IFile patchFile, boolean reversed) {
		try {
			final IFilePatch2[] completePatch = PatchParser.parsePatch(new WorkspaceReaderCreator(patchFile));
			
			if (completePatch.length == 0) {
				errors.add("No valid patches were found when attempting to " + getVerb(reversed) + " the patch file: " + patchFile.getName());
				
			} else {			
				for (IFilePatch2 partialPatch : completePatch) {
					applyPartialPatch(patchFile, partialPatch, reversed);
				}
			}
		
		} catch (CoreException e) {
			errors.add("An error was encountered whilst attempting to " + getVerb(reversed) + " the patch file: " + patchFile.getName(), e);
		}
	}

	private void applyPartialPatch(IFile patchFile, IFilePatch2 partialPatch, final boolean reversed) throws CoreException {
		final IWorkspaceRoot root = patchFile.getWorkspace().getRoot();

		final PatchConfiguration configuration = new PatchConfiguration();
		configuration.setReversed(reversed);
		
		final IPath target = partialPatch.getTargetPath(configuration);			
		final IFilePatchResult result = partialPatch.apply(new WorkspaceReaderCreator(root, target), configuration, null);
		
		if (result.hasRejects()) {
			final String message = "An error was encountered whilst attempting to " + getVerb(reversed) + " the patch file: " + patchFile.getName() + "\r\n" +
			                       "\r\n" +
			                       "The following hunks were rejected: " + seraliseResult(result);
			
			errors.add(message);
			
		} else {
			final IFile targetFile = root.getFile(target);
			
			if (targetFile.exists()) {
				targetFile.setContents(result.getPatchedContents(), IFile.KEEP_HISTORY, null);
			} else {
				targetFile.create(result.getPatchedContents(), false, null);
			}
				
			try {
				// If the file has no content after the patch has been applied,
				// assume that the file should be deleted.
				if (isEmpty(result.getPatchedContents())) {
					targetFile.delete(false, null);
				}
			} catch (IOException e) {
				throw new CoreException(new Status(Status.ERROR, "org.eclipse.epsilon.eugenia",
						"Error encountered whilst trying to read the patched contents of: " + targetFile.getName()));
			}
		}
			
	}
	
	private String seraliseResult(IFilePatchResult result) {
		final StringBuilder builder = new StringBuilder();
		
		for (IHunk reject : result.getRejects()) {			
			builder.append(reject.getLabel());
			
			for (String line : reject.getUnifiedLines()) {
				builder.append(line);
			}
		}
		
		return builder.toString();
	}
	
	private String getVerb(boolean reversed) {
		return reversed ? "unapply" : "apply";
	}
	
	private boolean isEmpty(InputStream stream) throws IOException {
		return new InputStreamReader(stream).read() == -1;
	}
	
	private class WorkspaceReaderCreator extends org.eclipse.compare.patch.ReaderCreator {
		
		private final IFile file;
		
		public WorkspaceReaderCreator(IFile file) {
			this.file = file;
		}
		
		public WorkspaceReaderCreator(IWorkspaceRoot root, IPath path) {
			this.file = root.getFile(path);
		}
		
		@Override
		public boolean canCreateReader() {
			return true;//this.file.exists();
		}
		
		@Override
		public Reader createReader() throws CoreException {
			if (this.file.exists()) {
				return new InputStreamReader(this.file.getContents());
			} else {
				return new StringReader("");
			}
		}
	}
	
	public static class Errors {
		
		private Map<String, Throwable> errors = new HashMap<>();
		
		public void add(String message) {
			add(message, new PatchApplicationException(message));
		}
		
		public void add(String message, Throwable cause) {
			errors.put(message, cause);
		}

		public void display() {
			if (!errors.isEmpty()) {
				displaySpecificErrors();
				displayOverallMessage();
			}
		}

		private void displaySpecificErrors() {
			for (Entry<String, Throwable> entry : errors.entrySet()) {
				LogUtil.log(entry.getKey(), entry.getValue());
			}
		}

		private void displayOverallMessage() {
			final String msg = "Errors were encountered whilst processing your patches for the generated GMF code.";
			LogUtil.log(msg, new IllegalStateException(msg), true);
		}
	}
	
	public static class PatchApplicationException extends Exception {

		// Generated by Eclipse
		private static final long serialVersionUID = -5242660513183244609L;

		public PatchApplicationException(String message) {
			super(message);
		}
	}
}
