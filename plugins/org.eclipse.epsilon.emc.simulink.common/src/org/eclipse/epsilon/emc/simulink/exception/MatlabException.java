/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.exception;

public class MatlabException extends Exception {

	private static final long serialVersionUID = -2998670342449368598L;

	private static final String ERROR = "Matlab Engine Error:\n %s.\n %s";
	private static final String TOO_MANY_OUTPUT = "Too many output arguments";
	private static final String SIGNATURE_ERROR = "matching signature";
	
	public MatlabException(Exception e) {
		super(String.format(ERROR, (e.getCause() != null) ? e.getCause().getMessage() : "",
				(e.getCause().getCause() != null) ? e.getCause().getCause().getMessage() : ""), e.getCause());
	}

	public boolean isTooManyOutput() {
		return getMessage().contains(TOO_MANY_OUTPUT);
	}
	
	public boolean isMatchingSignatureError() {
		return getMessage().contains(SIGNATURE_ERROR);
	}
}