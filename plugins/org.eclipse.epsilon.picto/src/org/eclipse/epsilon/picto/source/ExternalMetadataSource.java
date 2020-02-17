/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.picto.source;

import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.picto.PictoMetadata;
import org.eclipse.epsilon.picto.PictoSource;
import org.eclipse.ui.IEditorPart;

public abstract class ExternalMetadataSource implements PictoSource {

	@Override
	public PictoMetadata getRenderingMetadata(IEditorPart editorPart) {
		IFile file = getFile(editorPart);
		IFile renderingMetadataFile = file.getParent().getFile(Path.fromPortableString(file.getName() + ".picto"));
		if (renderingMetadataFile.exists()) {
			PictoMetadata metadata = new PictoMetadata();
			Properties properties = new Properties();
			try {
				properties.load(renderingMetadataFile.getContents(true));
				metadata.setFormat(properties.getProperty("format", "text"));
				metadata.setFile(properties.getProperty("file"));
				metadata.setNsuri(properties.getProperty("nsuri"));
				return metadata;
			} catch (Exception e) {
				LogUtil.log(e);
			}
		}
		return null;
	}

}
