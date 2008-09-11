/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.commons.util;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public abstract class UriUtil {

	// Uninstantiable class
	private UriUtil() {}
	
	public static URI resolve(String path, URI... relativeTo) throws URISyntaxException {
		if (path == null)
			return null;
		
		final URI uri = new URI(path);
		
		if (uri.isAbsolute())
			return uri;
		
		else {
			for (URI parent : relativeTo) {
				if (parent!=null) {
					
					final URI resolved = parent.resolve(path);
					
					if (resolved.isAbsolute() && resolved.getScheme() != null)
						return resolved;
					
					else	
						return new URI(parent.toString() + path);
				}
			}
		}
		
		return uri;
	}
	
	public static String encode(String s, boolean isDirectory) {
		s = s.replaceAll(" ",    "%20");
		s = s.replaceAll("\\\\", "/");
		
		if (isDirectory && !s.endsWith("/"))
			s += "/";
		
		return s;
	}
	
	public static URI fileToUri(File file) throws URISyntaxException {
		return new URI("file:///" + UriUtil.encode(file.getAbsolutePath(), file.isDirectory())); 
	}

	public static String getName(URI uri) {
		if (uri.getPath().contains("/"))
			return uri.getPath().substring(uri.getPath().lastIndexOf('/')+1);
		else
			return uri.getPath();
	}
}
