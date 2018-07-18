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

public class OperatingSystem {
    
    public static boolean isWindows() {
        return System.getProperty("os.name").indexOf("Windows") > -1;
    }
    
    public static boolean isUnix() {
        return !isWindows();
    }
    
    public static boolean isWindowsVista() {
        return System.getProperty("os.name").indexOf("Windows") > -1
            && System.getProperty("os.name").indexOf("Vista") > -1;
    }
    
}
