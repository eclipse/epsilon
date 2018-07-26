/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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
