package org.eclipse.epsilon.eol.launch;

import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.models.IModel;

public class EolRunConfiguration extends IEolRunConfiguration<EolModule, Object> {

	public EolRunConfiguration(
		Path eolFile,
		Map<IModel, StringProperties> modelsAndProperties,
		Optional<EolModule> eolModule,
		Optional<Map<String, ?>> parameters,
		Optional<Boolean> showResults,
		Optional<Boolean> profileExecution,
		Optional<Integer> configID,
		Optional<Path> scratchFile) {
			super(eolFile, modelsAndProperties, eolModule, parameters, showResults, profileExecution, configID, scratchFile);
	}
	
	public EolRunConfiguration(Path eolFile) {
		this(eolFile, null);
	}
	
	public EolRunConfiguration(Path eolFile, Map<IModel, StringProperties> modelsAndProperties) {
		this(eolFile, modelsAndProperties, null);
	}
	
	public EolRunConfiguration(Path eolFile,
		Map<IModel, StringProperties> modelsAndProperties,
		Map<String, ?> parameters) {
			super(eolFile, modelsAndProperties, null, parameters);
	}
	
	public EolRunConfiguration copy(IEolRunConfiguration<? extends EolModule, ?> other) {
		EolRunConfiguration copy = new EolRunConfiguration(
			other.script,
			other.modelsAndProperties,
			Optional.of(other.module),
			Optional.of(other.parameters),
			Optional.of(other.showResults),
			Optional.of(other.profileExecution),
			Optional.of(other.getId()),
			Optional.of(other.outputFile)
		);
		copy.result = other.getResult();
		return copy;
	}
	
	@Override
	protected EolModule getDefaultModule() {
		return new EolModule();
	}
}
