package org.eclipse.epsilon.eol.compile.context;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class EolCompilationContext implements IEolCompilationContext {
	
	protected List<ModuleMarker> markers = new ArrayList<ModuleMarker>();
	protected IEolContext runtimeContext = null;
	
	public List<ModuleMarker> getMarkers() {
		return markers;
	}
	
	@Override
	public void setRuntimeContext(IEolContext context) {
		this.runtimeContext = context;
	}
}
