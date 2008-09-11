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
package org.eclipse.epsilon.productivity;

import java.io.FileOutputStream;
import java.net.URI;

import org.eclipse.core.resources.IFile;
import org.eclipse.epsilon.egl.EglModule;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.execute.context.Variable;

public abstract class AbstractECoreGenerationAction extends AbstractECoreModelAction {
	
	protected IFile file;
	protected EmfModel model;
	protected String name;
	
	@Override
	protected void perform(IFile file, EmfModel model) throws Exception {
		this.file = file;
		this.model = model;
		EglModule module = new EglModule();
		module.parse(getTemplateUri());
		module.getContext().getModelRepository().addModel(model);
		name = file.getName().substring(0, file.getName().length() - 6);
		module.getContext().getFrameStack().getGlobals().put(Variable.createReadOnlyVariable("eCoreName", name));
		module.execute();
		module.getContext().getModelRepository().dispose();
		
		FileOutputStream fos = new FileOutputStream(file.getParent().getLocation().toOSString() + "/" + getTargetFile());
		fos.write(module.getContext().getOutputBuffer().toString().getBytes());
		fos.flush();
		fos.close();
		
		file.getParent().refreshLocal(1, null);

	}
	
	abstract protected URI getTemplateUri() throws Exception;
	
	abstract protected String getTargetFile();
}
