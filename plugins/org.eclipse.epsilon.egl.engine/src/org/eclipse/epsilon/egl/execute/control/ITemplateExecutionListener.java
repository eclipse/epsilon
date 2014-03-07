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

public interface ITemplateExecutionListener {

	public void aboutToProcess(EglTemplate template);
	
	public void finishedProcessing(EglTemplate template);
	
	public void finishedGenerating(EglPersistentTemplate template, String path);
}
