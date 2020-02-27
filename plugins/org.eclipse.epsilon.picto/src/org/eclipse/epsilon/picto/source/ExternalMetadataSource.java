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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.epsilon.flexmi.FlexmiResourceFactory;
import org.eclipse.epsilon.picto.PictoSource;
import org.eclipse.epsilon.picto.dom.Picto;
import org.eclipse.epsilon.picto.dom.PictoFactory;
import org.eclipse.ui.IEditorPart;

public abstract class ExternalMetadataSource implements PictoSource {

	@Override
	public Picto getRenderingMetadata(IEditorPart editorPart) {
		IFile file = getFile(editorPart);
		IFile renderingMetadataFile = file.getParent().getFile(Path.fromPortableString(file.getName() + ".picto"));
		if (renderingMetadataFile.exists()) {
			Picto picto = getFromFlexmi(renderingMetadataFile);
			if (picto == null) picto = getFromProperties(renderingMetadataFile);
			return picto;
		}
		return null;
	}
	
	protected Picto getFromProperties(IFile file) {
		Properties properties = new Properties();
		try {
			properties.load(file.getContents(true));
			Picto picto = PictoFactory.eINSTANCE.createPicto();
			picto.setFormat(properties.getProperty("format", "text"));
			picto.setTemplate(properties.getProperty("file"));
			if (properties.contains("template")) picto.setTemplate(properties.getProperty("template"));
			System.out.println(picto);
			return picto;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	protected Picto getFromFlexmi(IFile file) {
		try {
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new FlexmiResourceFactory());
			Resource resource = resourceSet.getResource(URI.createFileURI(file.getLocation().toOSString()), true);
			resource.load(null);
			System.out.println((Picto) resource.getContents().iterator().next());
			return (Picto) resource.getContents().iterator().next();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
