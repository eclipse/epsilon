/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/

package org.eclipse.epsilon.emc.simulink.engine;

public class MatlabEngineCommands {
	
	/** COMMANDS */
	public static final String ASSIGN = "? = ?";
	public static final String INSPECT = "inspect(?);";
	public static final String HANDLE = "handle = ?;";
	public static final String HANDLES = "handles = ";
	public static final String INSPECT_HANDLE = "inspect(handle);";
	
	public static final String GET_HANDLE_PROPERTY = "get_param(handle, '?');";
	public static final String GET_PROPERTY = "get_param(?, '?');";
	public static final String SET_HANDLE_PROPERTY = "set_param(handle, '?', '?');";
	public static final String SET_PROPERTY = "set_param(?, '?', '?');";

	/** OPERATION */
	public static final String LINE_BREAK = "\n";
	public static final String COMMAND_END = ";";
	public static final String SEP = " ";
		
	public static final String HANDLE_INSPECT_HANDLE = HANDLE + INSPECT_HANDLE;
	public static final String GET_PROPERTY_FROM_HANDLE = HANDLE + GET_HANDLE_PROPERTY;
	public static final String SET_PROPERTY_TO_HANDLE = HANDLE + SET_HANDLE_PROPERTY;
	
	private static final int SILENT = 0;
	private static final int DEBUG = 1;
	
	protected static String chain(String[] commands, int mode) {
		StringBuilder builder = new StringBuilder();
		for(String s : commands) {
			String sep = " ";
			switch (mode) {
			case SILENT:
				// Does not print command result
				sep = COMMAND_END; 
			case DEBUG:
				// Prints command result at end of line
				sep = LINE_BREAK; 
			}
		    builder.append(s + sep);
		}
		return builder.toString();
	}
	
	public static String simulinkHandle(String cmd, String handle, Object...params) {
		if (handle == null || handle.isEmpty()) {
			handle = "handle";
		}
		String c = cmd + "(" + handle;
		for (Object parameter : params) 
			c += ", '" + String.valueOf(parameter).replace("'", "''") + "'";
		return c + ")";
	}
	public static String simulink(String cmd, Object...params) {
		return simulinkHandle(cmd, "handle", params);
	}
	
	public static String cmd(String cmd, Object... args) {
		return String.format(cmd, args);
	}
	
}
