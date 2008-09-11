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

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class ClipboardUtil {

	public static void copyToClipboard(String str, boolean asHtml){
		
		 Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		 if (asHtml) {
			 clipboard.setContents(new HtmlTransferable(str),null);
		 }
		 else {
			 clipboard.setContents(new StringSelection(str), null);
		 }
	}

}
