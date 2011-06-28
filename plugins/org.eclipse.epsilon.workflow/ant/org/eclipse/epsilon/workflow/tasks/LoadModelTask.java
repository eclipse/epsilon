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

import java.util.ArrayList;

import org.apache.tools.ant.BuildException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.common.dt.launching.extensions.ModelTypeExtension;
import org.eclipse.epsilon.commons.profiling.Profiler;
import org.eclipse.epsilon.commons.util.StringProperties;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.workflow.tasks.nestedelements.ParameterNestedElement;

public class LoadModelTask extends EpsilonTask{

	protected String name;
	protected String type;
	protected String config;
	protected ArrayList<ParameterNestedElement> parameterNestedElements = new ArrayList<ParameterNestedElement>();
	//public static BuildFinishedListener BuildFinishedListener;
	
	@Override
	public void executeImpl() throws BuildException {	
		
		ShutdownProjectRepositoryListener.activate(getProject(), getProjectRepository());
		
		/*
		if (BuildFinishedListener == null) {
			BuildFinishedListener = new BuildFinishedListener() {
				@Override
				public void buildFinished(BuildEvent event) {
					getProjectRepository().dispose();
				}
			};
			getProject().addBuildListener(BuildFinishedListener);
		}*/
		
		if (profile) Profiler.INSTANCE.start("Load model : " + name);
		IModel model = createModel(type);
		try {
			//model.load(getStringProperties(), getBaseDir().getAbsolutePath());
			model.load(getStringProperties(), null);
			model.setName(name);
			getProjectRepository().addModel(model);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BuildException(e);
		}
		finally {
			if (profile) Profiler.INSTANCE.stop("Load model : " + name);
		}
	}
	
	protected IModel createModel(String type) throws BuildException {
		try {
			IModel model = ModelTypeExtension.forType(type).createModel();
			return model;
		} catch (CoreException e) {
			throw new BuildException(e);
		}
	}
	
	protected StringProperties getStringProperties() {
		StringProperties properties = new StringProperties();
		for (ParameterNestedElement parameterNestedElement : parameterNestedElements) {
			properties.put(parameterNestedElement.getName(), parameterNestedElement.getValue());
		}
		return properties;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ParameterNestedElement createParameter() {
		ParameterNestedElement parameterNestedElement = new ParameterNestedElement();
		parameterNestedElements.add(parameterNestedElement);
		return parameterNestedElement;
	}
}
