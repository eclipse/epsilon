/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eunit.execute.operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.compare.IModificationDate;
import org.eclipse.compare.IStreamContentAccessor;
import org.eclipse.compare.ITypedElement;
import org.eclipse.compare.structuremergeviewer.IStructureComparator;
import org.eclipse.swt.graphics.Image;

/**
 * Node for the difference engine which wraps a regular file.
 */
public class FilesystemTreeNode
	implements IStructureComparator, IModificationDate, ITypedElement, IStreamContentAccessor
{
	private final File file;

	public FilesystemTreeNode(File file) {
		this.file = file;
	}

	@Override
	public String getName() {
		return file.getName();
	}

	@Override
	public String getType() {
		if (file.isDirectory()) {
			return ITypedElement.FOLDER_TYPE;
		}
		else {
			final String extension = getExtension();
			if (extension != null) {
				return extension;
			}
			else {
				return ITypedElement.UNKNOWN_TYPE;
			}
		}
	}

	private String getExtension() {
		final String name = file.getName();
		final int lastDot = name.lastIndexOf('.');
		String extension = null;
		if (lastDot != -1) {
			extension = name.substring(lastDot + 1);
		}
		return extension;
	}

	@Override
	public long getModificationDate() {
		return file.lastModified();
	}

	@Override
	public Object[] getChildren() {
		File[] files = file.listFiles();
		if (files == null) return files;

		List<FilesystemTreeNode> children = new ArrayList<FilesystemTreeNode>();
		for (File childFile : file.listFiles()) {
			children.add(new FilesystemTreeNode(childFile));
		}
		return children.toArray();
	}

	@Override
	public Image getImage() {
		return null;
	}

	@Override
	public InputStream getContents() {
		try {
			return new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// FIXME use proper logging here, after moving to eunit.dt
			e.printStackTrace();
			return null;
		}
	}

}
