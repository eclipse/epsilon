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
package org.eclipse.epsilon.common.util;

import javax.swing.JOptionPane;

public class DebugUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
	public static void msgbox(Object message){
		JOptionPane.showMessageDialog(null, message);
	}
	
	public static void freeze (long millis) {
		long now = System.currentTimeMillis();
		while (System.currentTimeMillis() < now + millis) {
			System.out.print("");
		}
	}
	
	public static void showStackTrace() {
		new Exception().printStackTrace();
	}
}
