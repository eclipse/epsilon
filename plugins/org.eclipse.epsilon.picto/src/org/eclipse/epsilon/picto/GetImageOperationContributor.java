/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.picto;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.epsilon.egl.IEgxModule;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;
import org.eclipse.epsilon.eol.types.EolNoType;

public class GetImageOperationContributor extends OperationContributor {
	
	protected IEgxModule module;
	protected static Map<String, String> cache = new HashMap<>();
	
	public GetImageOperationContributor(IEgxModule module) {
		this.module = module;
	}
	
	@Override
	public boolean contributesTo(Object target) {
		return target == EolNoType.NoInstance;
	}
	
	public String getImage(String path) {
		if (module.getFile() != null) {
			return new File(module.getFile().getParent(), path).getAbsolutePath();
		}
		else if (module.getUri() != null) {
			try {
				URI imageUri = module.getUri().resolve(path);

				String tempImagePath = null;
				synchronized (cache) {
					tempImagePath = cache.get(imageUri.toString());
					if (tempImagePath == null) {
						try (InputStream in = imageUri.toURL().openStream()) {
							Path temp = Files.createTempFile("picto", Paths.get(path).getFileName().toString());
							Files.copy(in, temp, StandardCopyOption.REPLACE_EXISTING);
							tempImagePath = temp.toAbsolutePath().toString();
							cache.put(imageUri.toString(), tempImagePath);
						}
					}
				}
				return tempImagePath;
			} catch (Exception e) {}
		}
		return path;
	}
}
