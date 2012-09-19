/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.formatter.simple;

import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.egl.formatter.Formatter;

public class ReverseFormatter implements Formatter {

	@Override
	public String format(String text) {
		return StringUtil.reverse(text);
	}
}