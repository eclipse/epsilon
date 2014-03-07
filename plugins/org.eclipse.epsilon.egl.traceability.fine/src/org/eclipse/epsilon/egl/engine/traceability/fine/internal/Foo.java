/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.engine.traceability.fine.internal;

import java.util.Stack;

import org.eclipse.epsilon.common.util.Multimap;
import org.eclipse.epsilon.egl.EglTemplate;

public class Foo {
	public final Stack<EglTemplate> templates = new Stack<EglTemplate>();
	public final Multimap<EglTemplate, PropertyAccessWithPosition> currentLinks = new Multimap<EglTemplate, PropertyAccessWithPosition>();
}