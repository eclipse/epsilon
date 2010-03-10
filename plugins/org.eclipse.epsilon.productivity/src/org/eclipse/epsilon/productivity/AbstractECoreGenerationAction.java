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

import java.net.URI;

import org.eclipse.core.resources.IFile;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplate;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
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
		
		final EglFileGeneratingTemplateFactory factory = new EglFileGeneratingTemplateFactory();
		
		factory.getContext().getModelRepository().addModel(model);
		name = file.getName().substring(0, file.getName().length() - 6);
		factory.getContext().getFrameStack().getGlobals().put(Variable.createReadOnlyVariable("eCoreName", name));
		
		// TODO cast is smelly
		final EglFileGeneratingTemplate template = (EglFileGeneratingTemplate)factory.load(getTemplateUri());
		
		template.generate(file.getParent().getLocation().toOSString() + "/" + getTargetFile());
		
		factory.getContext().getModelRepository().dispose();
		
		file.getParent().refreshLocal(1, null);

	}
	
	abstract protected URI getTemplateUri() throws Exception;
	
	abstract protected String getTargetFile();
}
