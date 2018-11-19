/*******************************************************************************
 * Copyright (c) 2008-2018 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Sina Madani - CPU info
******************************************************************************/
package org.eclipse.epsilon.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OperatingSystem {
	private OperatingSystem() {}
	
    public static boolean isWindows() {
        return System.getProperty("os.name").indexOf("Windows") > -1;
    }
    
    public static boolean isUnix() {
        return !isWindows();
    }
    
    public static boolean isWindowsVista() {
        return isWindows() && System.getProperty("os.name").indexOf("Vista") > -1;
    }

	public enum OSFamily {
		WINDOWS,
		UNIX,
		LINUX,
		SOLARIS,
		MAC,
		OTHER;
		
		public static OSFamily getOSFamily() {
			switch (System.getProperty("os.name").substring(0, 3).toLowerCase()) {
				case "win": return WINDOWS;
				case "lin": case "deb": case "cen": case "fed": case "ubu": case "and": case "arc": return LINUX;
				case "uni": return UNIX;
				case "mac": case "ios": case "dar": return MAC;
				case "sun": case "sol": return SOLARIS;
				default: return OTHER;
			}
		}
	}
	
	/**
	 * Executes the given command(s) natively.
	 * @param args The commands.
	 * @return The output.
	 * @throws IOException
	 * @since 1.6
	 */
	public static String execCmd(String... args) throws IOException {
		Process process = new ProcessBuilder(args).redirectErrorStream(true).start();
		StringBuilder processOutput = new StringBuilder();

        try (BufferedReader processOutputReader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String readLine;
            while ((readLine = processOutputReader.readLine()) != null) {
                processOutput.append(readLine + System.lineSeparator());
            }
            try {
				process.waitFor();
			}
			catch (InterruptedException ex) {
				throw new IOException(ex);
			}
        }

        return processOutput.toString().trim();
	}
	
	/**
	 * Convenience method for getting the CPU model.
	 * @return The CPU model as reported by the operating system.
	 * @since 1.6
	 */
	public static String getCPUName() {
		try {
			switch (OSFamily.getOSFamily()) {
                case WINDOWS: return execCmd(
                    "powershell.exe", "-Command", "\"wmic CPU get NAME | findstr '@'\""
                );
                case MAC: return execCmd(
                    "/bin/sh", "-c", "sysctl -n machdep.cpu.brand_string"
                );
                default: return execCmd(
                    "/bin/sh", "-c", "cat /proc/cpuinfo | grep -m 1 'model name'"
                ).substring(13); // Removes the "model name    : " part
            }
		}
		catch (IOException ex) {
			System.err.println("Could not get CPU name: "+ex.getMessage());
			return "";
		}
	}
}

