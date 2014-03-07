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
package org.eclipse.epsilon.egl.execute.control;

import org.eclipse.epsilon.egl.EglPersistentTemplate;
import org.eclipse.epsilon.egl.EglTemplate;

public class DefaultTemplateExecutionListener implements ITemplateExecutionListener {

	@Override
	public void aboutToProcess(EglTemplate template) {}

	@Override
	public void finishedProcessing(EglTemplate template) {}

	@Override
	public void finishedGenerating(EglPersistentTemplate template, String path) {}

}
