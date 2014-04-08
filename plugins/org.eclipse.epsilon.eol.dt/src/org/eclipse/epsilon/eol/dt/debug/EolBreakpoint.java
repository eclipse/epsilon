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

package org.eclipse.epsilon.eol.dt.debug;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IBreakpointListener;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.LineBreakpoint;
import org.eclipse.epsilon.common.dt.util.LogUtil;

public class EolBreakpoint extends LineBreakpoint {
	
	public static EolBreakpointUpdater updater = null;
	
	public EolBreakpoint() {
		super();
		configureUpdater();
	}
	
	public EolBreakpoint(final IResource resource, final int lineNumber) throws CoreException {
		
		IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				IMarker marker = resource.createMarker(EolDebugConstants.BREAKPOINT_MARKER);
				setMarker(marker);
				marker.setAttribute(IBreakpoint.ENABLED, Boolean.TRUE);
				marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
				marker.setAttribute(IBreakpoint.ID, getModelIdentifier());
				marker.setAttribute(IMarker.MESSAGE, getMessage(resource, lineNumber));
			}
		};
		getLineNumber();
		run(getMarkerRule(resource), runnable);
		configureUpdater();
	}
	
	protected String getMessage(IResource resource, int lineNumber) {
		return "Line breakpoint:" + resource.getName() + " [line: " + lineNumber + "]";
	}
	
	protected void configureUpdater() {
		if (updater == null) {
			updater = new EolBreakpointUpdater();
			DebugPlugin.getDefault().getBreakpointManager().addBreakpointListener(updater);
		}
	}
	
	public String getModelIdentifier() {
		return EolDebugConstants.MODEL_IDENTIFIER;
	}
	
	class EolBreakpointUpdater implements IBreakpointListener {

		public void breakpointAdded(IBreakpoint breakpoint) {
			// TODO Auto-generated method stub
			
		}

		public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
			// TODO Auto-generated method stub
			
		}

		public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
			if (breakpoint instanceof EolBreakpoint) {
				try {
					((EolBreakpoint) breakpoint).setAttribute(IMarker.MESSAGE, getMessage(breakpoint.getMarker().getResource(), ((EolBreakpoint) breakpoint).getLineNumber()));
				} catch (CoreException e) {
					LogUtil.log(e);
				}
			}
		}
		
	}
	
}
 