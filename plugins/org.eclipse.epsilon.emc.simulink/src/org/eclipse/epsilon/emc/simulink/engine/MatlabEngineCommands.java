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
	
}
