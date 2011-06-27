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
package org.eclipse.epsilon.workflow.tasks;

import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.IEtlModule;
import org.eclipse.epsilon.etl.dt.launching.EtlDebugger;
import org.eclipse.epsilon.etl.TransformRule;
import org.eclipse.epsilon.etl.trace.Transformation;
import org.eclipse.epsilon.etl.trace.TransformationTrace;
import org.eclipse.epsilon.etl.trace.Transformations;
import org.eclipse.epsilon.workflow.tasks.common.ExportableModuleTask;

public class EtlTask extends ExportableModuleTask {
	
	protected String exportTransformationTrace;
	public String getExportTransformationTrace() {
		return exportTransformationTrace;
	}

	public void setExportTransformationTrace(String exportTransformationTrace) {
		this.exportTransformationTrace = exportTransformationTrace;
	}
	
	@Override
	protected void initialize() throws Exception {}
	
	@Override
	protected IEtlModule createModule() {
		return new EtlModule();
	}
	
	@Override
	protected void examine() throws Exception {
		super.examine();
		
		final IEtlModule etlModule = (IEtlModule) module;

		if (exportTransformationTrace != null) {
			getProjectStackFrame().put(exportTransformationTrace,
					etlModule.getContext().getTransformationTrace());
		}
	}
	
	@Override
	public EolDebugger createDebugger() {
		return new EtlDebugger();
	}

	@Override
	protected Collection<? extends Object> getObjectsForExportedModel() {
		final TransformationTrace trace = ((IEtlModule)module).getContext().getTransformationTrace();
		return Collections.singleton(trace);
	}

	@Override
	protected Collection<Class<?>> getClassesForExportedModel() {
		Collection<Class<?>> classes = new ArrayList<Class<?>>();
		classes.add(TransformationTrace.class);
		classes.add(Transformations.class);
		classes.add(Transformation.class);
		classes.add(TransformRule.class);
		return classes;
	}
}
