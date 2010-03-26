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
package org.eclipse.epsilon.common.dt.util;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.epsilon.common.dt.EpsilonCommonsPlugin;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

public class LogUtil {
	
	public static void log(int severity, int code, String message, Exception ex) {
		EpsilonCommonsPlugin.getDefault().getLog().log(new Status(severity, "org.eclipse.epsilon.common.dt", code, message, ex));
	}
	
	public static void logInfo(Object message) {
		logInfo(message.toString(), false);
	}
	
	public static void logInfo(Object message, boolean openInfoDialog) {
		EpsilonCommonsPlugin.getDefault().getLog().log(new Status(IStatus.INFO, "org.eclipse.epsilon.common.dt", message.toString()));
		if (openInfoDialog) {
			MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Information", message.toString());
		}
	}
	
	public static void log(String message, Exception ex) {
		log(IStatus.ERROR, 0, message, ex);
		//MessageDialog.openError(null, "Error", message + "\r\nPlease check the error log for further information");
	}
	
	public static void log(String message, Exception ex, boolean openErrorDialog) {
		log(message, ex);
		if (openErrorDialog) 
			MessageDialog.openError(Display.getDefault().getActiveShell(), "Error", message + "\r\nPlease check the error log for further information");
	}
	
	
	
	public static void log(Exception ex) {
		log(ex.getMessage(), ex);
	}
}
