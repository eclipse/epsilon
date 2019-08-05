/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl;

import java.net.URI;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.spec.EglTemplateSpecification;

public class EglFileGeneratingTemplateFactory extends EglTemplateFactory {
	
	protected URI outputRoot;
	
	public EglFileGeneratingTemplateFactory() {
		super();
	}
	
	public EglFileGeneratingTemplateFactory(IEglContext context) {
		super(context);
	}

	public String getOutputRoot() {
		return outputRoot.toString();
	}
	
	public void setOutputRoot(String path) throws EglRuntimeException {
		outputRoot = resolveRoot(path);
	}

	@Override
	protected EglTemplate createTemplate(EglTemplateSpecification spec) throws Exception {
		return new EglFileGeneratingTemplate(spec, context, getOutputRootOrRoot());
	}
	
	protected URI getOutputRootOrRoot() {
		return outputRoot != null ? outputRoot : root;
	}
}
