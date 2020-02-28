/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.egl.launch;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.egl.IEgxModule;
import org.eclipse.epsilon.egl.concurrent.atomic.EgxModuleParallelGenerationRuleAtoms;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.concurrent.EgxContextParallel;
import org.eclipse.epsilon.erl.launch.IErlRunConfiguration;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EgxRunConfiguration extends IErlRunConfiguration {
	
	@SuppressWarnings("unchecked")
	public static class Builder<C extends EgxRunConfiguration, B extends Builder<C, B>> extends IErlRunConfiguration.Builder<C, B> {
		
		public Path outputRoot;
		public boolean persistOutput = true;
		public boolean deleteOutputDirBefore = false;
		
		public B withoutPersistence() {
			return withPersistence(false);
		}
		public B withPersistence(boolean persist) {
			this.persistOutput = persist;
			return (B) this;
		}	
		
		public B withFreshOutputDir() {
			return withFreshOutputDir(true);
		}
		public B withFreshOutputDir(boolean deleteBeforeRun) {
			this.deleteOutputDirBefore = deleteBeforeRun;
			return (B) this;
		}
		
		public B withOutputRoot(String output) {
			return withOutputRoot(Paths.get(output));
		}
		public B withOutputRoot(Path output) {
			this.outputRoot = output;
			return (B) this;
		}
		
		protected Builder() {
			super();
		}
		protected Builder(Class<C> runConfigClass) {
			super(runConfigClass);
		}
		
		@Override
		protected IEgxModule createModule() {
			return isParallel() ? new EgxModuleParallelGenerationRuleAtoms(new EgxContextParallel(parallelism)) : new EgxModule();
		}
	}
	
	public static Builder<? extends EgxRunConfiguration, ?> Builder() {
		return new Builder<>(EgxRunConfiguration.class);
	}
	
	protected final URI outputRoot;
	protected final boolean persistOutput, deleteBeforeRun;
	
	public EgxRunConfiguration(Builder<? extends EgxRunConfiguration, ?> builder) {
		super(builder);
		Path output = builder.outputRoot;
		if (output == null) {
			output = (outputFile != null ? outputFile : script).getParent();
		}
		this.outputRoot = output.toUri();
		this.persistOutput = builder.persistOutput;
		this.deleteBeforeRun = builder.deleteOutputDirBefore;
	}
	
	public EgxRunConfiguration(EgxRunConfiguration other) {
		super(other);
		this.outputRoot = other.outputRoot;
		this.persistOutput = other.persistOutput;
		this.deleteBeforeRun = other.deleteBeforeRun;
	}
	
	protected EglTemplateFactory getDefaultTemplateFactory() throws EglRuntimeException {
		EglTemplateFactory templateFactory;
		if (!persistOutput) {
			templateFactory = new EglTemplateFactory();
		}
		else {
			templateFactory = new EglFileGeneratingTemplateFactory(Paths.get(outputRoot));
		}
		templateFactory.setTemplateRoot(script.getParent().toUri().toString());
		return templateFactory;
	}
	
	@Override
	public IEgxModule getModule() {
		return (IEgxModule) super.getModule();
	}
	
	@Override
	public void preExecute() throws Exception {
		getModule().getContext().setTemplateFactory(getDefaultTemplateFactory());
		if (deleteBeforeRun) {
			File outputContents = new File(outputRoot);
			if (outputContents.exists()) {
				if (outputContents.isFile()) {
					outputContents.delete();
				}
				else for (File f : outputContents.listFiles()) {
					f.delete();
				}
			}
		}
		super.preExecute();
	}
	
	@Override
	public Object getResult() {
		if (result == null) try {
			result = FileUtil.readDirectory(outputRoot.toString());
		}
		catch (java.io.IOException iox) {
			iox.printStackTrace();
		}
		return super.getResult();
	}
}