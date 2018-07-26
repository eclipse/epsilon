/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.tasks;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.execute.CommandLineFixer;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;

public class EvlTask extends ExportableModuleTask {
	
	protected String exportConstraintTrace;
	
	public String getExportConstraintTrace() {
		return exportConstraintTrace;
	}

	public void setExportConstraintTrace(String exportConstraintTrace) {
		this.exportConstraintTrace = exportConstraintTrace;
	}

	@Override
	protected IEolModule createModule() {
		return new EvlModule();
	}

	@Override
	protected void initialize() throws Exception {
		IEvlModule evlModule = (IEvlModule) module;
		CommandLineFixer clf = new CommandLineFixer();
		clf.setFix(false);
		evlModule.setUnsatisfiedConstraintFixer(clf);
	}

	@Override
	protected void examine() throws Exception {
		super.examine();
		
		IEvlModule evlModule = (IEvlModule) module;
		int errors = 0;
		int warnings = 0;
		for (UnsatisfiedConstraint unsatisfiedConstraint : evlModule.getContext().getUnsatisfiedConstraints()){
			if (unsatisfiedConstraint.getConstraint().isCritique()) {
				if (!unsatisfiedConstraint.getConstraint().isInfo()) {
					warnings ++;
				}
			}
			else {
				errors ++;
			}
		}
		log("Errors : " + errors);
		
		final String message = errors + " error(s) and " + warnings + " warning(s) found during validation";
		if (errors > 0) {
			fail(message, null);
		}
		else if (warnings > 0) {
			warn(message);
		}
		
		if (exportConstraintTrace != null) {
			getProjectStackFrame().put(exportConstraintTrace, 
					evlModule.getContext().getConstraintTrace());
		}
	}

	@Override
	protected Collection<Class<?>> getClassesForExportedModel() {
		Collection<Class<?>> classes = new ArrayList<Class<?>>();
		classes.add(UnsatisfiedConstraint.class);
		return classes;
	}

	@Override
	protected ArrayList<Object> getObjectsForExportedModel() {
		return new ArrayList<Object>(((EvlModule)module).getContext().getUnsatisfiedConstraints());
	}
}
