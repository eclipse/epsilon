/*********************************************************************
 * Copyright (c) 2019 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.execute.concurrent;

import org.eclipse.epsilon.common.concurrent.SingleConcurrentExecutionStatus;

/**
 * 
 *
 * @author Sina Madani
 * @since 1.6
 */
public class EolConcurrentExecutionStatus extends SingleConcurrentExecutionStatus {

	public EolConcurrentExecutionStatus() {
		waitTimeout = Short.MAX_VALUE;
	}

}
