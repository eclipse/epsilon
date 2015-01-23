package org.eclipse.epsilon.eol.compile.context;

import java.util.List;

import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public interface IEolCompilationContext {

	public List<ModuleMarker> getMarkers();
	
	public void setRuntimeContext(IEolContext context);
	
}
