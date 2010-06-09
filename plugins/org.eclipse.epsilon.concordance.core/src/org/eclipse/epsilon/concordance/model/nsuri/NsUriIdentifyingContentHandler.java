/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.concordance.model.nsuri;

import org.xml.sax.helpers.DefaultHandler;

public class NsUriIdentifyingContentHandler extends DefaultHandler {

	private String nsUri;
	
	@Override
	public void startPrefixMapping(String prefix, String uri) {
		if ("xmi".equals(prefix) || "xsi".equals(prefix))
			return;
		
		nsUri = uri;
	}
	
	public String getNsUri() {
		return nsUri;
	}
}
