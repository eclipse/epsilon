package org.eclipse.epsilon.eol.compile.context;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.common.module.ModuleMarker.Severity;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class EolCompilationContext {

	protected List<ModuleMarker> markers = new ArrayList<ModuleMarker>();
	protected IEolContext runtimeContext = null;
	protected FrameStack frameStack = new FrameStack();
	
	public List<ModuleMarker> getMarkers() {
		return markers;
	}
	
	public void setRuntimeContext(IEolContext context) {
		this.runtimeContext = context;
	}

	public void addWarningMarker(AbstractModuleElement element, String message) {
		markers.add(new ModuleMarker(element, message, Severity.Warning));
	}

	public void addErrorMarker(AbstractModuleElement element, String message) {
		markers.add(new ModuleMarker(element, message, Severity.Error));
	}
	
	public FrameStack getFrameStack() {
		return frameStack;
	}
	
}
