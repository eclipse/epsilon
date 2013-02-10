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
package org.eclipse.epsilon.common.util;

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
					
					boolean parentIsJar = false;
					
					if (parent.toString().startsWith("jar:file:/")) {
						parentIsJar = true;
						parent = new URI(parent.toString().replace("jar:file:/", "jar:/"));
					}
					
					URI resolved = parent.resolve(path);
					
					if (resolved.isAbsolute() && resolved.getScheme() != null) {
						if (parentIsJar) {
							resolved = new URI(resolved.toString().replace("jar:/", "jar:file:/"));
						}
						return resolved;
					}
					else {
						return new URI(parent.toString() + path);
					}
				}
			}
		}
		
		return new URI("file://" + uri);
	}
	
	public static String encode(String s, boolean isDirectory) {
		s = s.replaceAll(" ",    "%20");
		s = s.replaceAll("\\\\", "/");
		
		if (isDirectory && !s.endsWith("/"))
			s += "/";
		
		return s;
	}
	
	public static URI fileToUri(File file) throws URISyntaxException {
		final String encoded = UriUtil.encode(file.getAbsolutePath(), file.isDirectory());
		
		return new URI("file://" + (encoded.startsWith("/") ? encoded : '/' + encoded));
	}

	public static String getName(URI uri) {
		if (uri.getPath().contains("/"))
			return uri.getPath().substring(uri.getPath().lastIndexOf('/')+1);
		else
			return uri.getPath();
	}
}
