package org.eclipse.epsilon.evl.engine.launch;

import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.engine.launch.*;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

public class EvlRunConfiguration extends EolRunConfiguration<IEvlModule> {
	
	public EvlRunConfiguration(
		Path evlFile,
		Map<IModel, StringProperties> modelsAndProperties,
		Optional<IEvlModule> evlModule,
		Optional<Map<String, Object>> parameters,
		Optional<Boolean> showResults,
		Optional<Boolean> profileExecution,
		Optional<Integer> configID,
		Optional<Path> scratchFile) {
			super(
				evlFile,
				modelsAndProperties,
				evlModule,
				parameters,
				showResults,
				profileExecution,
				configID, scratchFile
			);
	}
	
	public EvlRunConfiguration(EvlRunConfiguration other) {
		this(
			other.script,
			other.modelsAndProperties,
			Optional.of(other.module),
			Optional.of(other.parameters),
			Optional.of(other.showResults),
			Optional.of(other.profileExecution),
			Optional.of(other.id),
			Optional.of(other.outputFile)
		);
	}
	
	@Override
	protected IEvlModule getDefaultModule() {
		return new EvlModule();
	}
	
	@Override
	protected void postExecute() throws Exception {
		super.postExecute();
		
		if (showResults || profileExecution) {
			IEvlContext context = module.getContext();
			int numUnsatisfied = context.getUnsatisfiedConstraints().size();
			if (numUnsatisfied > 0) {
				writeOut(numUnsatisfied+" constraint"+(numUnsatisfied > 1 ? "s have" : " has")+" not been satisfied"+(showResults ? ':' : '.'));
				if (showResults) {
					writeOut(context.getUnsatisfiedConstraintsBySize().entrySet());
				}
			}
			else {
				writeOut("All constraints have been satisfied.");
			}
			writeOut(printMarker);
		}
	}
}