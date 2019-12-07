/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.flexmi;

public interface StringSimilarityProvider extends java.util.Comparator<String> {
	
	public int getSimilarity(String one, String other);
	
	@Override
	default int compare(String o1, String o2) {
		return getSimilarity(o1, o2);
	}
}
