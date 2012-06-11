/*******************************************************************************
 * Copyright (c) 2012 The University of York, Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - add type parameter and serial version UID
 ******************************************************************************/
package org.eclipse.epsilon.eol.types;

import java.util.HashSet;

import org.eclipse.epsilon.eol.types.CollectionAnnotator.AnnotatedCollectionType;

public class EolSet<T> extends HashSet<T> {
	private static final long serialVersionUID = -5092429015394416636L;

	public EolSet() {
		super();
		CollectionAnnotator.getInstance().annotate(this, AnnotatedCollectionType.Set);
	}
}
