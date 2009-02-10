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

package org.eclipse.epsilon.concordance.analysis;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.epsilon.concordance.index.CrossReference;

public class ResourceAnalytics {
	
	private Collection<String> elementIds = new ArrayList<String>();
	private Collection<CrossReference> crossReferences = new ArrayList<CrossReference>();
	
	public Collection<String> getElementIds() {
		return elementIds;
	}
	
	public Collection<CrossReference> getCrossReferences() {
		return crossReferences;
	}
	
}
 